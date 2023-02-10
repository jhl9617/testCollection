package test.generic;

import test.list.Book;

public class TestMyGeneric {
    public static void main(String[] args) {
        //MyGeneric<T> 사용 테스트
        MyGeneric<String> my1 = new MyGeneric<String>(5);

        try {
            my1.add("java");
            my1.add("oracle");
            my1.add("jdbc");

            for(int i = 0; i < my1.getCount(); i++){
                System.out.println(my1.get(i));
            }
        }catch (SizeOverflowException e) {
            System.out.println(e.getMessage());
        }


        MyGeneric<Book> my2 = new MyGeneric<Book>(10);

        try {
            my2.add(new Book("html 완성 ", 24000));
            my2.add(new Book("css 완성 ", 27000));
            my2.add(new Book("javascript 완성 ", 35000));
            my2.add(new Book("ajax 완성 ", 20000));
            my2.add(new Book("servlet 완성 ", 37000));

            for(int i = 0; i < my2.getCount(); i++){
                System.out.println(my2.get(i));
            }

        }catch (SizeOverflowException e){
            System.out.println(e.getMessage());

        }
    }
}
