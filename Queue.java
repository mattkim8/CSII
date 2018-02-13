// file: Queue.java
// author: Ziyuan Meng
// date: September 25, 2017
//
// An API for a simple first-in-first-out (FIFO) Queue ADT.
//
public interface Queue {
    public void enqueue(String info);
    public String dequeue();
    public boolean isEmpty();
    public int size();
    public Queue reverse();
}
