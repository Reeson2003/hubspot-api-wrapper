package ru.reeson2003.hubspotapi.v3.client.workflows;

import lombok.Getter;
import ru.reeson2003.hubspotapi.v3.ApiClient;
import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.operations.CrudOperations;
import ru.reeson2003.hubspotapi.v3.client.workflows.model.Workflow;
import ru.reeson2003.hubspotapi.v3.client.workflows.model.WorkflowObjectType;

@Getter
public class WorkflowsClient
        implements CrudOperations<Workflow> {

    public static final String WORKFLOWS_URL = "https://api.hubapi.com/automation/v3/workflows";

    private final String baseUrl;

    private final ObjectType<Workflow> objectType;

    private final ApiClient apiClient;

    public WorkflowsClient(ApiClient apiClient) {
        this.baseUrl = WORKFLOWS_URL;
        this.objectType = new WorkflowObjectType();
        this.apiClient = apiClient;
    }

}
