package ru.reeson2003.hubspotapi.v3.client.owners;

import ru.reeson2003.hubspotapi.v3.client.operations.Operation;

import java.util.List;

public interface ReadByEmailOperation<T>
        extends Operation<T> {

    default List<T> readByEmail(String email) {
        String url = getBaseUrl() + "?email=" + email;
        String method = "GET";
        return getApiClient().exchange(url, method, null, getObjectType().getResultsType()).getResults();
    }

}
