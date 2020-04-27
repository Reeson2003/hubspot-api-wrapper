package ru.reeson2003.hubspotapi.v3.client.operations;

import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;

public interface Operation<T> {

    ObjectType<T> getObjectType();

    String getBaseUrl();

    ApiClient getApiClient();

}
