package ru.reeson2003.hubspotapi.v3.springimpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.client.objects.ObjectsClient;
import ru.reeson2003.hubspotapi.v3.model.objects.Contact;
import ru.reeson2003.hubspotapi.v3.model.owners.Owner;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

class ContactsClientTest {

    private static ObjectsClient<Contact> client;

    @BeforeAll
    public static void setup() {
        client = new ObjectsClient<>(new HapiKeyApiClient("4c85e852-d352-40d1-88d2-27c93960857a"), HubSpotObjectType.of(Contact.class));
    }

    @Test
    public void readAllTest() {
        client.stream()
              .map(Contact::getId)
              .forEach(System.out::println);
    }

}