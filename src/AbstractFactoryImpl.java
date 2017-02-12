import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

/**
 * Created by DoDo on 2017-02-12.
 */
public class AbstractFactoryImpl {
    class ConcreteElement extends AbstractFactoryPattern.Element{
        public ConcreteElement(String tag, URL url) {
            super(tag, url);
        }

        @Override
        String makeText() throws Exception {
            StringBuffer sBuffer = new StringBuffer();
            sBuffer.append("Authority: " + url+"\n");
            sBuffer.append("Content: " + url.getContent()+"\n");
            return sBuffer.toString();
        }
    }
    class ConcreteContainer extends AbstractFactoryPattern.Container{

        public ConcreteContainer(String tag) {
            super(tag);
        }

        @Override
        String makeText() {
            StringBuffer sBuffer = new StringBuffer();
            sBuffer.append("Tag: ").append(tag);
            Iterator<AbstractFactoryPattern.Component> iterator = container.iterator();
            while(iterator.hasNext()){
                AbstractFactoryPattern.Component c = iterator.next();
                try {
                    sBuffer.append(c.makeText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    sBuffer.append("\\tag");
                    return sBuffer.toString();
                }
            }
            return sBuffer.toString();
        }
    }
    class ConcreteWrapper extends AbstractFactoryPattern.Wrapper{

        public ConcreteWrapper(String tag) {
            super(tag);
        }

        @Override
        String makeText() throws Exception {
            StringBuffer sBuffer = new StringBuffer();
            sBuffer.append("begin\n");
            Iterator<AbstractFactoryPattern.Component> iterator = contents.iterator();
            while(iterator.hasNext()){
                AbstractFactoryPattern.Component c = iterator.next();
                sBuffer.append(c.makeText());
            }
            sBuffer.append("End");
            return sBuffer.toString();
        }
    }

     class ConcreteFactory extends AbstractFactoryPattern.Factory{
        static final String CLASS_NAME = "ConcreteFactory";
        @Override
        public AbstractFactoryPattern.Element createElement(String tag, URL url) {
            return new ConcreteElement(tag, url);
        }

        @Override
        public AbstractFactoryPattern.Container createContainer(String tag) {
            return new ConcreteContainer(tag);
        }

        @Override
        public AbstractFactoryPattern.Wrapper createWrapper(String tag) {
            return new ConcreteWrapper(tag);
        }
    }

    public void abstractFactoryExample(){
        AbstractFactoryPattern.Factory factory = null;
        try {
         factory = AbstractFactoryPattern.Factory.getFactory(ConcreteFactory.CLASS_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AbstractFactoryPattern.Container container = factory.createContainer("container");
        try {
            container.add(factory.createElement("firstElement",new URL("http://www.naver.com")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            container.add(factory.createElement("secondElement",new URL("http://www.daum.net")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(container.makeText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
