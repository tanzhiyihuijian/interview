package cn.com.dom4j.sort;

import java.util.Arrays;

public class Test2 {


    public static void main(String[] args) {

        Integer[] arr = {15, 4, 13, 2, 11, 9, 23, 36, 1, 16, 23, 25};

//        insertionSort_1(arr);

//        insertionSort_2(arr);

//        shellSort(arr);

//        heapSort(arr);

//        mergeSort(arr);

        quickSort(arr);






        System.out.println(Arrays.toString(arr));
    }

    /*
     插入排序
        插入排序是最简单的排序算法之一
        插入排序由 N - 1趟排序组成, 对于 p = 1到 N - 1趟, 插入排序保证从 0到位置 p - 1上的元素为已排序状态
        基本思路:
            在第 p趟, 我们将位置 p上的元素向左移动, 知道它在前 p + 1个元素中的正确位置被找到的地方

     */
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort_1(AnyType[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /*
     上面排序中存在的缺陷:
        在寻找第 p个元素的正确位置时, 采用了相邻元素比较并交换位置的方式, 这样会产生多余赋值操作

     解决方式:
        记录第 p个元素的值, 逐一和前面元素比较, 比 p大的元素, 位置后移一个 (a[j] = a[j-1]), 直到遇到比 p小的元素.
        最后把 p放在终止时的位置(第一个遇到的比 p小的元素后面)即可
     */

    /**
     * 优化过后的插入排序
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort_2(AnyType[] a) {

        int j;
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }


    /**
     * 希尔排序
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a) {

        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = 1; i < a.length; i++) {
                AnyType tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
        }
    }

    /**
     * 堆排序
     */
    public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a) {

        // buildHeap
        for (int i = a.length / 2; i >= 0; i--) {
            // 将数组值按初始顺序放入堆中, 从根节点执行下滤操作将构建一个堆
            percolateDown(a, i, a.length);
        }

        // deleteMax
        for (int i = a.length - 1; i > 0; i--) {
            // 在构建了一个 max堆后, 将根节点与最后一个元素互换, 同时将堆的大小 -1, 调整位置, 再次实现堆序
            // 这样每互换一次, 最大的元素就会放在堆的后面 (已经从堆中删除, 不属于堆了), 堆后面的元素会保持顺序, 直到堆中只剩一个元素为止
            swap(a, 0, i);
            percolateDown(a, 0, i);
        }

    }

    /**
     * 下滤操作: 调整某个节点的位置, 以保持堆序
     *
     * @param a 待排序序列
     * @param i 要调整的节点在数组中的索引
     * @param n 堆的大小 (堆中元素个数)
     */
    private static <AnyType extends Comparable<? super AnyType>> void percolateDown(AnyType[] a, int i, int n) {

        int child;
        AnyType tmp;

        // tmp记录被调整元素的值, i的值随 child不断改变, 直到比较完所有的子节点 (leftChild(i) < n) 为止
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            // child == n - 1时, 其左子节点为堆的最后一个元素, 没有右节点, 无须比较
            // 将该节点与其左右节点比较, 记录其中最小的节点的索引
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            // 将需要被调整和节点与其子节点进行比较, 如果小于子节点, 当前节点的值替换为子节点的值 (注意不是交换)
            if (tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        // 找到合适的位置后, 直接赋值来避免多余的交换操作
        a[i] = tmp;
    }

    /**
     * 获取某个节点的左子节点在数组中的索引, 因为是从 0开始的, 所以要 +1
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }


    /**
     归并排序
     这个算法的基本操作是合并两个已排序的表. 因为这两个表示已排序的, 所以若将输出放到第三个表中, 则该算法可以通过一趟排序来完成
     1. 合并两个已排序的表的时间显然是线性的, 因为最多进行 N-1 次比较, 其中 N是元素的总数
     2. 该算法是经典的分治(divide-and-conquer)策略, 他将问题分(divide)成一些小的问题, 然后递归求解,
     而治(conquer)的阶段则将分的阶段解得的各个答案修补在一起. 分而治之是递归非常有效的用法
     (注: 当将数组分解到仅有一个项时, 该子数组便是有序的, 便可以进行合并操作, 这是一个基准情形)

     */
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a) {

        // 产生一个临时数组, 用以存储已经排序好的序列, 每次比较将较小的数先放到临时数组中, 最后在对应位置将元素拷贝至原数组
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];

        // 递归分解并将子数组排序的例程
        mergeSort(a, tmpArray, 0, a.length - 1);

    }

    /**
     * 将数组均分成两个较小的数组, 并对分解过后的数组进行排序
     *
     * @param a 原始的数组
     * @param tmpArray 临时数组, 用于存放比较过程中已经排序好的子序列
     * @param left 子序列的起始索引
     * @param right 子序列的结束位置索引
     * @param <AnyType> 实现的 Comparable接口的类或其子类
     */
    private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right) {

        // 保证子数组至少有两个元素
        if (left < right) {

            int center = (left + right) / 2;
            // 分解数组
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            // 合并的主例程
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * 将两个已经排序好的子序列( A和 B)合并, 并放到原始数组中的正确位置
     *
     * @param a 原始数组
     * @param tmpArray 临时数组, 用于存放比较过程中产生的已排序的子序列
     * @param leftPos A序列的起始索引, A序列的结束索引通过 rightPos - 1来计算  (两个序列均是 左开又开 [])
     * @param rightPos B序列的起始索引
     * @param rightEnd B序列的结束索引
     * @param <AnyType> 实现了 Comparable接口的类型或其子类
     */
    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd) {

        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // 将子数组的起始索引暂存起来, 用于数组拷贝   (因为: leftPos在比较时, 会发生变化(向后推进))
        int fromIndex = leftPos;

        // 两个序列均没有比较完的情况
        while (leftPos <= leftEnd && rightPos <= rightEnd) {

            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        // A序列已经比较完, 将 B序列中的剩余元素拷贝至临时数组
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        // B序列已经比较完, 将 A序列中的剩余元素拷贝至临时数组
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // 将两个子序列的元素存储到原始数组中 (对临时数组相应区间进行拷贝)
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }

        // 也可以通过如下方式进行数组拷贝
        System.arraycopy(tmpArray, fromIndex, a, fromIndex, numElements);

    }


    public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a, int left, int right) {

        // 定义数组大小边界, 小于这个值时使用插入排序
        int CUTOFF = 10;

        // 数组元素较少的时候, 使用插入排序来获取更快的速度; 元素较多时, 使用快排
        if (left + CUTOFF <= right) {

            // 三数中值分割法产生枢纽元
            AnyType pivot = median3(a, left, right);

            // i: 比枢纽元小的元素起始索引; i: 大元素的起始索引
            int i = left, j = right - 1;

            for ( ; ; ) {
                // 小元素指针不断向右推进, 直到找到比枢纽元大的元素
                while (a[++i].compareTo(pivot) < 0) {

                }
                // 大元素指针向左推进, 遇到比枢纽元小的元素终止
                while (a[--j].compareTo(pivot) > 0) {

                }
                // 两个索引未交叉时, 代表大小序列还未分割完成, 交换位置后继续分割
                // 交叉时代表分割完成
                if (i < j)
                    swap(a, i, j);
                else
                    break;
            }

            // 分割完成后, 将枢纽元和小元素索引终止处的元素位置互换
            // 此时, 枢纽元左侧都为小元素, 右侧都为大元素 (相对于枢纽元而言)
            swap(a, i, right - 1);

            // 对分割后的子序列重复上面操作
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);

        } else {
            insertionSort(a, left, right);
        }

    }

    /**
     * 对数组的指定部分使用插入排序
     * @param a 原始数组
     * @param left 起始索引
     * @param right 结束索引
     * @param <AnyType> 实现了 Comparable接口的类型或其子类
     */
    private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a, int left, int right) {

        if (right - left == 0 || left < 0 || right > a.length - 1) {
            return;
        }

        AnyType tmp;
        int j;
        for (int i = left + 1; i <= right; i++) {
            tmp = a[i];
            for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 三数中值分割法
     */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right) {

        int center = (right - left) / 2;

        if (a[center].compareTo(a[left]) < 0) {
            swap(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swap(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            swap(a, center, right);
        }

        swap(a, center, right - 1);

        return a[right - 1];

    }


    /**
     * 交换数组中两个元素的位置
     */
    private static <AnyType extends Comparable<? super AnyType>> void swap(AnyType[] arr, int i, int j) {
        if (arr == null || arr.length <= 1 || i == j) {
            return;
        }

        AnyType tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
