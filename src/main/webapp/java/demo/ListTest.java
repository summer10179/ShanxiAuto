package demo;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List books=new ArrayList();
        books.add("java");
        books.add(new String("java1"));
        books.add(new String("java2"));
        System.out.println(books);
        books.add(2,"java哈哈哈");
        System.out.println(books);
        for(int i=0;i<=books.size();i++){
            System.out.println(books.get(i));
        }
        books.remove(3);
        System.out.println(books);
    }
}
