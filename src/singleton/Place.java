package singleton;

import java.util.ArrayList;

/**
 * Created by DoDo on 2017-02-10.
 */
public class Place {
    DataUser<String> user1 = new DataUser<>();
    DataUser<String> user2 = new DataUser<>();
    DataUser<String> user3 = new DataUser<>();
    DataUser<String> user4 = new DataUser<>();
    DataUser<String> user5 = new DataUser<>();
    DataUser<String> user6 = new DataUser<>();
    DataUser<String> user7 = new DataUser<>();

    DataLoader<String> dataLoader = (DataLoader<String>) DataLoader.getInstance();

    public void doJobs(){
        ArrayList<String> datas = dataLoader.getDatas();
        user1.setDatas(datas);
        user2.setDatas(datas);
    }
}
