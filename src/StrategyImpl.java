/**
 * Created by DoDo on 2017-02-10.
 */
public class StrategyImpl {
    class StrategyA implements StrategyPattern.Strategy {
        int result;
        @Override
        public void solve() {
            result = 2*3;
        }

        @Override
        public int saveResult() {
            return result;
        }
    }

    class StrategyB implements StrategyPattern.Strategy {
        int result;
        @Override
        public void solve() {
            result = 0;
            for(int i = 0; i < 3; i++){
                result += 2;
            }
        }

        @Override
        public int saveResult() {
            return result;
        }
    }


    class Player{
        StrategyPattern.Strategy strategy;

        public Player(StrategyPattern.Strategy strategy) {
            this.strategy = strategy;
        }
        public void solve(){
            strategy.solve();
        }
        public int returnResult(){
            return strategy.saveResult();
        }
    }

    public void StrategyExample(){
        Player playerA = new Player(new StrategyA());
        System.out.println("ResultA: " + playerA.returnResult());
        Player playerB = new Player(new StrategyB());
        System.out.println("ResultB: " + playerB.returnResult());
    }
}
