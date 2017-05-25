package pattern.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author: buleCode
 * Date: 2017/5/21
 */
public class WeatherSubject implements Subject {

    private List<Observer> observers = new LinkedList<>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private WeatherData weatherData;

    public WeatherSubject(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public WeatherSubject() {
    }

    @Override
    public void registerObserver(Observer o) {
        lock.writeLock().lock();
        observers.add(o);
        System.out.println("加入新的观察者:" + o);
        lock.writeLock().unlock();
    }

    @Override
    public void removeObserver(Observer o) {
        lock.writeLock().lock();
        observers.remove(o);
        System.out.printf("观察者:%s 离开了",o);
        lock.writeLock().unlock();
    }

    @Override
    public void notifyObservers() {
        lock.readLock().lock();
        observers.forEach(o -> o.update(weatherData));
        lock.readLock().unlock();
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }
}
