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
// 모듈의 인터페이스
interface  Version{
    void action1();
    void action2();
}

//구버전
class OldVersion implements Version{
    public void action1(){
        //HTTP
        System.out.print("1");

    }
    public void action2(){

        System.out.print("2");
    }
}
//새버전
class NewVersion implements Version {
    public void action1(){
        //HTTPS
        System.out.println("1");
    }
    public void action2(){

        System.out.println("2");
    }
}
//마법의 어댑터
interface Adapter {
    void job1();
    void job2();
}

class Client{
    Adapter adapter = new Adapter() {
        //옛날 버전;
        Version v = new OldVersion();
        // 새 번전;
        // 진화! Version v = new NewVersion();
        @Override
        public void job1() {
            v.action1();
        }

        @Override
        public void job2() {
            v.action2();
        }
    };

    public void doClientWork(){
        adapter.job1();
        adapter.job2();
    }
}
