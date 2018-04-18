package cn.com.dom4j.sort;

import org.junit.Test;

import java.util.Arrays;

public class Test1 {


    @Test
    public void f1() {

        int[] arr = {6, 5, 4, 3, 2, 1};
//        insertSort(arr);
//        selectSort_2(arr);

//        bubbleSort(arr);

        heapSort(arr);


        System.out.println(Arrays.toString(arr));


        System.out.println(test(10));

    }

    @Test
    public void f2() {


    }


    public void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];

    }


    // 选择排序
    // 第一种: 简单选择排序
    // 基本思想: 每一趟从待排序的数据元素中选择最小(或最大)的一个元素作为首元素, 知道所有元素排序完成. 简单选择排序是不稳定排序
    //   在算法实现时, 每一趟确定最小元素的时候会通过不断的比较交换来使得首位置为当前最小, 交换是个比较耗时的操作
    //   在还未确定最小元素之前, 这些交换都是毫无意义的
    private void selectSort_1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    // 选择排序
    // 第二种: 优化过后的简单选择排序
    // 优化点:
    //    1. 去除多余的交换位置, 仅在确定最小值之后才交换位置
    private void selectSort_2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }


    // 冒泡排序
    // 基本思想: 对相邻元素进行两两比较, 顺序相反则进行交换, 这样, 每一趟会将最大(或最小的元素)"浮"到顶端, 最终达到完全有序
    private void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // 设定一个标记, 若为 true, 则表示此次循环没有进行交换, 也就是说待排序序列已经有序, 排序已经完成
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }


    // 插入排序
    // 基本思想: 每一步将一个待排序的记录, 插入到前面已经排好序的有序序列中去,直到插完所有的元素为止
    // 难点:
    //  * 如何维护已排序序列
    //      1. 在原有数组上维护, 交换位置来实现
    private void insertSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }


    // 堆排序
    private void heapSort(int[] arr) {

        // 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子节点从下至上, 从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        // 调整堆结构, 交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            // 将堆顶元素与末尾元素进行交换
            swap(arr, 0, j);
            // 重新对堆进行调整
            adjustHeap(arr, 0, j);
        }

    }


    /**
     * 调整大顶堆 (仅是调整过程, 建立在大顶堆已构建基础之上)
     */
    private void adjustHeap(int[] arr, int i, int length) {

        // 先取出当前元素 i
        int temp = arr[i];

        // 从 i节点的左子节点开始, 也就是 2i + 1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {

            // 如果左子节点小于右子节点, k指向右子节点
            if (k + 1  < length && arr[k] < arr[k + 1]) {
                k++;
            }

            // 如果子节点大于父节点, 将子节点赋值给父节点 (不进行交换)
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }

        }

        // 将 temp值放到最终位置
        arr[i] = temp;
    }


    /*
     快速排序
     算法思想: 基于分治思想, 是冒泡排序的改进型.
        首先在数组中选择一个基准点(该基准点的选取可能影响快速排序的效率),
        然后分别从数组的两端扫描数组, 设两个指示标志(low指向起始位置, high指向末尾),
        首先从后半部分开始, 如果发现有元素比基准点的值小, 就交换 low和 high的位置,
        然后从前半部分开始扫描, 发现有元素大于基准点的值, 就交换 low和 high的位置, 如此循环往复,
        直到 low >= high, 然后把基准点的值放在 high这个位置, 一次排序就完成了
        以后再用递归的方式分别对前半部分和后半部分排序, 当前半部分和后半部分均有序时该数组就自然有序了

     */
    private void quickSort(int[] arr) {





    }



    public static int test(int b) {
        try {
            b += 10;
            return b;
        } finally {
            b += 10;
            return b;
        }
    }
}
