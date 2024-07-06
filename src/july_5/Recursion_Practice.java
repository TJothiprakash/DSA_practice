package july_5;

public class Recursion_Practice {
    public static void main(String[] args) {
        Recursion_Practice recursionPractice = new Recursion_Practice();
        recursionPractice.printsomething(0, 5);
    }

    void printsomething(int i, int n) {
        if (i > n) return; 
        f(i,n);
        System.out.print("JP ");

     printsomething(i+1,n);

    }

    private void f(int i, int n) {
        System.out.print(i + " ");
    }

// FIXME: 7/5/2024  remember this day 

}
