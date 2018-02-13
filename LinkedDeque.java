public class LinkedDeque<T> implements Deque<T> {

    private int N;
    private Node right;
    private Node left;

    public LinkedDeque(){
      this.right = null;
      this.left = null;
      this.N = 0;
    }


    private class Node{
      private Node prev;
      private Node next;
      private T info;

      private Node(T info){
        this.next = null;
        this.prev = null;
        this.info = info;
    }
    private T getInfo()    { return this.info; }
    private Node getNext() { return this.next; }
    private Node getPrev() {return this.prev;}

    }
    public boolean isEmpty() { return this.N == 0; }

    public void pushRight(T item){
      Node temp = new Node(item);

      if (this.right != null){
        temp.next = this.right;
        this.right.prev = temp;
      }
      this.right = temp;
      if (this.left == null){
        this.left = temp;
        this.right = this.left;
      }
      this.N ++;
    }
    public T popRight(){
      if (this.isEmpty())
          throw new java.util.NoSuchElementException("Queue is empty.");
      T frontValue = this.right.getInfo();
      if (this.right == null){
          this.left = null;
      }
      else{
        this.right = this.right.next;
        this.right.prev = null;
      }
      this.N --;
      return frontValue;
    }

    public void pushLeft(T item){
      Node temp = new Node(item);
      if(this.left != null){
        temp.prev = this.left;
        this.left.next = temp;
      }
      this.left = temp;
      if(this.left == null){
        this.right = temp;
        this.left = this.right;
      }
      this.N++;
    }
    public T popLeft(){
      if(this.isEmpty())
        throw new java.util.NoSuchElementException("Queue is empty.");
      T value = this.left.getInfo();
      if (this.left == null){
        this.right  = null;
      }
      else{
        this.left = this.left.prev;
        this.left.prev = null;
      }
      this.N --;
      return value;
    }
    public int size(){
      return this.N;
    }
    public String toString(){
      String str = "";
      if (this.isEmpty())
        throw new java.util.NoSuchElementException("Queue is empty.");
      else{
        for(Node x = left; x != null; x = x.prev){
          str = str + x.getInfo().toString();
      }
      }
      return str;

    }
    public static void main(String[] args){
      LinkedDeque qs = new LinkedDeque();
      qs.pushRight(5);
      qs.pushLeft(4);
      qs.pushRight("hello");
      System.out.println(qs.popRight());
      System.out.println(qs.popLeft());
      System.out.println(qs.toString());
      System.out.println(qs.popRight());
      System.out.println(qs.toString());
      System.out.println(qs.size());
    }

    }
