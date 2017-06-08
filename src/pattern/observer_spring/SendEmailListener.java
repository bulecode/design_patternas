package pattern.observer_spring;

/**
 * Author: buleCode
 * Date: 2017/6/8
 */
public class SendEmailListener implements Listener<SendEmailEvent> {
    @Override
    public void onEvent(SendEmailEvent sendEmailEvent) {
        System.out.println("发送邮件到" + sendEmailEvent.getSource());
    }
}
