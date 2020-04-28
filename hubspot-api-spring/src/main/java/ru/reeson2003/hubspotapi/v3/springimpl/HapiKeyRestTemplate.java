package ru.reeson2003.hubspotapi.v3.springimpl;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class HapiKeyRestTemplate
        extends RestTemplate {

    private final String hapiKey;

    public HapiKeyRestTemplate(String hapiKey) {
        this.hapiKey = hapiKey;
        setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

    @Override
    protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor)
            throws RestClientException {
        URI withHapiKey = UriComponentsBuilder.fromUri(url)
                                              .queryParam("hapikey", this.hapiKey)
                                              .build().toUri();
        return super.doExecute(withHapiKey, method, requestCallback, responseExtractor);
    }

}
