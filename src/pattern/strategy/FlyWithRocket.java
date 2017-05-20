package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我能借助火箭起飞");
    }
}
