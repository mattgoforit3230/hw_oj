package template;

import java.util.function.Function;

/*
    java.util.function.Function<T, R>：接口用来根据一个类型的数据得到另一个类型的数据，
        前者称为前置条件，后者称为后置条件。
    Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
        使用的场景例如：将String类型转换为Integer类型。
 */
/**
 * 个人理解，前置条件用来传入，return后置条件，后面再通过apply取得
 */
public class TestFunction {
    public static void change(String s, Function<String,Integer> fun){
        int a = fun.apply(s);
        System.out.println(a);
    }
    public static void main(String[] args) {
        String s = "12314";
        change(s,(String str)->{
            return Integer.parseInt(str);
        });
        //优化
        //change(s,s1 -> Integer.parseInt(s1));
    }
}
