package org.commerceplatform;

import org.commerceplatform.data.DataLoader;

import java.util.List;

public class DashboardHandler {

    private List<Integer> statIdList;
    private List<Integer> userStatIdList;
    private final Store s;
    private StoreData storeData;

    public DashboardHandler(Store s) {
        this.s=s;
    }

    public void requestStatistics(User u) {
        DataCollector dataCollector = new DataCollector(s.getLedger(), s.getItemCatalogue());
        this.storeData = new StoreData(dataCollector);
        this.statIdList=this.storeData.getStatIdList();
        this.userStatIdList= DataLoader.getStatIdListForUser(u.getId(), this.statIdList);
    }

    public void showStats() {
        for(int i : this.userStatIdList) {
            String s = this.storeData.getDisplayStringForId(i);
            System.out.println(s);
        }
    }
    public void editStats(int id) {
        if (this.userStatIdList.contains(id)) {
            this.userStatIdList.remove(new Integer(id));
        } else if (this.statIdList.contains(id)){
            this.userStatIdList.add(id);
        }
    }
}
