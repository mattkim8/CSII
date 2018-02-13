// file: LStack.java
// Created by Ziyuan meng on September 25, 2017
//
// This file contains a linked implementation of String stacks
//
// run this program by:
//
// > javac LStack.java
// > java LStack
//
import java.util.*;
public class LStack implements Stack {

    // Instance vars.
    //
    private Node top;
    private int N;

    // This inner class is defined recursively. It implements a
    // chain of Nodes each containing a stack value of type T.
    //
    private static class Node {
        private String info;
        private Node next;

        private Node(String info, Node next) {
            this.info = info;
            this.next = next;
        }

    }

    // A constructor of LStacks.
    //
    public LStack() {
        this.top = null;
        this.N = 0;
    }

    // No possibility of overflow, the runtime system can give
    // us a virtually unlimited sequence of new Nodes.
    //
    public void push(String info) {
        this.top = new Node(info, this.top);
        this.N++;
    }

    public boolean isEmpty() { return this.N == 0; }

    public int size() { return this.N; }

    public String pop() {
        if (this.isEmpty())
            throw new NoSuchElementException("Stack Underflow");
        else {
            String info = this.top.info;
            this.top = this.top.next;
            this.N--;
            return info;
        }
    }


    public static void main(String[] args) {
        Stack myStack = new LStack();

        myStack.push("I");
        myStack.push("admire");
        myStack.push("Kant");


        while(!myStack.isEmpty())
            System.out.println(myStack.pop());

    }
}
