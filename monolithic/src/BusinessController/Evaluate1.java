package BusinessController;

import java.util.Scanner;

import java.util.Stack;

import Interface.Calculator;

public  class Evaluate1 implements Calculator
{
    public double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        
        Stack<Double> values = new Stack<Double>();

      
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' || tokens[i]=='.')
                    {
                		sbuf.append(tokens[i++]);
                		if(i>=tokens.length)
                			break;
                    }
                i--;
                values.push(Double.parseDouble(sbuf.toString()));
               
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(perform(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(perform(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push((double) perform(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

   public Double perform(char op, double b, double a)
    {
	   switch (op)
       {
       case '+':
          return add(a,b);
           
       case '-':
          return subtract(a,b);
       case '*':
         return multiply(a,b);
       case '/':
           if (b == 0)
               throw new
               UnsupportedOperationException("Cannot divide by zero");
           return divide(a,b);
       }
       return 0.0;
     
   }
   

	public static void Print( double result)
    {
    System.out.println("Ans: "+result);
    }

	

	
	public double add(double a,double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	
	public double subtract(double a,double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	public double multiply(double a,double b) {
		// TODO Auto-generated method stub
		return a*b;
	}


	public double divide(double a,double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char op;
		Evaluate1 e = new Evaluate1();
		String exp="";
		
		System.out.println("Enter the expression: ");
		Scanner sc1=new Scanner(System.in);
		exp=sc1.nextLine();
		Double result;
		  
		result=e.evaluate(exp);
		Print(result);

	}

}

