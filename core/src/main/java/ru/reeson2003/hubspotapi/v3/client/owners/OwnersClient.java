package ru.reeson2003.hubspotapi.v3.client.owners;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.model.owners.Owner;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;
import ru.reeson2003.hubspotapi.v3.operations.ReadOperations;

@Getter
@RequiredArgsConstructor
public class OwnersClient
        implements ReadOperations<Owner>,
                   ReadByEmailOperation<Owner> {

    public static final String OWNERS_URL = "https://api.hubapi.com/crm/v3/owners";

    private final String baseUrl;

    private final HubSpotObjectType<Owner> objectType;

    private final ApiClient apiClient;

    public OwnersClient(ApiClient apiClient) {
        this(OWNERS_URL, HubSpotObjectType.of(Owner.class), apiClient);
    }

}
