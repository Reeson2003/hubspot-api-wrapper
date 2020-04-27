package ru.reeson2003.hubspotapi.v3.client.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyGroup;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyGroupObjectType;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyObjectType;
import ru.reeson2003.hubspotapi.v3.client.operations.CrudOperations;

@AllArgsConstructor
public class ObjectsClient<T>
        implements CrudOperations<T>, PropertyContainer {

    private static final String OBJECT_URL = "https://api.hubapi.com/crm/v3/objects/{objectType}";

    private static final String PROPS_URL = "https://api.hubapi.com/crm/v3/properties/{objectType}";

    private static final String PROP_GROUPS_URL = "https://api.hubapi.com/crm/v3/properties/{objectType}/groups";

    @Getter
    private final ApiClient apiClient;

    @Getter
    private final ObjectType<T> objectType;

    @Getter
    private final String baseUrl;

    @Getter
    private final CrudOperations<Property> propertyClient;

    @Getter
    private final CrudOperations<PropertyGroup> propertyGroupClient;

    private ObjectsClient(ApiClient apiClient, ObjectType<T> objectType, String baseUrl) {
        this(apiClient, objectType, baseUrl, null, null);
    }

    public ObjectsClient(ApiClient apiClient, HubSpotObjectType<T> hubSpotObjectType) {
        this(apiClient,
             hubSpotObjectType,
             OBJECT_URL.replace("{objectType}", hubSpotObjectType.getApiName()),
             new ObjectsClient<>(apiClient,
                                 new PropertyObjectType(),
                                 PROPS_URL.replace("{objectType}", hubSpotObjectType.getApiName())),
             new ObjectsClient<>(apiClient,
                                 new PropertyGroupObjectType(),
                                 PROP_GROUPS_URL.replace("{objectType}", hubSpotObjectType.getApiName())));
    }

}
