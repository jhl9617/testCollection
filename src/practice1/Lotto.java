package practice1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    public static void main(String[] args) {

        lottoDisplay();

    }

    public static void lottoDisplay(){
        TreeSet treeSet = new TreeSet();

        while (treeSet.size() < 7) treeSet.add((int)(Math.random()*45) +1);
        System.out.println(treeSet);

        int[] lottoNUmbers = new int[treeSet.size()];
        Iterator iter = treeSet.iterator();
        int i = 0;
        while (iter.hasNext()) {
            lottoNUmbers[i++] = (Integer)iter.next();
            //auto unboxing 됨 : 객체 --> 값
        }

        System.out.println("이번 주 로또 예상번호 : ");
        for(i =0; i < lottoNUmbers.length;i++) {
            System.out.println(lottoNUmbers[i]);
        }
    }
}
