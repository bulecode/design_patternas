package pattern.strategy;

/**
 * Author: buleCode
 * Date: 2017/5/20
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
