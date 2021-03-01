package q3;
import java.lang.Math;

public class ComplexOperation {
    private ComplexNumber a;
    private ComplexNumber b;

    ComplexOperation(double a_real, double a_imaginary, double b_real, double b_imaginary){
        this.a = new ComplexNumber(a_real, a_imaginary);
        this.b = new ComplexNumber(b_real, b_imaginary);
    }
    
    //opertaion methods 
    public void Addition(){
        double c_real = a.getReal() + b.getReal();
        double c_imaginary = a.getImaginary() + b.getImaginary();
        ComplexNumber c = new ComplexNumber(c_real, c_imaginary);
        System.out.println(c.toString());
    }

    public void Subtraction(){
        double c_real = a.getReal() - b.getReal();
        double c_imaginary = a.getImaginary() - b.getImaginary();
        ComplexNumber c = new ComplexNumber(c_real, c_imaginary);
        System.out.println(c.toString());

    }

    public void Mulitplication(){
        double c_real = a.getReal()*b.getReal() - a.getImaginary()*b.getImaginary();
        double c_imaginary = a.getImaginary()*b.getReal() + a.getReal()*b.getImaginary();
        ComplexNumber c = new ComplexNumber(c_real, c_imaginary);
        System.out.println(c.toString());
    }
    
    public void Division(){
        double c_real = (a.getReal()*b.getReal() + a.getImaginary()*b.getImaginary())/(Math.pow(b.getReal(), 2)+Math.pow(b.getImaginary(), 2));
        double c_imaginary = (a.getImaginary()*b.getReal() - a.getReal()*b.getImaginary())/(Math.pow(b.getReal(), 2)+Math.pow(b.getImaginary(), 2));
        ComplexNumber c = new ComplexNumber(c_real, c_imaginary);
        System.out.println(c.toString());
    }
}
