import CalculatorModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class CalculatorServer{
    public static void main(String[] args){
        try{
            ORB orb = ORB.init(args,null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            rootPOA.the_POAManager().activate();

            CalculatorImpl cal = new CalculatorImpl();

            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(cal);

            Calculator href = CalculatorHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("Calculator");

            ncRef.rebind(path,href);

            System.out.println("Calculator Server is ready...");

            orb.run();

        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());

        }
    }
}