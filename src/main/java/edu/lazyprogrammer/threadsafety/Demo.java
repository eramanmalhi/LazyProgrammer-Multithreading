package edu.lazyprogrammer.threadsafety;

public class Demo {
    public static void main(String[] args) {
        Book book=new Book("Lazy Programmer"
                , "Multithreading Journey");
        System.out.println(book);
        Book book2=book.bookWithNewAuthor("Aman");
        System.out.println(book2);
        Book book3=book.bookWithNewTitle("Executor Services");
        System.out.println(book3);
    }
}