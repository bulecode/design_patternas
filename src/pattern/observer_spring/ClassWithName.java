package pattern.observer_spring;

/**
 * 用于封装 Class 及其 Class的name
 * 此地方需要通过name来判断是否为同一个Class 又需要 Class来判断是否有继承关系
 * Author: buleCode
 * Date: 2017/6/9
 */
public class ClassWithName {

    public ClassWithName(Class<? extends ApplicationEvent> eventClass, String name) {
        this.eventClass = eventClass;
        this.name = name;
    }

    public ClassWithName() {
    }

    private Class<? extends ApplicationEvent> eventClass;

    private String name;

    public Class<? extends ApplicationEvent> getEventClass() {
        return eventClass;
    }

    public void setEventClass(Class<? extends ApplicationEvent> eventClass) {
        this.eventClass = eventClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassWithName that = (ClassWithName) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
