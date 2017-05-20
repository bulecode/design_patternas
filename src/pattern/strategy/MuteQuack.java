package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        //不会叫
    }
}
