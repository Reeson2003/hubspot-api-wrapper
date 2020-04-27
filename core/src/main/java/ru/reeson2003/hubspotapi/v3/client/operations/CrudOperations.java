package ru.reeson2003.hubspotapi.v3.client.operations;

public interface CrudOperations<T>
        extends ReadAllOperation<T>,
                ReadOneOperation<T>,
                CreateOperation<T>,
                UpdateOperation<T>,
                DeleteOperation<T> {}
