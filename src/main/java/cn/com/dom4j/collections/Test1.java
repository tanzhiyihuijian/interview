package cn.com.dom4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Test1 {


    @Test
    public void f1() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf((char) (97 + i)));
        }

        System.out.println(list);

        for (String s : list) {
            if (Objects.equals(s, "a")) {
                list.remove(s);
                break;
            }
        }

        Iterator<String> iterator = list.iterator();

//        list.removeIf(next -> Objects.equals(next, "b") || Objects.equals(next, "c"));

        while (iterator.hasNext()) {
            iterator.remove();
        }


        System.out.println(list);






    }





}
