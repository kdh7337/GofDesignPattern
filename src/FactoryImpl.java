/**
 * Created by DoDo on 2017-02-10.
 */
public class FactoryImpl {
    class Concrete implements FactoryPattern.Product{

        @Override
        public void basicMethod() {
            //구현
        }
    }
    class ConcreteFactory extends FactoryPattern{

        @Override
        protected Product createProduct() {
            Concrete c = new Concrete();
            return c;
        }

        @Override
        protected void processing(Product product) {
            //세부 구현
        }
    }

    public  void factoryExample(){
        FactoryPattern factory = new ConcreteFactory();
        FactoryPattern.Product p1 = factory.createProduct();
        p1.basicMethod();
    }
}
