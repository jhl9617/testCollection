package test.generic;


import practice2.Book;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestGeneric1 {
    public static void main(String[] args) {
        //컬렉션들은 여러 종류의 객체들을 저장할 수 있다.
        //저장용량에 제한이 없다. (컬렉션 사용 이유)
        List alist = new ArrayList();

        alist.add(new String("java"));
        alist.add(new Book());
        alist.add(new Date());

        //저장 후 하나씩 꺼내서 사용하려고 할 때
        //기본 Object 타입으로 추출됨
        for(Object obj : alist){
            //Object 클래스가 가진 메소드를 후손들이
            //ToString(), equals(), clone(), hashCode()
            //오버라이딩한 경우라면,
            //메소드 사용시 자동 동적바인딩이 되어서
            //후손의 오버라이딩된 메소드가 실행됨

            System.out.println(obj.toString());

            //만약, 각 후손클래스가 가진 메소드를 실행시키려면
            //(Object 것이 아닌 후손 것 )
            //해당 후손클래스 타입으로 다운캐스팅(형변환) 해야 함
            //주의 :
            //다른 클래스타입으로 형변환하면 에러 발생하므로
            // => ClassCastException
            //레퍼런스가 참조하는 인스턴스(객체)의 타입을
            //확인한 다음에 형 변환 하도록 해야 함
            if(obj instanceof String) {
                String s = (String)obj;
                System.out.println(s.toUpperCase());
            }
            if(obj instanceof Book) {
                Book book = (Book) obj;
                System.out.println(book.getCategory());
            }
            if(obj instanceof Date) {
                Date date = (Date)obj;
                System.out.println(new SimpleDateFormat("yyyy'년 'MM'월 'dd'일 ' E").format(date));
            }


        }

    }
}
