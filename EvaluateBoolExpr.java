// Matthew_Kim_Assignment_2


import java.util.Scanner;
public class EvaluateBoolExpr
{

  public static void main(String[] args)
  {
     StringStack ops = new FixedCapacityStack();
     StringStack vals = new FixedCapacityStack();


     Scanner scan = new Scanner(System.in);

     while(scan.hasNext())
     {
        String token = scan.next();//StdIn.readString();
        if (token.equals("false") || token.equals("true")){
          vals.push(token);
        }

        else{
          if (token.equals("("))                ;
          else if(token.equals("!")) ops.push(token);
          else if(token.equals("||")) ops.push(token);
          else if(token.equals("&&")) ops.push(token);
          else if(token.equals(")"))
          {
            boolean u = Boolean.parseBoolean(vals.pop());
            boolean v = Boolean.parseBoolean(vals.pop());

            boolean result = false;

            String op = ops.pop();

            if(op.equals("!")) result = !u;
            else if(op.equals("||")) result = u || v;
            else if(op.equals("&&")) result = u && v;



      vals.push(Boolean.toString(result));
      }  //Please, complete the evaluation of full parethesized boolean expression.
    }
     }
     System.out.println("The result of evaluation is: " + vals.pop());
     scan.close();
}
}
