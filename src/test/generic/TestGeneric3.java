package test.generic;

import practice2.Book;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestGeneric3 {
    public static void main(String[] args) {
        //Map에 generic 사용 테스트
        //Map<K, V> :
        // K : 키에 대한 클래스타입 지정
        // V : 값에 대한 클래스타입 지정

        Map<String, Book> map;

        //HashMap 객체 생성해서 리턴 받음
        map = mapAllocation();

        //할당된 맵에 객체들 저장 처리
        putMaps(map);

        //저장된 맵 안의 객체들 출력 처리
        getMaps(map);

    }

    private static void getMaps(Map<String, Book> map) {
        //1. keySet()
        Set<String> keys = map.keySet();
        Iterator<String> keyIter = keys.iterator();
        while (keyIter.hasNext()){
            String key = keyIter.next();
            Book book = map.get(key);
            System.out.println(key + "=" + book);
        }



        System.out.println("values()---------------");
        //2. values()
        Collection<Book> books = map.values();
        Iterator<Book> bookIter = books.iterator();
        while (bookIter.hasNext()){
            Book book = bookIter.next();
            System.out.println(book);
        }


        //3. entrySet()
        System.out.println("entrySet() ------------");
        Set<Map.Entry<String, Book>> entries = map.entrySet();
        Iterator<Map.Entry<String, Book>> entryiter = entries.iterator();
        while (entryiter.hasNext()) {
            Map.Entry<String, Book> entry = entryiter.next();
            String key = entry.getKey();
            Book book = entry.getValue();
            System.out.println(key + " : " + book);
        }



    }

    private static void putMaps(Map<String, Book> map) {

        //전달된 맵에 객체 저장 처리
        map.put("A1234T", new Book("A1234T", 1, "자바 정복", "김철수"));
        map.put("C1234T", new Book("C1234T", 3, "복자바 정", "수김철"));
        map.put("B1234T", new Book("B1234T", 2, "자복바 정", "김수철"));
        //제네릭 지정 타입이 아는 경우 에러
        //map.put(123, new Book());     //error
        //map.put("222", new Date());   //error
    }


    private static Map<String, Book> mapAllocation() {
        //HashMap 생성해서 리턴


        return null;
//        return new Hashmap<String, Book>();
    }
}
