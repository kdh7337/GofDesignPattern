/**
 * Created by DoDo on 2017-02-10.
 */
public abstract class TemplatePattern{

        abstract void firstWork();
        abstract void secondWork();
        abstract void thirdWork();

        public void lastWork(int i){
            for(int idx = 0; idx < i; idx++){
                firstWork();
            }
            secondWork();
            thirdWork();
        }
}
