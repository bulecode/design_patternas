package pattern.observer_spring;

/**
 * Author: buleCode
 * Date: 2017/6/8
 */
public class SendMessage implements Listener<SendMessageEvent> {

    @Override
    public void onEvent(SendMessageEvent sendMessageEvent) {
        System.out.println("发送短信到" + sendMessageEvent.getSource());
    }
}
