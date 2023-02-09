package test.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        //set 계열의 HashSet 클래스 사용 테스트

        //1. 객체 생성
        HashSet hashSet = new HashSet();
        //Set hashSet1 = new HashSet();
        //Collections hashSet2 = HashSet();
        //기본객체 16개 저장, 확장률 0.75로 객체 생성됨

        System.out.println("hashset : " + hashSet.isEmpty());

        //2.저장 처리 :객체만 저장할 수 있음
        //add(저장할 객체) 사용
        hashSet.add(new String("apple"));
        hashSet.add("apple");   //중복 허용 안 함, 1개만 저장됨
        hashSet.add(Integer.valueOf(120));
        hashSet.add(121);   //auto boxing
        hashSet.add(Double.valueOf(32.5));
        hashSet.add(new User("u1234", "p1234", "홍길동"));

        //저장된 객체 정보 확인 : toString()
//        System.out.println(hashSet);
//        //저장 순서가 없다.
//        System.out.println("저장된 객체 수 : " + hashSet.size());
//
//        //제거 : remove()
//        hashSet.remove("apple");
//        System.out.println(hashSet);
//        //저장 순서가 없다.
//        System.out.println("저장된 객체 수 : " + hashSet.size());
//
//        //검색 : contains()
//        System.out.println(hashSet.contains(120));
//
//        //set 저장공간을 비움 : clear()
//        //빈 set 인지 확인 : isEmpty()
//        hashSet.clear();
//        System.out.println(hashSet);
//        //저장 순서가 없다.
//        System.out.println("저장된 객체 수 : " + hashSet.size());

        //set 계열은 저장되 객체를 하나씩 꺼내는 기능이 없음
        //해결방법 1:
        Object[] array = hashSet.toArray();
        System.out.println("객체배열로 바꾸어서 하나씩 꺼내기");
        for(Object objects : array){
            System.out.println(objects);
        }


        //해결방법 2:
        //저장된 객체 목록을 만들어서 목록을 이용 - iterator() 사용
        Iterator iter = hashSet.iterator();
        System.out.println("목록을 만들어서 하나씩 꺼내기");
        while (iter.hasNext()) {
            Object obj = iter.next();
            System.out.println(obj);
        }

    }
}

class User {
    private String userId;
    private String userPwd;
    private String userName;

    public User() {
    }


    public User(String userId, String userPwd, String userName) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}


