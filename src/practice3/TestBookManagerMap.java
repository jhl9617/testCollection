package practice3;

import practice2.Book;

import java.util.Scanner;

public class TestBookManagerMap {
    public static void main(String[] args) {
        BookManagerMap bookManager = new BookManagerMap();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\t*** 도서 관리 프로그램 ***\n" +
                    "\n" +
                    "\t1. 새 도서 추가\t//addBook(inputBook() 이 리턴한 객체) 실행\n" +
                    "\t2. 도서정보 정렬후 출력 //sortedBookList() 실행 \n" +
                    "\t\t\t=> Book[] 리턴받아 printBookList(Book[]) 실행\n" +
                    "\t3. 도서 삭제\t//deleteBook(삭제할 인덱스) 실행\n" +
                    "\t4. 도서 검색출력\t//searchBook(검색할 도서명) 실행 \n" +
                    "\t\t\t=> index 리턴받아 printBook(index) 실행\n" +
                    "\t5. 전체 출력\t//displayAll() 실행\n" +
                    "\t6. \t//파일에 저장\n" +
                    "\t7. 파일로부터 읽어와서 리스트에 저장\n" +
                    "\t9. 끝내기");
            int input = scanner.nextInt();

            switch (input){
                case 1:bookManager.addBook();break;
                case 2:{
                    Book[] books = bookManager.sortedBookListMap();
                    System.out.println("메인에서 다시");
                    bookManager.printBookList(books);
                    break;
                }
                case 3:{
                    System.out.println("삭제할 도서번호를 입력하시오 :");
                    String inp = scanner.next();
                    bookManager.deleteBook(inp);
                    break;
                }
                case 4:{
                    System.out.println("검색할 도서명을 입력하십시오 :");    //도서번호 리턴
                    String inp2 = scanner.next();
                    System.out.println("인덱스 번호 " + bookManager.searchBook(inp2));
                    bookManager.printBook(bookManager.searchBook(inp2));
                    break;
                }
                case 5: bookManager.displayAll();break;
                case 6: bookManager.fileSave();break;
                case 7: bookManager.fileRead(); break;
                case 9:
                    System.out.println("종료합니다.");return;
                default:
            }
        }
    }

}
