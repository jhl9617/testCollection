package test.generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric2 {
    public static void main(String[] args) {
        //클래스명<영문자>
        // : 클래스 사용시 제네릭 기능을 사용할 수 있다는 표시임
        //클래스명 또는 인터페이스명 옆에 표시된 것을 확인 할 수 있음
        //클래스 사용시 한가지 타입의 클래스 객체를 취급한다는 뜻임
        //제네릭 : 사용할 클래스 타입의 제한을 거는 설정임
        //주의 :
        //제네릭이 설정 된 레퍼런스를 주고받는 모든 메소드나 변수에 똑같은 제네릭이 계속 표기가 되어야 함

        List<String> list = listAllocation();
        listInitionalization(list);
        printList(list);
    }

    private static void printList(List<String> list) {  //<String>이 없으면 꺼낼때 Object  타입으로 꺼내짐
        //제네릭이 설정된 레퍼런스로 객체를 하나씩 추출할 때
        //Object 타입이 아니라 설정된 클래스타입으로 추출됨
        //즉, 클래스형변환 필요없게 됨
//        Object obj = list.get(0);     //제너릭 설정 없을 때 Object
        list.get(0);                    //제너릭 설정 있을 때 String

        for(String s  : list) {
            System.out.println(s);
        }
    }

    private static void listInitionalization(List<String> list) {
        //전달인자가 제네릭이 설정되어 있다면
        //매개변수도 같은 제네릭을 표시해야  함
        list.add("apple");
        //list.add(new Date());   //제네릭 타입이 아닌 객체는 저장(추가)할 수 없게 됨
        list.add(new String("orange"));
        list.add("grape");

    }

    private static ArrayList<String> listAllocation() {
        //제네릭이 설정된 레퍼런스를 리턴 할 경우
        //메소드의 반환자료형에도 같은 제네릭이 표기되어야 함
        return new ArrayList<String>();
    }
}
