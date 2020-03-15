package ro.cni.course.deutschebank.day6.reflection;

public class ReflectionDummy extends ReflectionDummyParent{

    public String address = "NOWHERE";

    public ReflectionDummy() {
    }

    public ReflectionDummy(String address){
        this.address = address;
    }

    public void eatCake() {
        System.out.println("Cake is really good!");
    }
}
