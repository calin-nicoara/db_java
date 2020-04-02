package ro.cni.course.dbcourse.prepared.reflection;

import java.lang.reflect.*;

public class ClassReflection {

    public static void main(String[] args) {
        ReflectionDummy reflectionDummy = new ReflectionDummy();

        final Class<? extends ReflectionDummy> aClass = reflectionDummy.getClass();

//        classStuff(aClass);
//        constructorStuff(aClass);
//        fieldStuff(aClass, reflectionDummy);
    }

    private static void constructorStuff(final Class<? extends ReflectionDummy> aClass) {
        final Constructor<?>[] constructors = aClass.getConstructors();
        for(Constructor<?> constructor: constructors) {
            for(Class<?> parameterClass: constructor.getParameterTypes()) {
                System.out.print(parameterClass);
            }
            System.out.println(" ---");
        }

        try {
            final Constructor<? extends ReflectionDummy> constructor = aClass.getConstructor(String.class);
            final ReflectionDummy reflectionDummy1 = constructor.newInstance("test-dymaic");

            System.out.println(reflectionDummy1.address);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void classStuff(final Class<? extends ReflectionDummy> aClass) {
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());

        final int modifiers = aClass.getModifiers();

        System.out.println(Modifier.isPublic(modifiers));
    }

    private static void fieldStuff(final Class<? extends ReflectionDummy> aClass,
                                   final ReflectionDummy reflectionDummy) {
        final Field[] fields = aClass.getDeclaredFields();
        for(Field field: fields) {
            System.out.print("Field: " + field.getName());
            try {
                if(Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                System.out.print("Value: " + field.get(reflectionDummy));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
