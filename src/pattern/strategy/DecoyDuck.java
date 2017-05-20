package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        super.setFlyBehavior(new FlyNoWay());     //不会飞
        super.setQuackBehavior(new MuteQuack());  //不会叫
    }

    @Override
    void display() {
        System.out.println("诱饵鸭");
    }
}
