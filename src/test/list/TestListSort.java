package test.list;

import test.list.Book;

import java.util.ArrayList;

public class TestListSort {
    public static void main(String[] args) {
        //java.util.ArrayList 의 sort() 사용 테스트
        ArrayList books = new ArrayList();
        books.add(new Book("책책", 40500));
        books.add(new Book("책2", 23400));
        books.add(new Book("책3", 44500));
        books.add(new Book("책1", 445003));
        System.out.println(books);

        System.out.println("도서제목 기준 오름차순 정렬");
        //복사본 리스트로 정렬 처리 :
        ArrayList copy = new ArrayList(books);
        books.sort(new BookTitleAsc());
        System.out.println(books);
        System.out.println(copy);

        System.out.println("도서 가격 기준 내림차순정렬 -----");
        copy.sort(new BookPriceDesc());
        System.out.println(books);
        System.out.println(copy);

    }
}
