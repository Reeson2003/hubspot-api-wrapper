package ru.reeson2003.hubspotapi.v3.springimpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.client.objects.ObjectsClient;
import ru.reeson2003.hubspotapi.v3.client.objects.model.objects.Contact;
import ru.reeson2003.hubspotapi.v3.client.objects.model.objects.ContactObjectType;

import static org.assertj.core.api.Assertions.assertThat;

class ContactsClientTest {

    private static ObjectsClient<Contact> client;

    @BeforeAll
    public static void setup() {
        client = new ObjectsClient<>(new HapiKeyApiClient("demo"), new ContactObjectType());
    }

    @Test
    public void readAllTest() {
        assertThat(client.stream()).isNotEmpty();
    }

}