package ru.reeson2003.hubspotapi.v3.operations;

import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

public interface Operation<T> {

    HubSpotObjectType<T> getObjectType();

    String getBaseUrl();

    ApiClient getApiClient();
}
