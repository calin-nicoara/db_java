package ro.cni.course.deutschebank.live.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyMain {
    public static void main(String[] args) {
//        List<String> listToProxy = new ArrayList<>();
//        listToProxy.add("1");
//        listToProxy.add("2");
//        listToProxy.add("3");
//
//        final List o = (List) Proxy.newProxyInstance(
//                List.class.getClassLoader(),
//                new Class[]{List.class},
//                new ExInvocationHandler(listToProxy));
//
//        o.add("2");
//
//        System.out.println(o);

        Shoutout shoutout = new Shoutout();

        final IShoutout o1 = (IShoutout) Proxy.newProxyInstance(
                IShoutout.class.getClassLoader(),
                new Class[]{IShoutout.class},
                new ExInvocationHandler(shoutout));

        o1.shoutout();
    }

    static class ExInvocationHandler implements InvocationHandler {

        private Object target;

        public ExInvocationHandler(final Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

            System.out.println("This is before");
            final Object invoke = method.invoke(target, args);
            System.out.println("This is after");
            return invoke;
        }
    }

    static class Shoutout implements IShoutout{
        public void shoutout() {
            System.out.println("Hello!");
        }
    }

    interface IShoutout {
        void shoutout();
    }
}
