package pattern.observer_spring;


import java.io.File;
import java.io.IOException;

/**
 * Author: buleCode
 * Date: 2017/5/28
 */
public class EventManager {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("E:\\code\\design_patternas\\out\\production\\design_patternas\\pattern\\observer\\CountAvgDisplay.class");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(System.getProperties());
        System.out.println(ClassUtil.getAllClassBySubClass(Listener.class));

        Class<?> aClass = Class.forName("pattern.observer_spring.TestListener");
//        System.out.println(aClass.is(Listener.class));

    }


}
