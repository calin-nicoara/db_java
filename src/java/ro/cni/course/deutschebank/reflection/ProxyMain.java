package ro.cni.course.deutschebank.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyMain {
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("hello", "there");

        final Map<String, String> proxyMap = (Map) Proxy.newProxyInstance(
                ProxyMain.class.getClassLoader(),
                new Class[]{Map.class},
                new MyInvocationHandler(myMap)
        );

        proxyMap.put("test", "this");

        System.out.println(proxyMap.get("test"));
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Map target;

    public MyInvocationHandler(Map target) {
        this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        System.out.println("Proxy used");
        System.out.println(method.getName());
        for(Object arg: args) {
            System.out.println("Argument: " +  arg);
        }

        final Object invoke = method.invoke(target, args);

        return invoke;
    }
}

