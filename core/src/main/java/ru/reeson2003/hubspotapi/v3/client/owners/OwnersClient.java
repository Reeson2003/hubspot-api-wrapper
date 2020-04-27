package ru.reeson2003.hubspotapi.v3.client.owners;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.operations.ReadOperations;
import ru.reeson2003.hubspotapi.v3.client.owners.model.Owner;
import ru.reeson2003.hubspotapi.v3.client.owners.model.OwnerObjectType;

@Getter
@RequiredArgsConstructor
public class OwnersClient
        implements ReadOperations<Owner>,
                   ReadByEmailOperation<Owner> {

    public static final String OWNERS_URL = "https://api.hubapi.com/crm/v3/owners";

    private final String baseUrl;

    private final ObjectType<Owner> objectType;

    private final ApiClient apiClient;

    public OwnersClient(ApiClient apiClient) {
        this(OWNERS_URL, new OwnerObjectType(), apiClient);
    }

}
