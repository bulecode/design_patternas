package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class MallardDuck extends Duck {


    //根据实际需要设置不同的行为(算法)
    public MallardDuck() {
        super.setFlyBehavior(new FlyWithWings()); //会飞
        super.setQuackBehavior(new Quack());      //能呱呱叫
    }

    @Override
    void display() {
        System.out.println("我是绿头鸭");
    }
}
