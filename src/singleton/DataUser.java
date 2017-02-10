package singleton;

import java.util.ArrayList;

/**
 * Created by DoDo on 2017-02-10.
 */
public class DataUser<T> {
    private ArrayList<T> datas;
    public void setDatas(ArrayList<T> datas){
        this.datas = datas;
    }
    public void useDatas(){
        //데이터 관련 행위
    }
}
