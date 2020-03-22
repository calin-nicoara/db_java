package ro.cni.course.deutschebank.annotations;

@CustomAnnotation(
        name = "me",
        stringClass = String.class,
        createdAt = "yoday"
)
public class ParentClass {

    @CustomAnnotation(
            name = "me",
            stringClass = String.class,
            createdAt = "yoday"
    )
    public void eat() {

    }
}
