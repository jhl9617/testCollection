package practice2;

import java.io.*;
import java.util.*;

public class BookManager {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> bookList = new ArrayList<Book>();
    {
        bookList.add(new Book("Bs123", 4, "스트레스 안 받기", "감감수"));
        bookList.add(new Book("F23", 8, "스트레스 안 받기", "감감수"));
        bookList.add(new Book("A1s123", 5, "스트레asd스 안 받기", "감asd감수"));
    }

    public BookManager() {
    }

    public BookManager(ArrayList<Book> bookList) {
        //shallow copy(얕은 복사) : 주소만 복사
        this.bookList = bookList;

        //deep copy(깊은 복사) :내용을 복사한 새 객체 생성
        this.bookList = new ArrayList<>(bookList);
    }

    public void addBook() {
        System.out.print("도서번호 :");
        String bNo = scanner.next();
        System.out.print("도서분류코드(1.인문/2.자연과학/3.의료/4.기타) :");
        int category = scanner.nextInt();
        System.out.print("도서제목 :");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.print("저자 :");
        String author = scanner.next();
        bookList.add(new Book(bNo,category,title,author));
    }

    public void deleteBook(int index) {
        try {
            if(bookList.get(index) != null){
                bookList.remove(index);
                System.out.println(index+"번 인덱스 데이터를 삭제 하셨습니다.");
            }
        }catch (Exception e){
            System.out.println("데이터가 존재하지 않습니다.");
        }

    }

    public int searchBook(String bTitle) {
        int result = -1;
        int index = 0;
        ListIterator listIterator = bookList.listIterator();
        System.out.println("bTitle" + bTitle);
        while(listIterator.hasNext()){

            String tmp = ((Book)listIterator.next()).getTitle();
            System.out.println("tmp : " + tmp);
            if(tmp.equals(bTitle)){
                System.out.println("같음");
                result = index;
                break;
            }
            index++;
        }
        return result;


    }

    public void printBook(int index) {
        System.out.println(bookList.get(index));
    }

    public void displayAll () {
        Iterator iter = bookList.listIterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
    public Book[] sortedBookList() {
//        ArrayList<Book> bookList2 = (ArrayList<Book>) bookList.clone();
//        bookList2.sort(new AscCategory());
//        Book[] books = new Book[bookList2.size()];
//        bookList2.toArray(books);
//        return books;
        bookList.sort(new AscCategory());
        return (Book[]) bookList.toArray();


    }
    public void printBookList(Book[] br) {
        for(Book book : br){
            System.out.println(book);
        }
//        Iterator iter = Arrays.stream(br).iterator();
//        while (iter.hasNext()){
//            iter.next();
//        }
    }

    public void fileSave() {
        //books.dat 파일에 리스트의 도서객체가 출력 저장
        try (ObjectOutputStream bOut = new ObjectOutputStream(new FileOutputStream("books.dat"));){
            for(Book book : bookList){
                bOut.writeObject(book);
            }
            System.out.println(" books.dat에 저장 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileRead() {
        //books.dat 파일에서 읽어온 객체정보를 리스트에 추가

        try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream("books.dat"))){
            for(Object obj : )


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
