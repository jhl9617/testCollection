package practice3;

import practice2.AscCategory;
import practice2.Book;

import java.io.*;
import java.util.*;

public class BookManagerMap {

    private Scanner scanner = new Scanner(System.in);

    private HashMap booksMap = new HashMap();
    {
        booksMap.put("Bs123", new Book("Bs123", 4, "3스트레스 안 받기", "감감수"));
        booksMap.put("F23", new Book("F23", 8, "1스트레스 안 받기", "감감수"));
        booksMap.put("A1s123", new Book("A1s123", 5, "2스트레asd스 안 받기", "감asd감수"));
    }

//    private ArrayList<Book> bookList = new ArrayList<Book>();
//    {
//        bookList.add(new Book("Bs123", 4, "스트레스 안 받기", "감감수"));
//        bookList.add(new Book("F23", 8, "스트레스 안 받기", "감감수"));
//        bookList.add(new Book("A1s123", 5, "스트레asd스 안 받기", "감asd감수"));
//    }

    public BookManagerMap() {
    }

    public BookManagerMap(HashMap hashMap) {
        //shallow copy(얕은 복사) : 주소만 복사
//        this.bookList = bookList;




        //deep copy(깊은 복사) :내용을 복사한 새 객체 생성
//        this.bookList = new ArrayList<>(bookList);
        this.booksMap = new HashMap(hashMap);
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
//        bookList.add(new Book(bNo,category,title,author));
        booksMap.put(bNo, new Book(bNo, category, title, author));

    }

    public void deleteBook(String index) {
        try {
            if(booksMap.get(index) != null){
                booksMap.remove(index);
                System.out.println(index+"번 도서 데이터를 삭제 하셨습니다.");
            }
        }catch (Exception e){
            System.out.println("데이터가 존재하지 않습니다.");
        }

    }

    public int searchBook(String bTitle) {
        int result = -1;
//        ListIterator listIterator = bookList.listIterator();
        System.out.println("bTitle" + bTitle);
//        while(listIterator.hasNext()){
//
//            String tmp = ((Book)listIterator.next()).getTitle();
//            System.out.println("tmp : " + tmp);
//            if(tmp.equals(bTitle)){
//                System.out.println("같음");
//                result = index;
//                break;
//            }
//            index++;
//        }

        Set keys = booksMap.keySet();
        //키들에 대한 목록 만들기 : iterator()
        Iterator keyIter = keys.iterator();


        return result;


    }

    public void printBook(int index) {
        System.out.println(booksMap);
    }

    public void displayAll () {

        Iterator iter = booksMap.keySet().iterator();


//        Iterator iter = (Iterator) booksMap.clone();
        while (iter.hasNext()){
            System.out.println(booksMap.get(iter.next()));
        }

    }
    public Book[] sortedBookListMap() {
//

        List booksList = new ArrayList(booksMap.values());
        booksList.sort(new AcsBookTitle());
        Book[] books = new Book[booksMap.size()];
        booksList.toArray(books);



        return books;



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

        try (ObjectOutputStream bOut = new ObjectOutputStream(new FileOutputStream("bmap.dat"));) {
            Collection values = booksMap.values();  //Object로 value들 저장

            for(Object obj : values) {
                System.out.println("Object 하나씩 : " + obj);
                bOut.writeObject(obj);
            }
                System.out.println(" books.dat에 저장 완료");
        } catch (EOFException e){
            System.out.println("종료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileRead() {
        //books.dat 파일에서 읽어온 객체정보를 리스트에 추가

        try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream("bmap.dat"))) {
            while (true) {
                Object obj = oIn.readObject();
                System.out.println("Object 하나씩 : " + obj);
//                Book book = (Book) obj;           //형변환
//                booksMap.put(book.getbNo(), book);
                booksMap.put(((Book)obj).getbNo(), obj);    //한번에
            }

        } catch (EOFException e) {
            System.out.println("읽어오기 완료");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
