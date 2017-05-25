package pattern.observer;

/**
 * 当前气温布告板
 * Author: buleCode
 * Date: 2017/5/25
 */
public class CurrentConditionsDisplay implements Observer,DispalyElement {

    private WeatherData data;

    public CurrentConditionsDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Object o) {
        data = (WeatherData) o;
        display();
    }

    @Override
    public void display() {
        if (data != null) {
            System.out.printf("当前温度: %f F \n 当前湿度: %f\n\n",
                    data.getTemperature(),
                    data.getHumidity());
        } else {
            System.out.printf("当前温度: 未知 \n 当前湿度: 未知\n\n");
        }


    }
}
