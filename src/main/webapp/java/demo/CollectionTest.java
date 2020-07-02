package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("java讲义1");
        books.add("java讲义2");
        books.add("java讲义3");
        books.add("java讲义4");
        books.add("java讲义5");
        books.add("java讲义6");
        books.add("java讲义7");

        //遍历集合元素
        Iterator it=books.iterator();
        while(it.hasNext()){
            String book=(String)it.next();
            System.out.println(book);
            if(book.equals("java讲义7")){
                it.remove();
            }
        }

    }
}
