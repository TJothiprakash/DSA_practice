package Curious_Freaks.Recursion;

public class FactorialofaNumber {
    public static void main(String[] args) {
        FactorialofaNumber factorialofaNumber = new FactorialofaNumber();
        System.out.println(factorialofaNumber.findfactorial(7));
    }

    long findfactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * findfactorial(n - 1);
    }
}
