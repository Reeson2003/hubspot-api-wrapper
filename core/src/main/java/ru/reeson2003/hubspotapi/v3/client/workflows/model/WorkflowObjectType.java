package ru.reeson2003.hubspotapi.v3.client.workflows.model;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.Results;

public class WorkflowObjectType
        implements ObjectType<Workflow> {

    @Override
    public Class<Workflow> getType() {
        return Workflow.class;
    }

    @Override
    public Class<? extends Results<Workflow>> getResultsType() {
        return Workflows.class;
    }

}
