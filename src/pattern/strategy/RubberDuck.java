package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        super.setFlyBehavior(new FlyNoWay()); //不会飞
        super.setQuackBehavior(new Squeak()); //会吱吱叫
    }

    @Override
    void display() {
        System.out.println("橡皮鸭");
    }
}
