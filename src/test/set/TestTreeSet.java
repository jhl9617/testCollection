package test.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        //TreeSet 사용 테스트
        //자동 오름차순정렬 기능이 내장된 Set 계열 클래스임
        //주의 : 같은 타입의 객체들만 저장해야 함

        TreeSet treeSet = new TreeSet();

        treeSet.add("grape");
        treeSet.add("asfdafsd");
        treeSet.add("ghdhfhg");
        treeSet.add("banana");
        //treeSet.add(123); //저장 타입이 다르면 실행시 에러 발생함

        System.out.println(treeSet);
        System.out.println("오름차순정렬 목록 ------------");
        Iterator ascIter = treeSet.iterator();
        while (ascIter.hasNext()){
            System.out.println(ascIter.next());
        }

        System.out.println("내림차순정렬 목록 ------------");
        Iterator descIter = treeSet.descendingIterator();
        while (descIter.hasNext()){
            System.out.println(descIter.next());
        }
    }
}
