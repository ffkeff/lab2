package me.ffkeff;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            var myList = new MyList<Integer>();
            for (int i = 0; i < 32000; i++)
                myList.pushBack(i);

            Integer x = myList.pop();
            System.out.println("list size:" + myList.getSize() + "deleted:" + x.toString());
            //System.in.read();
        }
        catch (MyListException ex){
            System.out.println(ex.getMessage());
        }
    }
}
