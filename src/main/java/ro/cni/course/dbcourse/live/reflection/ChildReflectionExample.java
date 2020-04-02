package ro.cni.course.dbcourse.live.reflection;

import java.time.LocalDateTime;

public class ChildReflectionExample extends ReflectionExample {

    @AnnotationForReflection(isSpecial = true)
    private String childName;

    private LocalDateTime childDate = LocalDateTime.now();

    @AnnotationForReflection(isSpecial = true)
    public String nickname = "Nick";

    private void privateMethod() {
        System.out.println("I am a private method!");
    }

    private ChildReflectionExample() {

    }

    public ChildReflectionExample(String childName) {
        super("I am child!");
        this.childName = childName;
    }

    public ChildReflectionExample(LocalDateTime localDateTime) {
        this.childDate = localDateTime;
    }

    public String getName() {
        return childName;
    }
}
