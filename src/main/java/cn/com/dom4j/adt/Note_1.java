package cn.com.dom4j.adt;

import cn.com.dom4j.array.Person;

import java.util.Arrays;

public class Note_1 {


    public static void main(String[] args) {


        Person[] people = new Person[10];

        people[0] = new Person("张三");
        people[1] = new Person("李四");


        Object[] objects = new Object[3];
        objects[0] = new Person();
        objects[1] = "555";
        objects[2] = 10;

        System.out.println(Arrays.toString(objects));

        objects = Arrays.copyOf(objects, 20);

        System.out.println(Arrays.toString(objects));


        System.out.println(Arrays.toString(people));



    }

}


/*



Java集合类



数组: 可以用来存储基本数据类型和对象, 长度不可变
集合: 只能存储对象, 长度可变




----------------------------------------------------

Collection
	|-- List
	|-- Set


Map
	|--


Iterator
	所有的集合类都实现了这个接口, 这是一个用于遍历集合中元素的接口, 主要包含以下三个方法:
	hasNext(), next(), remove()



---------------------------------------------------

几种重要的类和接口介绍

1. List (有序, 可重复)


2. Set (无序, 不能重复)
    |-- AbstractSet
    |-- HashSet
    |-- TreeSet  有序 (用二叉排序树)


3. Map (键值对, 键唯一, 值不唯一)
    |-- AbstractMap
    |-- HashMap
    |-- TreeMap (有序, 用二叉排序树)
    |-- HashTable
    |-- LinkedHashMap


----------------------------------------------------

遍历

Iterator
ListIterator
forEach
for

------------------------------------------------------

ArrayList 和 LinkedList
1. ArrayList实现了基于动态数组的数据结构, LinkedList基于链表的数据结构
2. 对于随机访问的 get和 set, ArrayList优于 LinkedList, 因为 LinkedList要移动指针


ArrayList与 Vector
1. Vector是线程同步的, 所以它也是线程安全的. ArrayList是线程异步的, 是不安全的. 如果不考虑线程的安全因素, 一般用ArrayList
   效率比较高
2. 如果集合中的元素数目大于目前集合数组的长度时, Vector增长率为目前数组长度的 100% (可以自定义)
   ArrayList增长率为目前数组长度的 50%, 如果在集合中使用数据量比较大的数据时, Vector有一定优势
3. ArrayList和 Vector是采用数组方式存储数据, 此数组元素个数大于实际存储的数据以便于增加和插入元素, 都允许序号直接索引元素
   但是插入数据要涉及到数组元素移动内存操作, 所以索引数据快, 插入数据慢, Vector由于使用了 synchronized方法, 所以性能上
   要比 ArrayList差


HashMap与 TreeMap
1. HashMap通过 hashCode对其内容进行快速查找, 而 TreeMap中所有的元素都保持着某种固定的顺序, 如果你需要得到一个有序的结果,
   你就应该使用 TreeMap
2. 在 Map中插入, 删除和定位元素, HashMap是最好的选择. 如果你要按照自然顺序或自定义顺序遍历键, 那么 TreeMap会更好,
   使用 HashMap要求添加的键类明确定义了 HashCode和 equals()的实现

HashTable和 HashMap
1. 同步性
2. 是否允许空键空值





Map 集合

HashMap
    HashMap 是最常用的 map, 它根据键的 hashCode值存储数据, 根据键可以直接获取它的值, 具有很快的访问速度, 遍历时, 取得
  数据的顺序是完全随机的. 因为键对象不可以重复, 所以 HashMap最多允许一条记录的键为 null, 允许多条记录的值为 null,是非同步的

HashTable
    HashTable与 HashMap类似, 是HashMap的线程安全版, 它支持线程的同步, 即在任一时刻只有一个线程能写 HashTable,
  因此也导致了 HashTable在写入时会比较慢, 它继承自 Dictionary, 不同的是它不允许记录的键或者值为 null, 同时效率较低

ConcurrentHashMap
    线程安全, 并且锁分离. ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分, 每个段其实就是一个小的 HashTable,
  他们有自己的锁, 只要多个修改操作发生在不同的段上, 它们就可以并发进行

LinkedHashMap
    LinkedHashMap保存了记录的插入顺序, 在用 Iterator遍历 LinkedHashMap时, 先得到的记录肯定是先插入的, 在遍历的时候会比
  HashMap慢, 有 HashMap的全部特性

TreeMap
    TreeMap实现了 SortedMap接口, 能够把它保存的记录根据键排序, 默认是按照键的升序排序(自然顺序), 也可以指定排序的比较器,
  当用 Iterator遍历 TreeMap时, 得到的记录是排过序的, 不允许 key值为空, 非同步的





----------------------------------------------------

集合类相关 Java面试题

1. Java集合框架是什么? 说出一些集合框架的优点.

优点:
  1) 使用核心集合类降低开发成本, 而非实现我们自己的集合类
  2) 降低代码维护成本
  3) 复用性和可操作性

2. 集合框架中的泛型有什么优点 ?

3. Java集合框架的基础接口









-------------------------------------------

毕业论文初稿


目录










 */
