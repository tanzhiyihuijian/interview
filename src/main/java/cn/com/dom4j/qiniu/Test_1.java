package cn.com.dom4j.qiniu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_1 {

    public static void main(String[] args) {

        int[] arr = {3, 6, 9, 12, 1, 2, 11, 124, 3};

        System.out.println(f1(arr));



    }


    // 给定一个正整数序列，请尝试通过将它们重新排列，组合成一个最小的整数。
    // 例如输入为数组 [3, 6, 9, 12]，返回值为12369。由于有可能会超出整数最大范围，所以请返回字符串类型。
    public static String f1(int[] arr) {

        // 规则
        // 2. 首位最小的元素放在最开始的位置

        List<String> list = new ArrayList<>();
        for (int i : arr) {
            list.add(String.valueOf(i));
        }

        Collections.sort(list);


        System.out.println(list);

        return null;
    }

    // 你使用过哪些云服务, 是什么场景下使用的, 云服务和传统 IT的优势有哪些


}
