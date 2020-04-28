package ru.reeson2003.hubspotapi.v3.springimpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.client.owners.OwnersClient;

import static org.assertj.core.api.Assertions.assertThat;

class OwnersClientTest {

    private static OwnersClient client;

    @BeforeAll
    public static void setup() {
        client = new OwnersClient(new HapiKeyApiClient("demo"));
    }

    @Test
    public void readAllTest() {
        assertThat(client.stream()).isNotEmpty();
    }

}