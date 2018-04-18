package cn.com.dom4j.collections;

import java.util.ListIterator;

public interface MyList<AnyType> extends MyCollection<AnyType> {

    AnyType get(int idx);

    AnyType set(int idx, AnyType newVal);

    void add(int idx, AnyType x);

    void remove(int idx);

    ListIterator<AnyType> listIterator(int pos);







}
