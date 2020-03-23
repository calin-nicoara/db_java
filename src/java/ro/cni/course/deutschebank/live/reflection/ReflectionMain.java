package ro.cni.course.deutschebank.live.reflection;

import java.lang.reflect.*;

public class ReflectionMain {

    public static void main(String[] args) {
//        final Class<ChildReflectionExample> childClass = ChildReflectionExample.class;
//
//        ChildReflectionExample childReflectionExample = new ChildReflectionExample("Bebe");



    }

    private static void forArray() {
        int[] intArray = new int[]{1, 3, 4, 5};

        final Class<? extends int[]> aClass = intArray.getClass();

        final Object o = Array.get(intArray, 2);
        System.out.println(o);

        final Class<Integer> componentType = int.class;
        Array.newInstance(componentType, 5);
    }

    private static void annotationExample(final Class<ChildReflectionExample> childClass, final ChildReflectionExample childReflectionExample) {
        for(Field field: childClass.getDeclaredFields()) {
            final AnnotationForReflection annotation = field.getAnnotation(AnnotationForReflection.class);
            if(annotation != null && annotation.isSpecial()) {
                try {
                    if(Modifier.isPrivate(field.getModifiers())){
                        field.setAccessible(true);
                    }

                    System.out.println(field.get(childReflectionExample));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void forConstructor(final Class<ChildReflectionExample> childClass) {
        try {
            final Constructor<ChildReflectionExample> constructor = childClass.getConstructor(String.class);

            final ChildReflectionExample childReflectionExample1 = constructor.newInstance("Dynamic Constructor");

            System.out.println(childReflectionExample1.getName());

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void forMethods(final Class<ChildReflectionExample> childClass, final ChildReflectionExample childReflectionExample) {
        try {
            final Method publicMethod = childClass.getMethod("publicMethod", String.class);

            publicMethod.invoke(childReflectionExample, "dymanic_invocation");

            final Method privateMethod = childClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(childReflectionExample);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void forFields(final Class<ChildReflectionExample> childClass, final ChildReflectionExample childReflectionExample) {
        try {
            final Field childNameField = childClass.getDeclaredField("childName");
            childNameField.setAccessible(true);
            final Object o = childNameField.get(childReflectionExample);
            System.out.println(o);

            childNameField.set(childReflectionExample, "New name");

            System.out.println(childNameField.get(childReflectionExample));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void showAllFields(final Class<ChildReflectionExample> childClass) {
        System.out.println("Declared fields");
        for(Field deField: childClass.getDeclaredFields()){
            System.out.println(deField.getName());
        }

        System.out.println();
        System.out.println("Fields");
        childClass.getFields();
        for(Field deField: childClass.getFields()){
            System.out.println(deField.getName());
        }
    }

    private static void refelctionExample() {
        ReflectionExample reflectionExample = new ReflectionExample("I am here!");

        Class aClass = ReflectionExample.class;

        final int modifiers = aClass.getModifiers();

        System.out.println(Modifier.isPublic(modifiers));

        aClass.getFields();

        showReflected("I am String!");
    }

    public static void showReflected(Object object) {
        final Class<?> aClass = object.getClass();

        System.out.println(aClass);
    }
}
