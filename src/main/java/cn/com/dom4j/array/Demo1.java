package cn.com.dom4j.array;

import cn.com.dom4j.access.ProtectedBean;
import org.junit.Test;

import java.util.Arrays;

public class Demo1 {


    public static void main(String[] args) {


//        f1();

//        f2();


    }


    @Test
    public void f4() {

        SubBean subBean = new SubBean();




    }


    @Test
    public void f3() {

        int[] arr = {1, 2, 3, 4};

        System.out.println(arr.length);

        String[] array = {"a", "b", "c"};

        System.out.println(array.length);




    }




    private static void f2() {

        Employee[] arr = new Employee[10];

        arr[0] = new Employee("Employee-0");

        printArray(arr);

    }

    private static void printArray(Person[] arr) {

        System.out.println(Arrays.toString(arr));

    }


    private static void f1() {


        Person[] arr = new Employee[10];

        arr[0] = new Student("Student-1");

        System.out.println(Arrays.toString(arr));

    }

}
