package ro.cni.course.dbcourse.exercises.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonField {
    String name() default "";
    boolean canBeNull() default true;
    int lengthToTrimString() default 255;
}
