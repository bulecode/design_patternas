package pattern.observer_spring;

/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public interface Listener<T extends ApplicationEvent> {


    /**
     * 当接收到消息时的处理方法
     * @param t
     */
    void onEvent(T t);

}
