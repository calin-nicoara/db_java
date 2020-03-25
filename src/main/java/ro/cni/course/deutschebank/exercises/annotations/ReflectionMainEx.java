package ro.cni.course.deutschebank.exercises.annotations;

import java.lang.reflect.Field;

public class ReflectionMainEx {
    public static void main(String[] args) {
        Product product = new Product(100, "Coca-Cola", "A tasty delicious drink", "Carrefour", null);

        String json = toJson(product);
        System.out.println(json); // { "code": 100, "name": "Coca-Cola", "description": "A tasty delicious dr"}
    }

    public static String toJson(Object target) {
        try {
            StringBuilder jsonBuilder = new StringBuilder("{");
            final Class<?> aClass = target.getClass();

            for (Field field : aClass.getFields()) {
                final JsonField annotation = field.getAnnotation(JsonField.class);
                if(annotation != null) {
                    String nameForJson = annotation.name().equals("") ? field.getName() : annotation.name();
                    Object value = field.get(target);

                    final boolean valueNotValid = !annotation.canBeNull() && value == null;

                    if(valueNotValid) {
                        continue;
                    }

                    if(value != null && value.getClass().equals(String.class)) {
                        String stringField = (String) value;
                        if(stringField.length() > annotation.lengthToTrimString()) {
                            value = stringField.substring(0, annotation.lengthToTrimString());
                        }
                        value = "\"" + value + "\"";
                    }

                    jsonBuilder.append("\"").append(nameForJson).append("\"").append(":").append(value).append(",");
                }
            }

            final int i = jsonBuilder.lastIndexOf(",");
            jsonBuilder.delete(i,i+1);
            jsonBuilder.append("}");
            return jsonBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
