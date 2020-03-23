package ro.cni.course.deutschebank.live.reflection;

public class ReflectionExample {

    private String privateSecret;
    public String publicValue;

    public ReflectionExample() {}
    public ReflectionExample(String publicValue) {
        this.publicValue = publicValue;
    }

    private void privateMethod() {
        System.out.println("I am a private method!");
    }

    public void publicMethod() {
        System.out.println("I am a public method!");
    }

    public void publicMethod(String variable) {
        System.out.println(variable);
    }

    public static void publicStaticMethod() {

    }
}
