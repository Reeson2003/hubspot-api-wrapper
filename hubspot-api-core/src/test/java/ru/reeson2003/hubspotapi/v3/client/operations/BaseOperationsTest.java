package ru.reeson2003.hubspotapi.v3.client.operations;

import lombok.Getter;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;

import static org.mockito.Mockito.mock;

@Getter
public class BaseOperationsTest
        implements Operation<String> {

    private final String baseUrl = "http://localhost";

    private final ObjectType<String> objectType = new StringObjectType();

    private final ApiClient apiClient = mock(ApiClient.class);

}
