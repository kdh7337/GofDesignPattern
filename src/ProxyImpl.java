/**
 * Created by DoDo on 2017-02-10.
 */
public class ProxyImpl {
    class Proxy implements ProxyPattern.Operator{
        String printTarget;
        Client client;
        @Override
        public void minorWork(String printTarget) {
            this.printTarget =printTarget;
        }

        @Override
        public void majorWork(String s) {
            if(client == null){
                client = new Client();
            }
            if(printTarget == null){
                minorWork(s);
            }
            client.majorWork(printTarget);
        }
    }
    class Client implements ProxyPattern.Operator{
        String printTarget;
        @Override
        public void minorWork(String s) {
            this.printTarget =s;
        }

        @Override
        public void majorWork(String s) {
            if (printTarget == null ) {
                minorWork(s);
            }
            for(long i = 0; i <100000000; i ++){
                System.out.println(printTarget);
            }
        }
    }
}
