package ru.reeson2003.hubspotapi.v3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.client.objects.ObjectsClient;
import ru.reeson2003.hubspotapi.v3.model.objects.Contact;
import ru.reeson2003.hubspotapi.v3.model.objects.Product;
import ru.reeson2003.hubspotapi.v3.model.properties.Property;
import ru.reeson2003.hubspotapi.v3.model.properties.PropertyGroup;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;
import ru.reeson2003.hubspotapi.v3.operations.CrudOperations;
import ru.reeson2003.hubspotapi.v3.springimpl.HapiKeyApiClient;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectsClientTest {

    private static ObjectsClient<Contact> fromContact;

    private static ObjectsClient<Contact> toContact;

    private static ObjectsClient<Product> toProduct;

    @BeforeAll
    public static void setup() {
        fromContact = new ObjectsClient<>(new HapiKeyApiClient("16d25c18-ee21-4c3a-bbcd-0a88536aa04c"), HubSpotObjectType.of(Contact.class));
        toContact = new ObjectsClient<>(new HapiKeyApiClient("9bcbeeae-a8f4-4be8-93b7-03227cbc236c"), HubSpotObjectType.of(Contact.class));
        toProduct = new ObjectsClient<>(new HapiKeyApiClient("9bcbeeae-a8f4-4be8-93b7-03227cbc236c"), HubSpotObjectType.of(Product.class));
    }

    @Test
    public void createContact() {
        Contact contact = Contact.builder()
                                 .property("user_id", "1")
                                 .build();
        Contact created = toContact.create(contact);
        System.out.println(created);
    }

    @Test
    public void copy() {
        copyPropertyGroups();
        copyProperties();
    }

    @Test
    public void copyRegistrationCountry() {
        String registration_country = "registration_country";
        Property registrationCountry = fromContact.getPropertyClient().readOne(registration_country);
        toContact.getPropertyClient().update(registration_country, registrationCountry);
    }

    @Test
    public void readContacts() {
        List<String> contactIds = toContact.stream()
                                        .map(Contact::getId)
                                        .collect(Collectors.toList());
        System.out.println("contactIds = " + contactIds);
    }

    @Test
    public void createProduct() {
        toProduct.getPropertyClient().readAll().stream()
                 .map(Property::getName)
                 .forEach(System.out::println);
        Product product = toProduct.create(Product.builder()
                                                  .property("name", "Awesome product")
                                                  .property("price", "9000")
                                                  .build());
        System.out.println("product = " + product);
    }

    public void copyPropertyGroups() {
        CrudOperations<PropertyGroup> fromPropertyGroupClient = fromContact.getPropertyGroupClient();
        List<PropertyGroup> original = fromPropertyGroupClient.readAll();
        CrudOperations<PropertyGroup> toPropertyGroupClient = toContact.getPropertyGroupClient();
        Set<String> copy = toPropertyGroupClient.readAll().stream()
                                                .map(PropertyGroup::getName)
                                                .collect(Collectors.toSet());
        original.forEach(propertyGroup -> {
            try {
                if (copy.contains(propertyGroup.getName())) {
                    toPropertyGroupClient.update(propertyGroup.getName(), propertyGroup);
                } else {
                    toPropertyGroupClient.create(propertyGroup);
                }
            } catch (Throwable t) {
                System.err.println(t);
            }
        });
    }

    public void copyProperties() {
        CrudOperations<Property> fromPropertyClient = fromContact.getPropertyClient();
        List<Property> original = fromPropertyClient.readAll();
        CrudOperations<Property> toPropertyClient = toContact.getPropertyClient();
        Set<String> copy = toPropertyClient.readAll().stream()
                                           .map(Property::getName)
                                           .collect(Collectors.toSet());
        original.forEach(propertyGroup -> {
            try {
                if (copy.contains(propertyGroup.getName())) {
                    toPropertyClient.update(propertyGroup.getName(), propertyGroup);
                } else {
                    toPropertyClient.create(propertyGroup);
                }
            } catch (Throwable t) {
                System.err.println(t);
            }
        });
    }

}