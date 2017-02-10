/**
 * Created by DoDo on 2017-02-10.
 */
public class ObserverImpl {
    class ConcreteObserver implements ObserverPattern.Observer {

        @Override
        public void noticeChange(ObserverPattern.Observable observable) {
            System.out.println(observable instanceof ObserverPattern.Observer);
        }
    }
    class ConcreteObservable implements ObserverPattern.Observable{

        @Override
        public void doSomething(){
            //작업 처리
            notifyObservers();
        }
    }

    public void observerExample(){

        ObserverPattern.Observer observerA = new ConcreteObserver();
        ObserverPattern.Observer observerB = new ConcreteObserver();
        ObserverPattern.Observable observable = new ConcreteObservable();
        observable.addObserver(observerA);
        observable.addObserver(observerB);
        observable.doSomething();

    }
}
