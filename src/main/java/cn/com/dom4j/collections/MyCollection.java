package cn.com.dom4j.collections;

import java.util.Iterator;

public interface MyCollection<AnyType> extends Iterable<AnyType> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(AnyType x);

    boolean add(AnyType x);

    boolean remove(AnyType x);

    Iterator<AnyType> iterator();







}
