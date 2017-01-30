package com.langellu.slack.webhook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 27/01/17.
 */
public class SlackAttachment {

    private String fallback;

    private String color;

    private String pretext;

    private String authorName;

    private String authorLink;

    private String authorIcon;

    private String title;

    private String titleLink;

    private String text;

    private String imageUrl;

    private String thumbUrl;

    private String footer;

    private String footerIcon;

    private String ts;

    private List<SlackField> fields;

    private SlackAttachment(String fallback,
                            String color,
                            String pretext,
                            String authorName,
                            String authorLink,
                            String authorIcon,
                            String title,
                            String titleLink,
                            String text,
                            String imageUrl,
                            String thumbUrl,
                            String footer,
                            String footerIcon,
                            String ts,
                            List<SlackField> fields) {
        this.fallback = fallback;
        this.color = color;
        this.pretext = pretext;
        this.authorName = authorName;
        this.authorLink = authorLink;
        this.authorIcon = authorIcon;
        this.title = title;
        this.titleLink = titleLink;
        this.text = text;
        this.imageUrl = imageUrl;
        this.thumbUrl = thumbUrl;
        this.footer = footer;
        this.footerIcon = footerIcon;
        this.ts = ts;
        this.fields = fields;
    }

    public String getFallback() {
        return fallback;
    }

    public String getColor() {
        return color;
    }

    public String getPretext() {
        return pretext;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorLink() {
        return authorLink;
    }

    public String getAuthorIcon() {
        return authorIcon;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getFooter() {
        return footer;
    }

    public String getFooterIcon() {
        return footerIcon;
    }

    public String getTs() {
        return ts;
    }

    public List<SlackField> getFields() {
        return fields;
    }

    public static SlackAttachmentBuilder builder() {
        return new SlackAttachmentBuilder();
    }

    public static class SlackAttachmentBuilder {

        private String fallback;

        private String color;

        private String pretext;

        private String authorName;

        private String authorLink;

        private String authorIcon;

        private String title;

        private String titleLink;

        private String text;

        private String imageUrl;

        private String thumbUrl;

        private String footer;

        private String footerIcon;

        private String ts;

        private List<SlackField> fields;

        public SlackAttachmentBuilder setFallback(String fallback) {
            this.fallback = fallback;
            return this;
        }

        public SlackAttachmentBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public SlackAttachmentBuilder setPretext(String pretext) {
            this.pretext = pretext;
            return this;
        }

        public SlackAttachmentBuilder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public SlackAttachmentBuilder setAuthorLink(String authorLink) {
            this.authorLink = authorLink;
            return this;
        }

        public SlackAttachmentBuilder setAuthorIcon(String authorIcon) {
            this.authorIcon = authorIcon;
            return this;
        }

        public SlackAttachmentBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public SlackAttachmentBuilder setTitleLink(String titleLink) {
            this.titleLink = titleLink;
            return this;
        }

        public SlackAttachmentBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public SlackAttachmentBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public SlackAttachmentBuilder setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
            return this;
        }

        public SlackAttachmentBuilder setFooter(String footer) {
            this.footer = footer;
            return this;
        }

        public SlackAttachmentBuilder setFooterIcon(String footerIcon) {
            this.footerIcon = footerIcon;
            return this;
        }

        public SlackAttachmentBuilder setTs(String ts) {
            this.ts = ts;
            return this;
        }

        public SlackAttachmentBuilder addField(SlackField field) {
            if(fields == null) {
                fields = new ArrayList<>();
            }
            fields.add(field);
            return this;
        }

        public SlackAttachment build() {
            return new SlackAttachment(this.fallback,
                    this.color,
                    this.pretext,
                    this.authorName,
                    this.authorLink,
                    this.authorIcon,
                    this.title,
                    this.titleLink,
                    this.text,
                    this.imageUrl,
                    this.thumbUrl,
                    this.footer,
                    this.footerIcon,
                    this.ts,
                    this.fields
            );
        }
    }

}
