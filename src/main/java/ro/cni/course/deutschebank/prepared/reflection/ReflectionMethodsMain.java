package ro.cni.course.dbcourse.prepared.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethodsMain {
    public static void main(String[] args) {
        Client client = new Client();

        client.setName("Denis");
        client.setLastName("The Menice");

        Class<?> aClass = client.getClass();

        try {
            final Method setNameMethod = aClass.getMethod("setName", String.class);
            setNameMethod.invoke(client, "The Good boy");
            System.out.println(client.getName());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static class Client {

        private String name;
        String lastName;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(final String lastName) {
            this.lastName = lastName;
        }
    }
}
