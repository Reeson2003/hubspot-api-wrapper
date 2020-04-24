package ru.reeson2003.hubspotapi.v3.operations;

import ru.reeson2003.hubspotapi.v3.model.Paging;
import ru.reeson2003.hubspotapi.v3.model.Results;
import ru.reeson2003.hubspotapi.v3.model.types.HubSpotObjectType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface ReadAllOperation<T>
        extends Operation<T>, Iterable<List<T>> {

    int LIMIT = 100;

    default List<T> readAll() {
        return readAll(LIMIT, null).getResults();
    }

    default Results<T> readAll(int limit, String after) {
        String method = "GET";
        String url = getBaseUrl();
        if (0 < limit || (null != after && !after.trim().isEmpty())) {
            StringBuilder sb = new StringBuilder(url).append("?");
            if (0 < limit) {
                sb.append("limit=")
                  .append(limit);
            }
            if (null != after && !after.trim().isEmpty()) {
                sb.append("&")
                  .append("after=")
                  .append(after);
            }
            url = sb.toString();
        }
        HubSpotObjectType<T> objectType = getObjectType();
        return getApiClient().exchange(url, method, null, objectType.getResultsType());
    }

    @Override
    default Iterator<List<T>> iterator() {
        return new Iterator<List<T>>() {
            private Results<T> next = readAll(LIMIT, null);

            private boolean hasNext = !next.getResults().isEmpty();

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public List<T> next() {
                if (!hasNext) {
                    throw new NoSuchElementException();
                } else {
                    List<T> results = next.getResults();
                    next = next.getPaging()
                               .map(Paging::getNext)
                               .map(Paging.Next::getAfter)
                               .map(after -> readAll(LIMIT, after))
                               .orElseGet(() -> {
                                   hasNext = false;
                                   return null;
                               });
                    return results;
                }
            }
        };
    }

    default Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false)
                            .flatMap(Collection::stream);
    }

}
