package pattern.observer_spring;


/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public class EventListenerTest {


    public static void main(String[] args)  {
        EventPublisher.publishEvent(new SendEmailEvent("nonpool.cn@gmail.com"));
        EventPublisher.publishEvent(new SendMessageEvent("1888888888"));
    }


}
