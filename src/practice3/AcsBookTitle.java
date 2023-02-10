package practice3;

import practice2.Book;

public class AcsBookTitle implements java.util.Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;
        if(o1 instanceof Book && o2 instanceof Book) {

            Book h1 = (Book) o1;
            Book h2 = (Book) o2;
            return h1.getTitle().compareTo(h2.getTitle());
        }
        return result;
    }


}
