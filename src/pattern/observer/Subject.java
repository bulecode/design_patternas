package pattern.observer;

/**
 * 主题(被观察者)
 * Author: buleCode
 * Date: 2017/5/21
 */
public interface Subject {

    //注册观察者
    void registerObserver(Observer o);

    //移除观察者
    void removeObserver(Observer o);

    //通知观察者
    void notifyObservers();

}
