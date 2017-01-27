package com.langellu.slack.webhook;

/**
 * Created by luca on 27/01/17.
 */
public class SlackMessage {

    private String text;

    public SlackMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
