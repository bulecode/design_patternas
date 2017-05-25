package pattern.observer;

/**
 * Author: buleCode
 * Date: 2017/5/25
 */
public class ObserverTest {

    public static void main(String[] args) {
        WeatherSubject subject = new WeatherSubject();

        DispalyElement currentdisplay = new CurrentConditionsDisplay(subject);
        DispalyElement display = new CountAvgDisplay(subject);


        subject.setWeatherData(new WeatherData());
        subject.setWeatherData(new WeatherData());
        subject.setWeatherData(new WeatherData());


    }
}
