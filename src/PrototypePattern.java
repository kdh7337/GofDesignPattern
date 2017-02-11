import java.util.HashMap;
import java.util.Map;

/**
 * Created by DoDo on 2017-02-11.
 */
public class PrototypePattern {
    interface Product extends Cloneable{
        void use();
        Product createClone() throws CloneNotSupportedException;
    }
    static class ProductUser {

        Map<String, Product> prototypes = new HashMap<>();

        public void ProductUser(){}

        public void addPrototype(String tag,Product prototype){
            prototypes.put(tag, prototype);
        }
        public Product getProduct(String tag) throws CloneNotSupportedException {
            return prototypes.get(tag).createClone();
        }
    }
}

