package Interface;


import java.io.*;  
import java.net.*;  
import java.util.Scanner;
public class Client {  
    public static void main(String[] args) {  
    try{      
    Socket s=new Socket("localhost",6666);  
    DataInputStream i=new DataInputStream(s.getInputStream());
    DataOutputStream o=new DataOutputStream(s.getOutputStream());  
    String st ="";
    Scanner sc = new Scanner(System.in);
    System.out.println("Server connected ");
    while(st.compareTo("quit")!=0)
    {
    	System.out.print("Client : ");
    	st = sc.nextLine();
	    o.writeUTF(st);
	    o.flush();
	    st=(String)i.readUTF();
	    System.out.print("Server : ");
	    System.out.println(st);
	    
    }
    
    o.close();  
    s.close();  
    }catch(Exception e){System.out.println("Server disconnected ");
    System.out.println(e);}  
    }  
}  
