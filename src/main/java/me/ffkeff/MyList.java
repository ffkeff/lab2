package me.ffkeff;

public class MyList<T> {
    private Node<T> head;
    public Node<T> getHead(){
        return head;
    }
    private Node<T> tail;
    private int size;
    public int getSize(){
        return size;
    }

    public MyList(){
        size = 0;
        head = tail = null;
    }


    public void pushFront(T data){
        var tmp = new Node<>(head, data, null);
        if(head != null)
            head.prev = tmp;
        head = tmp;

        if(tail == null)
            tail = tmp;
        size++;
    }

    public void pushBack(T data){
        var tmp = new Node<>(null, data, tail);
        if(tail != null)
            tail.next = tmp;

        tail = tmp;
        if(head == null)
            head = tmp;

        size++;
    }
    public T pop(){
        if(head == null)
            System.out.println("error!");

        Node<T> prev = head;
        head = head.next;
        if(head != null)
            head.prev = null;
        T data = prev.data;
        prev = null;
        System.gc();
        size--;
        return data;
    }

    public T pop(int index){
        Node<T> tmp = getNth(index);


        Node<T> prev = tmp;
        tmp = tmp.next;
        if(tmp != null)
            tmp.prev = null;

        T data = prev.data;
        prev = null;
        System.gc();
        size--;
        return data;
    }

    public void clear(){
        Node<T> tmp = head;
        Node<T> next;
        while(tmp != null){
            next = tmp.next;
            tmp = null;
            System.gc();
            tmp = next;
        }
        size = 0;
    }

    public Node<T> getNth(int index){
        Node<T> tmp;
        int i;

        if(index < size / 2){
            i = 0;
            tmp = head;
            while (tmp != null && i < index){
                tmp = tmp.next;
                i++;
            }
        } else {
            i = size - 1;
            tmp = tail;
            while (tmp != null && i > index){
                tmp = tmp.prev;
                i--;
            }
        }

        return tmp;
    }
}
