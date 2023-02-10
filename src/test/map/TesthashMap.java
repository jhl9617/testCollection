package test.map;

import com.sun.source.tree.Tree;

import java.util.*;

public class TesthashMap {
    public static void main(String[] args) {
        //HashMap 사용 테스트

        //1.객체 생성
        HashMap hmap = new HashMap();
        //Map hmp = new HashMap();

        //2.객체를 저장 : put(key, value)
        //키 객체와 값 객체를 쌍으로 저장함
        hmap.put(new String("one"), Integer.valueOf(12345));
        hmap.put(2, "java");
        System.out.println(hmap);
        //저장 순서가 유지 안 됨 : 키가 Set 구조임

        //key : set 구조, value : List 구조
        //키는 중복 저장 안 됨, 값 객체는 중복 허용
        hmap.put(2, "jasdasd");
        System.out.println(hmap);
        //키가 중복되면, 매핑하는 값 객체를 바꿈
        //맵에서는 키의 중복 저장은 값 객체의 변경을 의미함(replace)
        //HashMap의 replace(k, old v, new v)와 같음

        //값 객체는 중복 저장 확인
        hmap.put("two", 12345);
        System.out.println(hmap);

        //맵에 저장된 객체 하나 조회시 : get(key) :
        Object valueObj = hmap.get("one");
        System.out.println(valueObj);

        //맵에 저장된 엔트리(키와 값 한 쌍)들을 연속으로 처리할 경우
        //기본 제공되는 기능이 없음

        //해결방법 1 :
        // 저장된 키들을 Set으로 바꿈 => keySet() 사용
        System.out.println("keySet() 이용 연속 처리 ---------");
        Set keys = hmap.keySet();
        //키들에 대한 목록 만들기 : iterator()
        Iterator keyIter = keys.iterator();
        while (keyIter.hasNext()) {
            Object key = keyIter.next();
            Object vObj = hmap.get(key);
            System.out.println(key + "\t=\t" + vObj);
        }
        //해결방법 2 :
        //값 객체들만 values() 사용 => Collection 으로 바꿈
        Collection values = hmap.values();

        //2-1. toArray() 사용 => Object[] 바꿔서 연속 처리
        System.out.println("Object[] -----------------");
        Object[] varray = values.toArray();
        for(Object obj : varray) {
            System.out.println(obj);
        }

        //2-2. iterator() 사용 => 값 객체 목록을 만들어서 연속 처리
        System.out.println("values iterator ----------");
        Iterator valueIter = values.iterator();
        while (valueIter.hasNext()) {
            Object vobj = valueIter.next();
            System.out.println(vobj);
        }


        //해결방법 3:
        //키와 값 한 쌍(엔트리, Entry)을 Set으로 바꿈 : entrySet()
        //iterator()로 엔트리 목록을 만듦 > 연속처리
        //Map 인터페이스의 내부 인터페이스로 제공되고 있음
        //외부클래스명.내부클래스명으로 표기함
        //Map.Entry 로 표기함
        Set entries = hmap.entrySet();
        Iterator entryIter = entries.iterator();    //엔트리 목록
        System.out.println("Map.Entry -----------------");
        while (entryIter.hasNext()){
            Object entryObj = entryIter.next();
            Map.Entry entry = (Map.Entry)entryObj;  //(Map.Entry)를 하나의 자료형 처럼 사용
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "\t=\t" + value);
        }

        //Treemap 사용 :
        //키에 대한 오름차순 정렬 처리를 자동으로 해 주는 클래스임
        //주의 : 키의 자료형이 같아야 함
        hmap.remove(2); //숫자 2의 키를 가진 엔트리 삭제함
        hmap.put("three", "정렬 테스트");
        hmap.put("four", "Treemap 이용");
        hmap.put("five", "정렬");
        System.out.println(hmap);

        TreeMap tmap = new TreeMap(hmap);
        System.out.println(tmap);

        //키에 대한 내림차순 정렬 처리
        Map descMap = tmap.descendingMap();
        System.out.println(descMap);




    }
}