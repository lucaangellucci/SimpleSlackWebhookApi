package com.langellu.slack.webhook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by luca on 28/01/17.
 */
public class SlackField {

    private final String title;

    private final String value;

    @SerializedName("short")
    private final Boolean shortValue;

    private SlackField(Builder builder) {
        this.title  = builder.title;
        this.value= builder.value;
        this.shortValue = builder.shortValue;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public Boolean getShortValue() {
        return shortValue;
    }

    public static final class Builder {
        private String title;
        private String value;
        private Boolean shortValue;

        public Builder() {
        }

        public Builder title(final String val) {
            title = val;
            return this;
        }

        public Builder value(final String val) {
            value = val;
            return this;
        }

        public Builder shortValue(final Boolean val) {
            shortValue = val;
            return this;
        }

        public SlackField build() {
            return new SlackField(this);
        }
    }
}
