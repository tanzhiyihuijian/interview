package cn.com.dom4j.base;

import cn.com.dom4j.array.Person;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class Test1 {


    @Test
    public void f2() {

        String hello = reverse("hello");

        System.out.println(hello);


        String s1 = "你好";

        try {
            String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        Month month = now.getMonth();
        DayOfWeek dayOfWeek = now.getDayOfWeek();


//        assert false : "错误啦";


        int i = testFinallyReturn();
        System.out.println(i);


    }

    public int testFinallyReturn() {

        int i = 0;

        try {
            i = 1;
            int x = 10 / 0;
            return i;
        } catch (Exception e) {
            i = 2;
            return i;
        } finally {
            i = 3;
        }


    }





    // 字符串反转
    public String reverse(String str) {

        if (str == null || str.length() <= 1) {
            return str;
        }

        // 第一种: 字符数组实现
        /*char[] chars = str.toCharArray();

        StringBuilder s = new StringBuilder();
        for (char c : chars) {
            s.insert(0, c);
        }

        return s.toString();*/


        return reverse(str.substring(1)) + str.charAt(0);


    }


    @Test
    public void f1() {

        float f = 3.6F;


        // Java中整数类型默认为 int
        // 这里没报错的原因: 编译时候会进行检查, 看赋值大小是否超过 short类型的取值范围
        // 如果超过, 报错, 因为强制类型转换会有精度丢失; 没有超过, 则编译通过
        short s = 100;


        System.out.println("s = " + s);


        Person person = new Person();
        person.setName("555");

        update(person);

        System.out.println("person.name = " + person.getName());



    }

    public int f() {

        int i = 1;

        try {
            i = 2;
            throw new Exception("");
        } catch (Exception e) {
            i = 3;
        } finally {
            i = 4;
        }


        return 0;

    }



    public void update(Person person) {


        person.setName("666");



    }


}
