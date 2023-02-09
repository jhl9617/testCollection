package test.list;


import java.io.Serializable;

//vo(value object) : 값 저장을 목적으로 하는 클래스
//==dto(data transfer object) : 값을 가진 객체가 여러 클래스를 이동하는 용도
//==entity == bean
//작성규칙 :
//1. 모든 필드는 private
//2. 매개변수 없는 기본 생성자와 매개변수 있는 생성자 있어야 함
//3. 모든 필드에 대한 getters and setters 반드시 있어야 함
//4. toString()  오버라이딩 작성할 것
//5. 직렬화 할 것
public class Book implements Serializable {
    private static final long serialVersionUID = 1;
    private String title;
    private int price;

    public Book() {
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
