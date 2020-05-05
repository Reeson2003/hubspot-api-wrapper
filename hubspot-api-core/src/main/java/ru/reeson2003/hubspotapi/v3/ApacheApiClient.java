package ru.reeson2003.hubspotapi.v3;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class ApacheApiClient implements ApiClient {

    private final HttpClient httpClient;

    private final String apiKey;

    public ApacheApiClient(String apiKey) {
        this(HttpClientBuilder.create().build(), apiKey);
    }

    @Override
    public String exchange(String url, String method, String body) {
        HttpUriRequest request = RequestBuilder.create(method)
                .setUri(url)
                .setEntity(new StringEntity(body, UTF_8))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addParameter("hapikey", apiKey)
                .build();
        HttpResponse response;
        String responseString;
        try {
            response = httpClient.execute(request);
            responseString = EntityUtils.toString(response.getEntity(), UTF_8);
        } catch (IOException e) {
            throw new ApiCallException(e);
        }
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 300) {
            throw new ApiCallException(responseString);
        }
        return responseString;
    }
}
