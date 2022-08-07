package algorithm.a_leecodeEveryday.a_demo2022_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {
    private Object obj;
    public Object getInstance(Object obj){
        this.obj = obj;
        Class<?> clazz = obj.getClass();
        //classLoader,interfaces,InvocationHandler
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         *
         */
        //before();
        Object invoke = method.invoke(this.obj, args);
       // after();
        return invoke;
    }
}
