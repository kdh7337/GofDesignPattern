package singleton;

import java.util.ArrayList;

/**
 * Created by DoDo on 2017-02-10.
 */
public class DataLoader<T> {
    private static DataLoader<?> dataLoader;
    private ArrayList<T> datas;
    private DataLoader(){}
    public static DataLoader<?> getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }
    public ArrayList<T> getDatas(){
        if(datas == null){
            throw new IllegalAccessError("아직 데이터를 불러오지 않았습니다.");
        }
        return datas;
    }


}
