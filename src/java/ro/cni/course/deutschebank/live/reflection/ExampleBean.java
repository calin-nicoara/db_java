package ro.cni.course.deutschebank.live.reflection;

import java.io.Serializable;

public class ExampleBean implements Serializable {

    private String property1;
    private String property2;
    private String property3;
    private String property4;

    public String giveMe() {
        return "give_me";
    }

    public void getNothing() {
    }

    public String getDummy() {
        return "dummy_example";
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty1Extra(String extra) {
        return property1;
    }

    public void setProperty1(final String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(final String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(final String property3) {
        this.property3 = property3;
    }

    public String getProperty4() {
        return property4;
    }

    public void setProperty4(final String property4) {
        this.property4 = property4;
    }
}
