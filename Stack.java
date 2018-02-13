// file: Stack.java
// author: Bob Muller
// date: January 27, 2014
//
// This file contains an API for a generic (or polymorphic) stack.
//
public interface Stack {
    public void push(String info);
    public String pop();
    public boolean isEmpty();
    public int size();
}
