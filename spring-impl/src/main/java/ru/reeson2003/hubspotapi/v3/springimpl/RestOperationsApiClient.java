package ru.reeson2003.hubspotapi.v3.springimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestOperations;
import ru.reeson2003.hubspotapi.v3.ApiClient;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
public class RestOperationsApiClient
        implements ApiClient {

    private final RestOperations restOperations;

    @Override
    public <T> T exchange(String url, String method, Object body, Class<T> responseType) {
        RequestEntity<Object> requestEntity = RequestEntity.method(Optional.ofNullable(HttpMethod.resolve(method))
                                                                           .orElse(HttpMethod.GET), URI.create(url))
                                                           .accept(MediaType.APPLICATION_JSON)
                                                           .contentType(MediaType.APPLICATION_JSON)
                                                           .body(body);
        return restOperations.exchange(requestEntity, responseType).getBody();
    }

}
