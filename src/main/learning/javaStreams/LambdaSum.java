package main.learning.javaStreams;

public class LambdaSum {
    public static void main(String[] args){

        int num1 = 23;
        int num2 = 90;

        Sum sumNum = (f,s) -> {return f+s; };

        int add = sumNum.addNumbers(num1, num2);

        System.out.println(add);



        // MULTIPLY

        Multiply instance = (int f, int s) -> {return f*s; };

        System.out.println(instance.multiplyNumber(num2,num1));

    }
}

@FunctionalInterface
interface Sum{
    int addNumbers(int a, int b);
}

@FunctionalInterface
interface Multiply{
    int multiplyNumber(int a,int b);
}
