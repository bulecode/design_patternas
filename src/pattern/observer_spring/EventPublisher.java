package pattern.observer_spring;

import java.lang.reflect.*;
import java.util.*;

/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public class EventPublisher {

    //记录事件的监听者
    private static Map<ClassWithName, Set<Listener>> map = new HashMap<>();

    //初始化操作 把监听者按照监听类型来存放
    static  {
        //获取所有Listener的实现类,简单演示,不扫描jar包
        List<Class> allListenerClass = ClassUtil.getAllClassBySubClass(Listener.class, false);
        allListenerClass.forEach(c -> {
            //获取Listener的监听类型(泛型的真实类型)
            ParameterizedType parameterizedType = (ParameterizedType) c.getGenericInterfaces()[0];
            Class<ApplicationEvent> eventClass = (Class<ApplicationEvent>) parameterizedType.getActualTypeArguments()[0];
            //由于这里的特殊需要 所以封装成一个ClassWithName类
            ClassWithName classWithName = new ClassWithName(eventClass, eventClass.getName());
            Set<Listener> listeners = map.get(classWithName);
            if (listeners == null) {
                HashSet<Listener> set = new HashSet<>();
                try {
                    set.add((Listener) c.newInstance());
                } catch (Exception e) {
                    //
                }
                map.put(classWithName, set);
            } else {
                try {
                    listeners.add((Listener) c.newInstance());
                } catch (Exception e) {
                    //
                }
            }
        });
    }


    public static void publishEvent(ApplicationEvent eventObject) {
        Class<? extends ApplicationEvent> eventObjectClass = eventObject.getClass();
        map.keySet().forEach(c -> {

            //如果Listener监听的类型是发布的类型
            if (c.getEventClass().isAssignableFrom(eventObjectClass)) {
                //通知对应的Listener进行处理
                //spring中还使用的异步机制，而且调用的方法应该已经是通过代理生成的方法了 so 这里暂且不模拟，就算模拟也只能简单模拟 日后再做
                map.get(c).forEach(l -> l.onEvent(eventObject));
            }
        });

    }
}
