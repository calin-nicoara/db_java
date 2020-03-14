package ro.cni.course.deutschebank.day6.annotations;


public class MainAnnotation {

    public static void main(String[] args) {
        DeprecatedClass deprecatedClass = new DeprecatedClass();

        deprecatedClass.deprecatedMethod();

        FunctionalTest functionalTest = () -> System.out.println("good");

        functionalTest.test();
    }
}
