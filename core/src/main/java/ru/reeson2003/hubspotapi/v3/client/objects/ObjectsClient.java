package ru.reeson2003.hubspotapi.v3.client.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.PropertyContainer;
import ru.reeson2003.hubspotapi.v3.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.model.properties.PropertyGroup;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;
import ru.reeson2003.hubspotapi.v3.operations.CrudOperations;

@AllArgsConstructor
public class ObjectsClient<T>
        implements CrudOperations<T>, PropertyContainer {

    private static final String OBJECT_URL = "https://api.hubapi.com/crm/v3/objects/{objectType}";

    private static final String PROPS_URL = "https://api.hubapi.com/crm/v3/properties/{objectType}";

    private static final String PROP_GROUPS_URL = "https://api.hubapi.com/crm/v3/properties/{objectType}/groups";

    @Getter
    private final ApiClient apiClient;

    @Getter
    private final HubSpotObjectType<T> objectType;

    @Getter
    private final String baseUrl;

    @Getter
    private final CrudOperations<Property> propertyClient;

    @Getter
    private final CrudOperations<PropertyGroup> propertyGroupClient;

    private ObjectsClient(ApiClient apiClient, HubSpotObjectType<T> objectType, String baseUrl) {
        this(apiClient, objectType, baseUrl, null, null);
    }

    public ObjectsClient(ApiClient apiClient, HubSpotObjectType<T> hubSpotObjectType) {
        this(apiClient,
             hubSpotObjectType,
             OBJECT_URL.replace("{objectType}", hubSpotObjectType.getApiName()),
             new ObjectsClient<>(apiClient,
                                 HubSpotObjectType.of(Property.class),
                                 PROPS_URL.replace("{objectType}", hubSpotObjectType.getApiName())),
             new ObjectsClient<>(apiClient,
                                 HubSpotObjectType.of(PropertyGroup.class),
                                 PROP_GROUPS_URL.replace("{objectType}", hubSpotObjectType.getApiName())));
    }

}
