package demo;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet books=new LinkedHashSet();
        books.add("java讲义");
        books.add("java疯狂");
        System.out.println(books);
        books.remove("java讲义");
        books.add("java讲义");
        System.out.println(books);

    }
}
