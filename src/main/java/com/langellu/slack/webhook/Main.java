package com.langellu.slack.webhook;

/**
 * Created by luca on 27/01/17.
 */
public class Main {

    public static void main(String[] args) throws SlackException {
        SlackApi slackApi = SlackApi.builder()
                .setUri("https://hooks.slack.com/services/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")
                .build();

        SlackMessage slackMessage = new SlackMessage("Prova luca 1");

        slackApi.sendMessage(slackMessage);

    }
}
