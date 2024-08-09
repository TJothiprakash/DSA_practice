package test;

public class test01 {
    public static void main(String[] args) {
        sayHello();

        // to get input from the cx
      /*  System.out.print("Enter your name: " + " ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.equals("Jothiprakash")) {
            name = "JP";
            System.out.println("Hello " + name);
        } else {
            System.out.println("YOu are not JP ");
        }*/

        // func(5, 0);
        // int ans = sumofnnumbers(10);
        //  System.out.println(ans);

        //  int fact = factorial(5);
        //   System.out.println(fact);
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int sumofnnumbers(int n) {
        if (n == 0) return 0;
        return n + sumofnnumbers(n - 1);

    }

    static void reverseArray(int[] arr, int start, int end) {

        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            //start++;
            //end--;
            reverseArray(arr, start + 1, end - 1);
        }

    }

    static void func(int i, int n) {
        if (i <= n) {
            return;
        }
        System.out.println(i);
        System.out.println("Jothipraksh T");
        func(i - 1, n);
    }


    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void sayHello() {
        System.out.println("Hello");
        sayHi();
    }

    private static void sayHi() {
        System.out.println("Hi");
    }
}
