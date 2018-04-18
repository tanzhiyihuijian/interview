package cn.com.dom4j.note;

import org.junit.Test;

public class Note_1 {


    public static void main(String[] args) {



    }

    @Test
    public void f4() {

        System.out.println(sum(100));





    }

    private int sum(int i) {
        return i == 1 ? 1 : i + sum(i - 1);
    }



    @Test
    public void f3() {

        Integer a = new Integer(1);

        Integer b = a;

        doSomeThing(b);

        System.out.println(a.intValue());
        System.out.println(a == b);
    }


    @Test
    public void f2() {

        // true   unBoxing
        System.out.println(new Integer(1) == 1);

        // false   新建了两个箱子, 比较这两个箱子是不是相等
        System.out.println(new Integer(1) == new Integer(1));

        // 不确定
        // This method will always cache values in the range -128 to 127,
        // inclusive, and may cache other values outside of this range.

        // public static Integer valueOf(int i) {
        //     if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
        //         return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
        //     return new Integer(i);
        // }
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));


        // true
        System.out.println(Integer.valueOf(2).intValue() == 2);

        // true
        System.out.println(new Integer(2).equals(2));



    }


    @Test
    public void f1() {

        Integer a = 1;

        a = new Integer(2);

        System.out.println(a.intValue());


    }

    public static void doSomeThing(int i) {
        i = new Integer(2);
    }


}




/*

第五章: 程序设计语言基础

1. 程序设计语言归类
    1.1 类型检查: 编译时; 运行时
    1.2 编译和运行: 编译成机器代码运行; 编译为中间代码,在虚拟机运行; 解释执行
    1.3 编程范式: 面向过程; 面向对象; 函数式

    1.4 常见问题
        1.4.1 比较一下 a语言和 b语言?
        1.4.2 介绍一下面向对象思想
        1.4.3 介绍一下函数式编程, 函数式编程和函数指针的区别

2. 数据类型
    boolean, byte, char
    short, int, long, float, double
    String, Enum, Array
    Object...

    2.1 32位 int的范围 ?
        -2^31 ~ 2^31 - 1

        使用补码: 取反加一
        如何表示 -1
        1           ->  取反            -> 加1
        0000...0001 ->  1111...1110     -> 1111...1111

        使用补码的好处

    3.2 浮点数
        浮点数: (+/-) 1.xxx * 2^y
                符号位 | 指数部分 | 基数部分
        64位 double范围: +/- 10^308
        64位 double精度: 10^15

        浮点数比较
            a == b ?
            Math(a - b) < eps ?
            使用 BigDecimal算钱 (使用分或万分之一元来计算钱)

    3.3 Java数据类型
        primitive type: int, long, float...
            值类型
            用 == 号判断相等

        Object: Integer, Long, Float, String...
            引用类型
            用 a == b 判断是否为同一个 Object
            用 a.equals(b) 或 Objects.equals(a, b) 判断是否相等

    3.4 Boxing & UnBoxing
        Integer a = 2;
        Integer b = new Integer(2);     // 生成一个箱子, 然后把2方法哦这个箱子中, 让 b指向这个箱子

    4.4 常见问题
        4.4.1 整数在内存中会怎么表示的? 浮点数是怎么表示的?
        4.4.2 什么是 Big-Endian / Little-Endian? 什么是对齐?
        4.4.3 介绍一些 Java/C++/Python的数据类型?
        4.4.4 什么是值传递? 什么是引用传递?
        4.4.5 什么是装箱拆箱?
        4.4.6 String s = new String("str"); 创建了多少个对象?
        4.4.7 equals和 hashCode的关系?
            hashCode相等是 equals的一个必要条件
        4.4.8 什么是序列化和反序列化?
            内存 -> 字节流
            树的序列化


-------------------------------------------------------------------

第六章: 编码能力和编码技巧

1. 数学归纳法
    用于证明断言对所有自然数成立
        证明对于 N = 1成立
        证明 N > 1时: 如果对于 N - 1 成立, 那么对于 N成立


2. 递归书写方法
    严格定义递归函数作用, 包括参数, 返回值, Side-effect
    先一般后特殊
    每次调用必须缩小问题规模
    每次问题规模缩小成都必须为1     -> 数学归纳法






1. 递归控制





2. 循环控制




3. 边界控制



4. 数据结构



















 */