package test.classes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//https://gitee.com/lin-mt/effective-java-third-edition/blob/master/%E7%AC%AC05%E7%AB%A0%EF%BC%9A%E6%B3%9B%E5%9E%8B/%E7%AC%AC28%E9%A1%B9%EF%BC%9A%E5%88%97%E8%A1%A8%E4%BC%98%E5%85%88%E4%BA%8E%E6%95%B0%E7%BB%84.md

public class TestGenerics {

    public static void main(String[] args) {

        String[]  array = {"Hello","world"};
        List<String> list = Arrays.asList(array);

        Object choose = new GenericsTest01(array).choose();
        //GenericsTest01 的缺点是每次都要去强转
        System.out.println(choose);

        String choose1 = new GenericsTest02<String>(list).choose();
        System.out.println(choose1);


        //带 extends 限定（上界）的通配符类型使得类型是协变的（covariant）。
        List<? extends Object> objList = new ArrayList<String>();

        // set( )方法失效。但取东西get( )方法还有效
        // objList.add(new Object());  // 会报错
        for (Object o : objList) {
            System.out.println(o);
        }




    }


}

class GenericsTest01 {

    public Object[] choiceArray;

    public GenericsTest01(Object[] choiceArray) {
        this.choiceArray = choiceArray;
    }

    public Object choose() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return choiceArray[current.nextInt(choiceArray.length)];
    }

}



// 用泛型改造
class GenericsTest02<T> {

    public T[] choiceArray;

    public GenericsTest02(Collection<T> choiceArray) {
        this.choiceArray = (T[])choiceArray.toArray();
    }

    public T choose() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return choiceArray[current.nextInt(choiceArray.length)];
    }

}


