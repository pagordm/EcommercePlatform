package org.commerceplatform;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStatistic<T, E extends Comparable<? super E>> extends Statistic{

    private final Map<T, E> map;

    public MapStatistic(Map<T, E> map) {
        this.map=map;
    }

    @Override
    public String getDisplayString() {
        StringBuilder sb = new StringBuilder();
        Stream<Map.Entry<T,E>> sorted =
                map.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for(Map.Entry<T, E> entry: sorted.toList()) {
            sb.append(entry.getKey().toString()).append('|').append(entry.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
