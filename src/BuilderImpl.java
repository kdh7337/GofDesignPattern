/**
 * Created by DoDo on 2017-02-11.
 */
public class BuilderImpl {

    class ConcreteBuilder implements BuilderPattern.Builder {
        StringBuffer html= new StringBuffer("<html><head></head>");
        @Override
        public void setTitle(String t) {
            html.append("<title>");
            html.append(t);
            html.append("</title>");
        }

        @Override
        public void setContent(String c) {
            html.append("<body>");
            html.append(c);
            html.append("</body>");
        }

        @Override
        public void setPS(String ps) {
            html.append(ps);
        }

        @Override
        public String create() {
            html.append("</html>");
            return html.toString();
        }
    }

    public void builderExample(){
        BuilderPattern.Director<String> stringDirector = new BuilderPattern.Director<>();
        stringDirector.setBuilder(new ConcreteBuilder());
        String result = stringDirector.construct("Title","Content","");
    }
}
