/**
 * Created by DoDo on 2017-02-11.
 */
public class BuilderPattern {
    interface Product {}

    interface Builder<T extends String> {
        void setTitle(String t);
        void setContent(String c);
        void setPS(String ps);
        T create();
    }

    static class Director<T extends String>{
        private Builder<T> builder;
        void setBuilder(Builder builder){
            this.builder = builder;
        }
        T construct(String title, String content, String ps){
            builder.setTitle(title);
            builder.setContent(content);
            builder.setPS(ps);
            return builder.create();
        }
    }


}
