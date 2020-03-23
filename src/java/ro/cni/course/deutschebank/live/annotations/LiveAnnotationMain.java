package ro.cni.course.deutschebank.live.annotations;

import java.util.ArrayList;
import java.util.List;

//@ExampleAnnotation(name = "name1")
@ExampleAnnotation(name = "name1")
public class LiveAnnotationMain {

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        @Deprecated TEstDeprecated tEstDeprecated = new TEstDeprecated();

        System.out.println(tEstDeprecated.name);
        tEstDeprecated.testDep();


    }

    @SuppressWarnings({"unchecked", "deprecation"})
    public void testSupress() {
        List testList = new ArrayList();

        testList.add("hello");
    }
}
