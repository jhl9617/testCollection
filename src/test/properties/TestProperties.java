package test.properties;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        //java.util.Properties 클래스
        //java.util.hashTable 후손클래스임 (Map 계열)
        //제네릭이 없는 클래스임 => 키와 값 둘 다 String으로 정해놓았음
        //주로 어플리케이션의 환경설정 값 저장용으로 사용됨

        Properties prop = new Properties();
        prop.setProperty("driver", "oracle.jdbc.driver.OracleDrive");
        prop.setProperty("url", "jdbc.oracle.thin:@127.0.0.1:1521:xe");
        prop.setProperty("user", "c##student");
        prop.setProperty("password", "student");

        System.out.println(prop);
        prop.list(System.out);

        String driver = prop.getProperty("driver");
        System.out.println(driver);


        try {
            prop.store(new FileOutputStream("jdbc.dat"), "java and oracle connection setting");
            prop.store(new FileWriter("jdbc.txt"), "java and oracle connection setting");
            prop.storeToXML(new FileOutputStream("jdbc.xml"), driver);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
