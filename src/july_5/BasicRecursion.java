package july_5;

public class BasicRecursion {

    public static void main(String[] args) {
        BasicRecursion  basicRecursion= new BasicRecursion();
        basicRecursion.printNos(6);
    }
    public void printNos(int N)
    {
        //Your code here
        int i =1;
        printNum(i,N);

    }
    public void printNum (int i, int N){
        if(i<=N) System.out.print(i + " ");
        else return;

        printNum(i+1,N);
    }

}


class Solution {

    void printGfg(int N) {
        // code here
        printName(N);
    }
    static void printName(int n){
        if(n>=1){
            System.out.print("GFG ");
            n--;
        }else{
            return;
        }
        printName(n);

    }
}

