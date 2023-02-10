package test.properties;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class TestProperties2 {
    public static void main(String[] args) {
        //Properties 저장한 파일 읽어와서 출력처리
        Properties prop1 = new Properties();
        Properties prop2 = new Properties();
        Properties prop3 = new Properties();

        try {
            prop1.load(new FileInputStream("jdbc.dat"));
            prop2.load(new FileReader("jdbc.txt"));
            prop3.loadFromXML(new FileInputStream("jdbc.xml"));

            prop1.list(System.out);
            prop2.list(System.out);
            prop3.list(System.out);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
