package test.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TestUserTreeSet2 {

    public static void main(String[] args) {
        //test.set.User 클래스의 객체들을 TreeSet에 저장
        //저장시 객체 안에 user Name 필드를 기준으로 오름차순 정렬 되게 처리
        //먼저, java.util.Comparator 를 상속 받은 클래스 준비함

        //1. TreeSet 객체 생성
        TreeSet users = new TreeSet(new AscUserId());

        //2. User 객체 저장
        users.add(new User("u123", "p123", "홍철수"));
        users.add(new User("u234", "p234", "김춘수"));
        users.add(new User("u345", "p456", "이순신"));

        //3.출력확인
        System.out.println(users);


        //4. 이름 기준 오름차순 정렬된 결과를 목록화해서 하나씩 처리
        System.out.println("users username asc ----------");
        for(Object treeSet : users){
            System.out.println(treeSet);
        }

        Iterator userIter = users.iterator();
        while (userIter.hasNext()){
            System.out.println(userIter.next());
        }

        //5. 이름 기준 내림차순 정렬된 목록을 이용 하나씩 처리
        System.out.println("users username desc ----------");

        Iterator userIter2 = users.descendingIterator();
        while (userIter2.hasNext()){
            System.out.println(userIter2.next());
        }



    }


}
