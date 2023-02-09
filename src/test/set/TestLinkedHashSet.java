package test.set;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        //LinkedHashSet 사용 테스트
        //HashSet 후손(subClass)
        //저장순서가 유지되게 보완됨
        LinkedHashSet set = new LinkedHashSet();

        set.add(new User("user001", "pass001", "장길치"));
        set.add("java");
        set.add(123);

        //System.out.println(set);

        //iterator()로 목록 만들어서 하나씩 꺼내기
        Iterator  iter = set.iterator();
        while(iter.hasNext()){
            Object obj = iter.next();
            System.out.println(obj);
        }

    }
}
