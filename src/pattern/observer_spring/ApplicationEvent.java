package pattern.observer_spring;

import java.util.EventObject;

/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }


}
