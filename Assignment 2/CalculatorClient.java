import CalculatorModule.*;
import org.omg.CosNaming.*;
import java.util.*;
import org.omg.CORBA.*;


class CalculatorClient{
    public static void main(String[] args){

        try{
              ORB orb = ORB.init(args,null);
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        Calculator cal = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        float a = sc.nextFloat();
        System.out.println("Enter the second number: ");
        float b = sc.nextFloat();
        
        System.out.println("Addition: " + cal.add(a, b));
        System.out.println("Subtraction: " + cal.sub(a, b));
        System.out.println("Multiplication: " + cal.multi(a, b));
        System.out.println("Division: " + cal.div(a, b));
        sc.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
      
    }
}