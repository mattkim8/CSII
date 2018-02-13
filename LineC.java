public class LineC implements Line{

  private Point left;
  private Point right;

  public LineC(Point left, Point right){
    this.left = left;
    this.right = right;
  }
  public Point getLeft(){
    if (left.getX() < right.getX()){
      return this.left;
    }
    else{
      return this.right;
    }
  }
  public Point getRight(){
    if (right.getX() > left.getX()){
      return this.right;
    }
    else{
      return this.left;
    }
  }
  public double length(){
    double len = Math.pow((left.getX())-(right.getX()),2.0)+Math.pow((left.getY())-(right.getY()),2);
    return Math.sqrt(len);
  }
  public Point midPoint(){
    double lefty;
    double righty;
    lefty = ((left.getX())+(right.getX()))/2;
    righty = ((left.getY())+(right.getY()))/2;
    return new PointC(lefty,righty);
  }
  public Line move(double dx, double dy){
    return new LineC(this.left.move(dx,dy), this.right.move(dx,dy));
  }
  public String toString() {
      return "(" + this.left.toString() + ", " + this.right.toString() + ")";
  }
  public boolean equals(Line other){
      return other.getLeft().equals(this.getLeft()) && other.getRight().equals(this.getRight());
  }
  public static void main(String[] args){
    Point p1 = new PointC(-1.0,2.1);
    Point p2 = new PointC(1.0,4.0);
    Line l1 = new LineC(p2 , p1);
    Line l2 = new LineC(p2,p1);
    System.out.println(l1);
    System.out.println(l1.getLeft());
    System.out.println(l1.getRight());
    System.out.println(l1.length());
    System.out.println(l1.midPoint());
    System.out.println(l1.move(1.0,1.0));
    System.out.println(l1.equals(l2));

  }
}
