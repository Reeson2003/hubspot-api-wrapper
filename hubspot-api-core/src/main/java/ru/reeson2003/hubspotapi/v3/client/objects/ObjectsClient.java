package ru.reeson2003.hubspotapi.v3.client.objects;

import lombok.Getter;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyGroup;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyGroupObjectType;
import ru.reeson2003.hubspotapi.v3.client.objects.model.properties.PropertyObjectType;
import ru.reeson2003.hubspotapi.v3.client.operations.CrudOperations;

import java.util.Optional;
import java.util.stream.Collectors;

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

    @Getter
    private final String parameters;

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

    public ObjectsClient(ApiClient apiClient,
                         ObjectType<T> objectType,
                         String baseUrl,
                         CrudOperations<Property> propertyClient,
                         CrudOperations<PropertyGroup> propertyGroupClient) {
        this.apiClient = apiClient;
        this.objectType = objectType;
        this.baseUrl = baseUrl;
        this.propertyClient = propertyClient;
        this.propertyGroupClient = propertyGroupClient;
        this.parameters = Optional.ofNullable(propertyClient)
                                  .map(propClient -> propClient.stream()
                                                               .map(Property::getName)
                                                               .collect(Collectors.joining(",", "properties=", "")))
                                  .orElse("");
    }

}
