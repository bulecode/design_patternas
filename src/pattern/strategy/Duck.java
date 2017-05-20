package pattern.strategy;

/**
 * 策略模式
 *
 * 定义了算法族，分别封装起来，让他们之间可以相互替换，
 * 此模式让算法的变化独立于使用算法的客户
 *
 *
 * Author: buleCode
 * Date: 2017/5/20
 */
public abstract class Duck {

    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;


    void swim() {
        System.out.println("我会游泳");
    }

    abstract void display();

    void performQuack() {
        quackBehavior.quack();
    }

    void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
