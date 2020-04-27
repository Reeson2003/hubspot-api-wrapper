package ru.reeson2003.hubspotapi.v3.client.extensions;

import lombok.Getter;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.extensions.model.CRMCard;
import ru.reeson2003.hubspotapi.v3.client.extensions.model.CRMCardObjectType;
import ru.reeson2003.hubspotapi.v3.client.operations.CrudOperations;

@Getter
public class CRMCardsClient
        implements CrudOperations<CRMCard> {

    public static final String WORKFLOWS_URL = "https://api.hubapi.com/crm/v3/extensions/cards/";

    private final String baseUrl;

    private final ObjectType<CRMCard> objectType;

    private final ApiClient apiClient;

    public CRMCardsClient(ApiClient apiClient, String appId) {
        this.baseUrl = WORKFLOWS_URL + appId;
        this.objectType = new CRMCardObjectType();
        this.apiClient = apiClient;
    }

}
