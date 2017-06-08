package pattern.observer_spring;


import java.io.IOException;

/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public class EventListenerTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EventPublisher.publishEvent(new SendEmailEvent("730333433@qq.com"));
        EventPublisher.publishEvent(new SendMessageEvent("1888888888"));
    }


}
