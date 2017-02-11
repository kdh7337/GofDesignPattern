/**
 * Created by DoDo on 2017-02-11.
 */

public class PrototypeImpl {
    class  ConcreteProduct implements PrototypePattern.Product {

        String something;

        private ConcreteProduct(){}

        public ConcreteProduct(String something){
            this.something = something;
        }
        @Override
        public void use() {
            doSomething();
        }

        @Override
        public PrototypePattern.Product createClone() throws CloneNotSupportedException {
            return (PrototypePattern.Product) clone();
        }
        private void doSomething(){
            System.out.println(something);
        }

    }
    public void prototypeExample(){
        PrototypePattern.ProductUser prototypes = new PrototypePattern.ProductUser();
        ConcreteProduct protoA = new ConcreteProduct("A");
        ConcreteProduct protoB = new ConcreteProduct("B");
        prototypes.addPrototype("A",protoA);
        prototypes.addPrototype("B",protoB);

        try {
            PrototypePattern.Product instanceA1 = prototypes.getProduct("A");
            PrototypePattern.Product instanceB1 = prototypes.getProduct("B");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
