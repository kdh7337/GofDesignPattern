/**
 * Created by DoDo on 2017-02-10.
 */
public class SingletonPattern {
    private static SingletonPattern singleton = new SingletonPattern();
    private SingletonPattern(){}
    public static SingletonPattern getInstance(){
        return singleton;
    }
}
