package me.code41.basic;

import java.util.*;

/**
 * Created by liushiyao on 2016/5/18.
 */
public class ListDemo {

    public static void arrayListIterator() {
        List<Integer> demoList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Iterator<Integer> iterator = demoList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("=======================");

//        ListIterator<Integer> listIterator = demoList.listIterator();
//        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next() + "---------" + listIterator.nextIndex());
//        }

        ListIterator<Integer> listIteratorDesc = demoList.listIterator(demoList.size());
        while (listIteratorDesc.hasPrevious()) {
            System.out.println(listIteratorDesc.previous() + "---------" + listIteratorDesc.previousIndex());
        }
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        System.out.println(linkedList.getFirst());
//        arrayListIterator();
    }
}
