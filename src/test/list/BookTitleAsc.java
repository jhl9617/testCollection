package test.list;

import java.util.Comparator;


//도서제목 기준 오름차순 정렬 설정용 클래스
public class BookTitleAsc implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        //test.list.Book 의 필드 중 정렬기준에 대한 필드 지정
        //오름 | 내림차순 설정 명시해야 함
        int result = 0;

        if(o1 instanceof Book && o2 instanceof Book) {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;

            //result = b1.getPrice() - b2.getPrice();

            result = b1.getTitle().compareTo(b2.getTitle());
        }

        //return -result;   //내림차순
        return result;      //오름차순


    }
}
