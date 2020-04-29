package ru.reeson2003.hubspotapi.v3.client;

public interface ObjectType<T> {

    Class<T> getType();

    Class<? extends Results<T>> getResultsType();

}
