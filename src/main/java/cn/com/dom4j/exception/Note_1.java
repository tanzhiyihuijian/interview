package cn.com.dom4j.exception;

public class Note_1 {


}

/*

Java异常体系结构

1. 异常是什么 ?
    异常是程序运行过程中出现的错误.

2. 为什么会有异常 ?
    这个问题其实不难理解, 如果一切都按我们设计好的进行, 那么一般是不会出现异常的, 比如一个除法操作:
        public int divide(int x, int y) {
            return x / y;
        }
    当然我们设计的是除数不能为 0, 我们也在方法名上添加了注释, 输入不能为 0, 如果用户按照我们的要求使用这个方法, 当然不会有异常产生.
  可是很多时候, 用户不一定阅读我们的注释, 或者说, 用户输入的数据不是主动指定的, 而是程序计算的中间结果, 这个时候就会导致除数为 0的情况出现
    现在异常出现了, 程序应该怎么办呢, 直接挂掉肯定是不行的, 但是程序确实自己不能处理这种突发情况, 所以得想办法把这种情况告诉用户, 让用户自己来决定,
  也就是说, 程序需要把遇到的这种情况包装一下发送出去, 由用户来决定如何处理.

3. 在 Java中是如何描述异常的 ?
    总所周知, Java是一个面向对象的语言. 异常在 Java中也是被当做对象来处理, 通过异常类的继承关系形成了 Java的异常体系.
    Java异常体系的支撑类如下:
        Throwable
            |-- Error
            |-- Exception
                |-- checked exception
                |-- runtime exception (un-checked exception)


    所有的 Java异常都拓展于 Throwable类, 而 Throwable类有两个子类分别是 Error和 Exception, Error类表示由于虚拟机自身原因
  导致的错误, 如虚拟机内部错误以及内存溢出等, 而 Exception则是程序本身运行情况导致的错误, 包含程序逻辑问题以及程序 IO交互问题.
  程序设计基本不怎么关注 Error, 换句话说, Error异常除了重启之外基本无能为力, 这个是属于 JVM本身的问题, 而我们更应该关注 Exception
  类错误


    Throwable(表示可抛出):
        是所有异常和错误的超类, 两个直接子类为 Error和 Exception, 分别表示错误和异常
        Throwable指定代码中可用异常传播机制通过 Java应用程序传输的任何问题的共性

    Error(错误):
        表示运行应用程序中较严重的问题. 大多数错误与代码编写者执行的操作无关, 而代表代码运行时 JVM出现的问题, 如系统崩溃,
      虚拟机错误, 内存空间不足, 方法调用栈溢出等, 如 StackOverFlowError和 OutOfMemoryError, 对于这类错误, Java编译器
      不去检查它们.
        对于这类错误导致的应用程序中断, 仅靠程序本身无法恢复和预防, 遇到这样的错误, 建议让程序终止

    Exception:
        Exception类表示程序可以处理的异常, 可以捕获可能恢复. 遇到这类异常, 应该尽可能处理异常, 使程序恢复运行, 而不应该随意
      终止异常.
        其中, Exception又分 运行时异常(un-checked exception)和 受检异常 (checked exception)


4. Java中运行时异常(runtime exception) 和 受检异常(checked exception)是什么, 有什么区别 ?

    运行时异常 (RuntimeException)
        这个是程序设计的逻辑逻辑存在问题, 说白了就是你的问题, 优秀的程序员通常比较少犯这种问题, 新手就不好说了.
      下面列举的常见的 RuntimeException尽量不要使用捕获该异常来解决, 应该从程序设计的角度来避免该异常的出现, 比如调用一个
      可能会出现以下异常的方法时, 最好是提前做检查再调用方法

      NullPointException: 空指针异常, 这是由于一个变量在没有实例化之前就调用引起的
      ClassCastException: 类型强制转换异常
      IllegalArgumentException: 不合法参数异常
      ArithmeticException: 算数运行异常 (比如除零)
      ArrayStoreException: 数组中添加非法对象类型异常
      ArrayIndexOutOfBoundsException: 数据交表越界异常
      NegativeArraySizeException: 尝试创建长度为负数的数组时会报这个异常
      NumberFormatException: 数字格式化异常, 通常在 String -> int转换时不能转换报此异常

    受检异常 (checked exception, 非运行时异常)
        受检异常是除运行时异常之外的异常, 从程序语法角度讲是必须进行处理的异常, 如果不处理, 程序就不能编译通过, 如: IOException,
      SQLException等以及用户自定义的 Exception异常, 一般情况下不会自定义受检异常.


5. Java异常处理的一些注意点

    1) 对可恢复的情况使用受检异常, 对编程错误使用运行时异常
        在决定使用受检的异常或是未受检的异常时, 主要的原则是: 如果期望调用者能够适当地恢复, 对于这种情况应该使用受检的异常. 通过
      抛出受检的异常, 强迫调用者在一个 try catch语句中处理该异常或者将它传播出去



参考文章:
1. Java异常体系简析 [https://www.cnblogs.com/yiwangzhibujian/p/7141390.html]
2. Java异常体系结构 [https://blog.csdn.net/junlixxu/article/details/6096266]
3. Java----异常类（错误和异常，两者区别）[https://blog.csdn.net/ochangwen/article/details/52448553]
4. 个人对异常的简单理解 [https://www.cnblogs.com/zouheng/p/6706114.html]

*/
