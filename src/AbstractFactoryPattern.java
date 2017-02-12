import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by DoDo on 2017-02-12.
 */
public class AbstractFactoryPattern {
    static abstract class Component{
        String tag;
        public Component(String tag){
            this.tag = tag;
        }
        abstract String makeText() throws Exception;
    }
    static abstract class Element extends Component{
        URL url;
        public Element(String tag, URL url) {
            super(tag);
            this.url = url;
        }
    }
    static abstract class Container extends Component{
        ArrayList<Component> container = new ArrayList<>();
        public Container(String tag) {
            super(tag);
        }
        public  void add(Component s){
            container.add(s);
        }
    }
    static abstract class Wrapper extends  Component{
        ArrayList<Component> contents = new ArrayList<>();
        public Wrapper(String tag) {
            super(tag);
        }
        public void add(Component component){
            contents.add(component);
        }
    }

    static abstract class Factory{
        public static Factory getFactory(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            return (Factory)Class.forName(className).newInstance();
        }
        public abstract Element createElement(String tag, URL url);
        public abstract Container createContainer(String tag);
        public abstract Wrapper createWrapper(String tag);
    }
}
