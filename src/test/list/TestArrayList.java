package test.list;

import test.set.AscUserId;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
        //ArrayList 사용 테스트

        //1. ArrayList 객체 생성
        ArrayList alist = new ArrayList();
        //List alist2 = new ArrayList();
        //Collections alist3 = new ArrayList();

        //2.객체 저장 처리 : add(저장객체)
        //저장 순서에 대한 순번(index)이 부여됨
        //여러 종류의 클래스 객체둘을 저장할 수 있음
        alist.add(new String("java"));
        alist.add("collection");    //auto boxing =>객체
        alist.add(Integer.valueOf(123));//boxing (값 => 객체)
        alist.add(45);  //auto boxing
        alist.add((Double.valueOf(78.34))); //boxing
        alist.add(45.6);    //auto boxing

        //List 계열은 저장 순서가 유지됨
        System.out.println("저장된 객체 수 : " + alist.size());
        System.out.println(alist);

        //저장순번(index)을 이용해서 하나씩 객체를 다룰 수 있음
        for(int i = 0; i < alist.size(); i++){
            System.out.println(i + "번 : " +alist.get(i));
        }

        //원하는 위치에 저장 할 수도 있음
        //add(위치순번, 저장객체), addAll(위치순번, 컬렉션)
        alist.add(2, "web front");
        System.out.println(alist);

        //원하는 위치의 객체를 변경 할 수도 있음
        //set(위치순번, 바꿀객체)
        alist.set(2, new HashSet());
        System.out.println(alist);

        //같은 객체가 중복 저장됨
        alist.add("java");
        System.out.println(alist);

        //저장되어 있는 객체의 위치(순번) 조회
        System.out.println("순번 : " + alist.indexOf("java"));
        System.out.println("순번 : " + alist.lastIndexOf("java"));

        //저장된 객체 제거
        //remove(index), remove(삭제할객체), removeAll(삭제할컬렉션)
        alist.remove(2);
        System.out.println(alist);

        alist.remove("java");
        System.out.println(alist);

        //List => Object[]로 변경
        Object[] array = alist.toArray();
        System.out.println("Object[] 연속 처리 -----------");
        for(Object obj : array) {
            System.out.println(obj);
        }

        //List => Iterator로 목록 만들기 해서 하나씩 처리
        Iterator iter = alist.iterator();
        System.out.println("Iterator로 연속 처리 ---------");

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //List => ListIterator 로 목록 만들기 해서 하나씩 처리
        ListIterator listiter = alist.listIterator();
        while(listiter.hasNext()){
            listiter.next();
        }   //래퍼런스를 목록의 맨 마지막으로 이동만 시킴

        if(listiter.hasNext() == false) {
            //목록의 마지막 항목이 없다면 (즉, 목록의 끝이면)
            System.out.println("ListIter previous -----");
            while (listiter.hasPrevious()) {
                //위쪽 항목이 있다면, 밑에서 위로 검색 처리

                System.out.println(listiter.previous());
            }
        }
    }
}
