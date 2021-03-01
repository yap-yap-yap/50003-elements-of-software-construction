package q3;

public class ComplexNumber{
    private double real = 0.0;
    private double imaginary = 0.0;

    ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    ComplexNumber(){}

    public double getReal(){
        return this.real;
    }

    public double getImaginary(){
        return this.imaginary;
    }

    public String toString(){   //this formats the complex number for displaying to user
        StringBuilder output = new StringBuilder();
        output.append(real);
        if(imaginary >= 0){
            output.append("+");
        }
        output.append(String.valueOf(imaginary));
        output.append("i");

        return output.toString();
    }
}