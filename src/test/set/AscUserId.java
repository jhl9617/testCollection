package test.set;

public class AscUserId implements java.util.Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;

        if(o1 instanceof User && o2 instanceof User){
            User u1 = (User) o1;
            User u2 = (User) o2;

            result = u1.getUserId().compareTo(u2.getUserId());
        }
        return result;


    }
}
