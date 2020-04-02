package ro.cni.course.dbcourse.prepared.reflection;

import java.lang.reflect.Field;

public class ReflectionFieldsMain {
    public static void main(String[] args) {
        Client client = new Client();

        client.setName("Denis");
        client.setLastName("The Menice");

        Class<?> aClass = client.getClass();

        try {
            final Field nameField = aClass.getDeclaredField("name");
            final Object o = nameField.get(client);
            System.out.println(o);

            nameField.set(client, "Cornel");
            System.out.println(client.getName());
        } catch (NoSuchFieldException | IllegalAccessException e) {
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
