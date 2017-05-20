package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
