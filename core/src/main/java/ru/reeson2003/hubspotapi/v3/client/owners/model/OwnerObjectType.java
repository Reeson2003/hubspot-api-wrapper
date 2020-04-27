package ru.reeson2003.hubspotapi.v3.client.owners.model;

import ru.reeson2003.hubspotapi.v3.client.ObjectType;
import ru.reeson2003.hubspotapi.v3.client.Results;

public class OwnerObjectType
        implements ObjectType<Owner> {

    @Override
    public Class<Owner> getType() {
        return Owner.class;
    }

    @Override
    public Class<? extends Results<Owner>> getResultsType() {
        return OwnerResults.class;
    }

    public static class OwnerResults
            extends Results<Owner> {}

}
