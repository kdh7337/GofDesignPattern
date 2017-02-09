import java.util.List;
import java.util.Objects;

/**
 * Created by DoDo on 2017-02-10.
 */
public class IteratorImpl {

    class Data{
        String content;

        public Data(String content) {
            this.content = content;
        }
    }
    class DataAggregator<T> implements IteratorPattern.Aggregate{

        T[] datas;

        public DataAggregator(T[] datas) {
            this.datas = datas;
        }

        @Override
        public IteratorPattern.Iterator createIterator() {
            return new DataIterator<T>(datas);
        }
    }
    class DataIterator<T> implements IteratorPattern.Iterator{
        T[] datas;
        int index;

        public DataIterator(T[] datas) {
            this.datas = datas;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return !(index> datas.length);
        }

        @Override
        public T next() {
            index++;
            return datas[index];
        }
    }

    public void iteratorExample(){
        Data[] datas = new Data[10];
        DataAggregator<Data> dataAggregator = new DataAggregator<>(datas);
        IteratorPattern.Iterator iterator = dataAggregator.createIterator();
        while(iterator.hasNext()){
            Data target = (Data) iterator.next();
        }


    }
}
