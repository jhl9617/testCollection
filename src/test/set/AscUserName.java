package test.set;

//정렬 기준 지정하는 용도의 클래스임
//User 클래스의 userName 필드값을 기준으로 오름차순 정렬을 지정함

public class AscUserName implements java.util.Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;

        if(o1 instanceof User && o2 instanceof User){
            User u1 = (User) o1;
            User u2 = (User) o2;
            //객체가 가진 정렬 기준으로 지정할 필드에 대한 비교연산한 결과를 리턴 처리하면 됨

            result = u1.getUserName().compareTo(u2.getUserName());
        }

        return result;
    }
}
