package ro.cni.course.deutschebank.reflection;

public class ReflectionDummy extends ReflectionDummyParent{

    public String address = "NOWHERE";
    private String privateSecret = "privateSecret";

    public ReflectionDummy() {
    }

    public ReflectionDummy(String address){
        this.address = address;
    }

    public void eatCake() {
        System.out.println("Cake is really good!");
    }
}
