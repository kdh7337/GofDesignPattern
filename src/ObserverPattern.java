import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DoDo on 2017-02-10.
 */
public class ObserverPattern {

    interface Observer {
        void noticeChange(Observable observable);
    }

    interface Observable{
        ArrayList<Observer> observers = new ArrayList<>();
        default void addObserver(Observer observer){
            observers.add(observer);
        }
        default void notifyObservers(){
            Iterator<Observer> iterator = observers.iterator();
            while(iterator.hasNext()){
                iterator.next().noticeChange(this);
            }
        }

        void doSomething();
    }
}
