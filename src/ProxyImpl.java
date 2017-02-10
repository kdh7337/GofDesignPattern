import java.nio.charset.IllegalCharsetNameException;
import java.util.IllegalFormatCodePointException;

/**
 * Created by DoDo on 2017-02-10.
 */
public class ProxyImpl {
    class Proxy implements ProxyPattern.Operator{
        String printTarget;
        Core Core;

        private Proxy(){}

        public Proxy(Core Core) {
            this.Core = Core;
        }

        @Override
        public void minorWork(String printTarget) {
            this.printTarget =printTarget;
        }

        @Override
        public void majorWork() {

            if(printTarget == null){
                throw new IllegalCharsetNameException("Minor가 정상적으로 진행되지 않았습니다.");
            }

            if(Core == null){
                Core = Core.getInstacne();
            }

            Core.minorWork(printTarget);
            Core.majorWork();
        }
    }

    public void proxyExample(){

        Core Core = Core.getInstacne();

        ProxyPattern.Operator operator = new Proxy(Core);

        operator.minorWork("뭔가");
        operator.majorWork();

    }
}
class Core implements ProxyPattern.Operator{

    private static Core Core;

    private Core() {}

    public static Core getInstacne(){
        if(Core == null){
            Core = new Core();
        }
        return Core;
    }

    String printTarget;

    @Override
    public void minorWork(String s) {
        this.printTarget =s;
    }

    @Override
    public void majorWork() {
        for(long i = 0; i <100000000; i ++){
            System.out.println(printTarget);
        }
    }
}