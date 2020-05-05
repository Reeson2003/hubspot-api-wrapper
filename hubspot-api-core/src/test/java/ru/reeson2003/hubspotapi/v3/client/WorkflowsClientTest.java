package ru.reeson2003.hubspotapi.v3.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.reeson2003.hubspotapi.v3.ApacheApiClient;
import ru.reeson2003.hubspotapi.v3.client.workflows.WorkflowsClient;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkflowsClientTest {

    private static WorkflowsClient client;

    @BeforeAll
    public static void setup() {
        client = new WorkflowsClient(new ApacheApiClient("demo"));
    }

    @Test
    public void readAll() {
        assertThat(client.stream()).isNotEmpty();
    }

}
