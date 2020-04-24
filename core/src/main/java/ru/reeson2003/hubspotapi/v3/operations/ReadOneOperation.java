package ru.reeson2003.hubspotapi.v3.operations;

import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

public interface ReadOneOperation<T>
        extends Operation<T> {

    default T readOne(String id) {
        String method = "GET";
        String url = getBaseUrl() + "/" + id;
        HubSpotObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, null, objectType.getType());
    }

}
