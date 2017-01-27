package com.langellu.slack.webhook;

/**
 * Created by luca on 27/01/17.
 */
public class SlackException extends Exception {

    public SlackException(Throwable cause) {
        super(cause);
    }

    public SlackException(String message) {
        super(message);
    }

    public SlackException(String message, Throwable cause) {
        super(message, cause);
    }
}
