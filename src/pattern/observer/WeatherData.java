package pattern.observer;

import java.util.Random;

/**
 *
 *
 *
 * Author: buleCode
 * Date: 2017/5/21
 */
public class WeatherData {

    //获取温度数据
    public float getTemperature() {
        return new Random().nextFloat() * 40;
    }

    //获取湿度
    public float getHumidity() {
        return new Random().nextFloat() * 100;
    }

    public float getPressure() {
        return new Random().nextFloat() * 1000;

    }


}
