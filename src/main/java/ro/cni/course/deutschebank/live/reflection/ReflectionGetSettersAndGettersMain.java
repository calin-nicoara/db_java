package ro.cni.course.deutschebank.live.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionGetSettersAndGettersMain {

    public static void main(String[] args) {
        ExampleBean exampleBean = new ExampleBean();

        System.out.println("Getters");
        Arrays
                .asList(exampleBean.getClass().getMethods())
                .stream()
                .filter(s -> isGetter(s))
                .forEach(s -> System.out.println(s.getName()));
    }

    public static boolean isGetter(Method method) {
        if(!method.getName().startsWith("get")) return false;
        if(void.class.equals(method.getReturnType())) return false;
//        if(!Modifier.isPublic(method.getModifiers())) return false;
        if(method.getParameterTypes().length != 0) return false;
        if(method.getName().equals("getClass")) return false;

        return true;
    }


}
