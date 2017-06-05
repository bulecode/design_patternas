package pattern.observer_spring;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * Author: buleCode
 * Date: 2017/6/5
 */
public class ClassUtil {


    //运行时的classpath
    private static String[] classPaths = System.getProperty("java.class.path").split(";");
    //系统文件分隔符
    private static String separator = System.getProperty("file.separator");
    //需要排除扫描的一些路径 需要使用 / 做分隔符 eg：com/sun
    private static String[] excludeJar = new String[]{"sun","com/sun","javafx","java","jdk","com/intellij"};

    /**
     * 获取一个接口或者父类的所有子类(不含接口和抽象类)
     * @param clazz 接口类或者父类
     * @return
     */
    public static List<Class> getAllClassBySubClass(Class clazz) {

        return getAllClassBySubClass(clazz, true);
    }

    /**
     * 获取一个接口或者父类的所有子类(不含接口和抽象类)
     * @param clazz 接口类或者父类
     * @param findInJar 是否需要从jar包中查找
     * @return
     */
    public static List<Class> getAllClassBySubClass(Class clazz,boolean findInJar) {

        List<Class> ret = getClasspathAllClass(true).stream()
                .filter(c -> !c.isInterface())
                .filter(c -> !Modifier.isAbstract(c.getModifiers()))
                .filter(c -> clazz.isAssignableFrom(c))
                .collect(Collectors.toList());

        return ret;
    }


    /**
     * 获取所有classpath下的class
     * @return
     */
    private static List<Class> getClasspathAllClass(boolean findInJar) {
        List<Class> ret = new LinkedList<>();

        for (String classPath : classPaths) {
            File file = new File(classPath);
            ret.addAll(findClass(file, classPath,findInJar));
        }

        return ret;
    }

    /**
     * 递归查找class
     * @param file
     * @param classpath
     * @return
     */
    private static List<Class> findClass(File file, String classpath,boolean findInJar) {
        List<Class> ret = new LinkedList<>();
        if (!file.exists()) {
            return ret;
        }

        //是文件夹 递归查找
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    ret.addAll(findClass(f, classpath,findInJar));
                }
            }
        } else if (file.isFile()) {
            //是普通字节码文件
            if (file.getName().endsWith(".class")) {
                String fullyQualifiedName = getFullyQualifiedName(file, classpath);
                try {
                    ret.add(Class.forName(fullyQualifiedName));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            //jar包
            } else if (findInJar && file.getName().endsWith(".jar")) {
                try {
                    JarFile jarFile = new JarFile(file);
                    //枚举jar包内所有文件
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        String jarClassName = entries.nextElement().getName();
                        //jar包里的字节码文件
                        if (!isExclude(jarClassName) && jarClassName.endsWith(".class")) {
                            String fullyQualifiedName = jarClassName
                                    .replace(".class", "")
                                    .replaceAll("/", ".");
                            try {
                                ret.add(Class.forName(fullyQualifiedName));
                            } catch (Exception e) {
                                //
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }


    /**
     * 获取普通字节码文件的全限定名
     * @param file
     * @param classpath
     * @return
     */
    private static String getFullyQualifiedName(File file,String classpath) {
        String filePath = file.getPath();
        return filePath.replace(classpath, "")
                .replaceAll("\\\\", ".")
                .replaceFirst(".","")
                .replace(".class","");
    }

    private static boolean isExclude(String jarClassName) {
        for (String s : excludeJar) {
            if (jarClassName.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

}