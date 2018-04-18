package cn.com.dom4j;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{12, 1, 50, 8, 9, 8, 6, 7, 10, 3};

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));


    }



}
