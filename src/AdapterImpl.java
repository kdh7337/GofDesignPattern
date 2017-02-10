/**
 * Created by DoDo on 2017-02-10.
 */
public class AdapterImpl {
    class Adaptee {
        public void doOldWork(){
            //과거의 동작
        }
    }
    class Adapted_class extends Adaptee implements AdapterPattern.Adapter{

        @Override
        public void doWhatisNeeded() {
            doOldWork();
        }
    }
    class Adapted_instance implements AdapterPattern.Adapter{
        private Adaptee adaptee;

        public Adapted_instance(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void doWhatisNeeded() {
            adaptee.doOldWork();
        }
    }

    public void adapterExample(){

        Adapted_class adapted_c= new Adapted_class();
        adapted_c.doWhatisNeeded();

        Adapted_instance adapted_i = new Adapted_instance(new Adaptee());
        adapted_i.doWhatisNeeded();
    }
}
