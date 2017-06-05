package pattern.observer_spring;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public class EventPublisher {


    Map<ApplicationEvent,Listener> map  = new HashMap<>();




    public static void publishEvent(ApplicationEvent eventObject) {

    }
}
