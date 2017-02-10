/**
 * Created by DoDo on 2017-02-10.
 */
public abstract class FactoryPattern {
    public final Product newProduct(){
    Product product = createProduct();
    processing(product);
    return  product;
    }
    protected abstract Product createProduct();
    protected abstract void processing(Product product);

    public interface  Product{
        void basicMethod();
    }
}
