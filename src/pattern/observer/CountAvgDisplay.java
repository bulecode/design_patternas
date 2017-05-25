package pattern.observer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 天气统计
 * Author: buleCode
 * Date: 2017/5/25
 */
public class CountAvgDisplay implements Observer,DispalyElement {

    private Subject subject;

    Map<LocalDateTime,WeatherData> map = new HashMap<>(50);

    public CountAvgDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(Object o) {
        map.put( LocalDateTime.now(),(WeatherData) o);

        map.keySet().forEach(t -> {
            if (t.plusDays(1).isBefore(LocalDateTime.now())) {
                map.remove(t);
            }
        });

        display();
    }

    @Override
    public void display() {
        if (map.size() == 0) {
            System.out.printf("平均气温: 未知 \n最低气温: 未知 \n最高气温: 未知\n\n");
            return;
        }

        Stream<Float> floatStream = map.values().stream().map(data -> data.getTemperature());
//        Float max = floatStream.reduce((a, b) -> Float.max(a, b)).orElse(0F);
//        Float min = floatStream.reduce((a, b) -> Float.min(a, b)).orElse(0F);
        Float max = map.values().stream().map(data -> data.getTemperature()).max(Float::compareTo).get();
        Float min = map.values().stream().map(data -> data.getTemperature()).min(Float::compareTo).get();
        float avg = map.values().stream().map(data -> data.getTemperature()).reduce((a,b) -> a + b).get()
                / floatStream.toArray().length;

        System.out.printf("平均气温: %f \n最低气温: %f \n最高气温: %f\n\n",avg,min,max);
    }
}
