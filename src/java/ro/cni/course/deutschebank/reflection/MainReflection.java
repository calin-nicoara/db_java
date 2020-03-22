package ro.cni.course.deutschebank.reflection;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class MainReflection {

    public static void main(String[] args) {
        ReflectionDummy reflectionDummy = new ReflectionDummy();

        //Get Class
        final Class<? extends ReflectionDummy> aClass = reflectionDummy.getClass();

        System.out.println(aClass);

        final AnnotatedType annotatedSuperclass = aClass.getAnnotatedSuperclass();
        System.out.println(annotatedSuperclass.getType());

        // Use annotations
        ShopClient shopClient = new ShopClient("Mathew", 5,
                LocalDateTime.of(2010, 2, 2, 10, 1), true);

        final Class<? extends ShopClient> aClass1 = shopClient.getClass();

        final Method[] declaredMethods = aClass1.getDeclaredMethods();

        final Field[] declaredFields = aClass1.getDeclaredFields();

        StringBuilder sb = new StringBuilder();

        for(Field f: declaredFields) {
            f.setAccessible(true);
            final SecretInfoAnnotation annotation = f.getAnnotation(SecretInfoAnnotation.class);
            if(!annotation.isSecret()) {
                try {
                    sb.append(f.get(shopClient) + ", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(sb.toString());

    }
}
