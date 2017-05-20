package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我会飞");
    }
}
