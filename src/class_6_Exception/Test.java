package class_6_Exception;

import class_1_back_to_CSIT111.JavaReview;

public class Test {
    public static void main(String[] args) {
        try{
            double res = divide(10,0);
            System.out.println(res);
            System.out.println("successful");
        } catch (ArithmeticException | IllegalArgumentException e){
//            System.out.println(e.getMessage());
            System.err.println("Zero in invalid");
        }

        System.out.println("finished");
    }

    public static double divide(int n, int d) throws ArithmeticException {
//        System.out.println("before divide");
        double res = n/d;
//        System.out.println("after divide");
        return res;
    }

}
