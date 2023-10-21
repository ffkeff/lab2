package me.ffkeff;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var myList = new MyList<Integer>();
        for(int i = 0; i < 32000; i++){
            myList.pushBack(i);
        }
        System.out.println(myList.getSize());
        int tmp = myList.getNth(2304).data;
        System.out.println(tmp);
        System.in.read();
    }
}
