import CalculatorModule.CalculatorPOA;

class CalculatorImpl extends CalculatorPOA{
    public float add(float a,float b){
        return a+b;
        
    }
    public float sub(float a,float b){
        return a-b;
        
    }
    public float multi(float a,float b){
        return a*b;
        
    }
    public float div(float a,float b){
        if(b == 0){
            return 0;
        }
        return a/b;
        
    }
}
