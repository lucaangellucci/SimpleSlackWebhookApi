package com.langellu.slack.webhook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 27/01/17.
 */
public class SlackMessage {

    private final String text;

    private final List<SlackAttachment> attachments;

    private SlackMessage(String text, List<SlackAttachment> attachments) {
        this.text = text;
        this.attachments = attachments;
    }

    public String getText() {
        return text;
    }

    public List<SlackAttachment> getAttachments() {
        return attachments;
    }

    public static SlackMessageBuilder builder() {
        return new SlackMessageBuilder();
    }

    public static class SlackMessageBuilder {

        private String text;

        private List<SlackAttachment> attachments;

        public SlackMessageBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public SlackMessageBuilder addAttachment(SlackAttachment attachment) {
            if(attachments == null) {
                attachments = new ArrayList<>();
            }
            attachments.add(attachment);
            return this;
        }

        public SlackMessage build() {
            SlackMessage slackMessage = new SlackMessage(text, attachments);
            if(slackMessage.text == null && slackMessage.attachments == null) {
                throw new IllegalArgumentException("Invalid Argument. Text or Attachments is required");
            }
            return slackMessage;
        }
    }
}
