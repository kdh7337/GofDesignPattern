/**
 * Created by DoDo on 2017-02-10.
 */
public class TemplateImpl {
    public class ConcreteA extends TemplatePattern {

        public void firstWork() {
            System.out.print("firstA");
        }

        public void secondWork() {
            System.out.print("secondA");
        }

        public void thirdWork() {
            System.out.print("thirdA");
        }
    }

    class ConcreteB extends TemplatePattern {

        public void firstWork() {
            System.out.print("firstB");
        }
        public void secondWork() {
            System.out.print("secondB");
        }
        public void thirdWork() {
            System.out.print("thirdB");
        }
    }

    class ConcreteC extends TemplatePattern{

        public void firstWork() {
            System.out.print("firstC");
        }
        public void secondWork() {
            System.out.print("secondC");
        }
        public void thirdWork() {
            System.out.print("thirdC");
        }
    }

    public void templateExample() {
        TemplatePattern cA = new ConcreteA();
        TemplatePattern cB = new ConcreteB();
        TemplatePattern cC = new ConcreteC();

    }
}