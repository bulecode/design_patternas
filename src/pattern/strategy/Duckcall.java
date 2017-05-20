package pattern.strategy;

/**
 * 拓展练习
 * 鸭鸣器
 * Author: buleCode
 * Date: 2017/5/20
 */
public class Duckcall {

    private QuackBehavior quackBehavior;

    private boolean flag;

    public Duckcall() {
        this.quackBehavior = new Quack();

    }

    public void start() {
        flag = true;
        while (flag) {
            quackBehavior.quack();
        }
    }

    public void close() {
        flag = false;
    }




}
