package org.commerceplatform;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreData {

    private final List<Statistic> statList;

    private final DataCollector dataCollector;

    public StoreData(DataCollector dc) {
        this.dataCollector=dc;
        this.statList=new ArrayList<>();
    }

    private void constructList() {
        this.statList.add(new MapStatistic<>(this.dataCollector.getBestItems()));
        this.statList.add(new ObjectStatistic(this.dataCollector.getTotalSales()));
    }

    public List<Integer> getStatIdList() {
        this.constructList();
        return this.statList.stream().map(Statistic::getId).collect(Collectors.toList());
    }

    public String getDisplayStringForId(int id) {
        Statistic s = this.hasId(id);
        if (s != null) return "----------------"+id+"---------------\n"+s.getDisplayString();
        else return "";
    }

    private Statistic hasId(int id) {
        for (Statistic s :
                this.statList) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
