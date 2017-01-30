package com.langellu.slack.webhook;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by luca on 27/01/17.
 */
public class SlackApi {

    private URI webhookUri;

    private Gson gson;

    private SlackApi(URI webhookUri) {
        this.webhookUri = webhookUri;
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public static SlackApiBuilder builder() {
        return new SlackApiBuilder();
    }


    public void sendMessage(SlackMessage message) throws SlackException {

        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(webhookUri);

            System.out.println(gson.toJson(message));

            StringEntity postingString = new StringEntity(gson.toJson(message));
            httpPost.setEntity(postingString);

            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpclient.execute(httpPost);

            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new SlackException("Error while sending messeage. Response : "
                        + response.getStatusLine().getReasonPhrase());
            }

        } catch (IOException e) {
            throw new SlackException(e);
        }
    }

    public static class SlackApiBuilder {

        private String uri;

        public SlackApiBuilder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        private SlackApiBuilder() {
        }

        public SlackApi build() throws SlackException {
            try {
                if(uri == null) {
                    throw new IllegalArgumentException("WebHook uri is not valid");
                }
                URI uri = new URI(this.uri);
                return new SlackApi(uri);
            } catch (URISyntaxException e) {
                throw new SlackException(e);
            }
        }
    }

}
