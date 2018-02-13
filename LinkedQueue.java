// file: LinkedQueue.java
// author: Ziyuan Meng
// date: September 25, 2017
//
// A linked implement for a simple Queue ADT. See the file Queue.java
// for the API.
//
import java.util.*;
public class LinkedQueue implements Queue {

    // Instance variables
    //
    private Node front;
    private Node back;
    private int N;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.N = 0;
    }

    private static class Node {
        private String info;
        private Node next;

        private Node(String info) {
            this.info = info;
            this.next = null;
        }

    }

    public void enqueue(String info) {
        Node temp = new Node(info);
        if(this.isEmpty())
            this.front = temp;
        else
            this.back.next = temp;
        this.back = temp;
        this.N++;
    }

    public String dequeue() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        String frontValue = this.front.info;
        this.front = this.front.next;
        this.N--;
        if(this.isEmpty())
            this.back = null;
        return frontValue;
    }

    public boolean isEmpty() { return this.N == 0; }
    public int size()        { return this.N; }

    public Queue reverse()
    {
      Stack s = new LStack();
      Queue qs = new LinkedQueue();

      for (Node x = front; x != null; x = x.next ){
        s.push(x.info);
      }
      while(!s.isEmpty()){
        qs.enqueue(s.pop());
      }
      return qs;
    }

    public static void main(String[] args) {

        Queue qs = new LinkedQueue();
        qs.enqueue("Hello");
        qs.enqueue("World!");
        qs.enqueue("I'm");
        qs.enqueue("Matt");
        qs.enqueue("Kim");
        Queue ns = qs.reverse();
        System.out.println(ns.dequeue());
        System.out.println(ns.dequeue());
        System.out.println(ns.dequeue());
        System.out.println(ns.dequeue());
        System.out.println(ns.dequeue());




    }
  }
