package practice2;

public class AscCategory implements java.util.Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;
        if(o1 instanceof Book && o2 instanceof Book) {

            Book h1 = (Book) o1;
            Book h2 = (Book) o2;
            result = Integer.compare(h1.getCategory(), h2.getCategory());
        }
        return result;
    }


}
