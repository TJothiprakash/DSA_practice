import org.jetbrains.annotations.NotNull;

public class Sumsubarrayoverlap {
        public int maxSumTwoNoOverlap(int @NotNull [] nums, int firstLen, int secondLen) {
            int n=nums.length;
            int arr[]=new int[n+1];
            for(int i=0;i<n;i++){
                arr[i+1]=nums[i]+arr[i];
            }
            int sum=0;
            for(int i=0;i<=n-firstLen-secondLen;i++){
                int firstsum=arr[i+firstLen]-arr[i];
                for(int j=i+firstLen;j<=n-secondLen;j++){
                    int secondsum=arr[j+secondLen]-arr[j];
                    sum=Math.max(sum,firstsum+secondsum);
                }
            }
            for(int i=0;i<=n-firstLen-secondLen;i++){
                int secondsum=arr[i+secondLen]-arr[i];
                for(int j=i+secondLen;j<=n-firstLen;j++){
                    int firstsum=arr[j+firstLen]-arr[j];
                    sum=Math.max(sum,firstsum+secondsum);
                }
            }
            return sum;
        }

    public static void main(String[] args) {
        Sumsubarrayoverlap sumsubarrayoverlap= new Sumsubarrayoverlap();
        int arr[]= {0,6,5,2,2,5,1,9,4};
       // System.out.println(sumsubarrayoverlap.maxSumTwoNoOverlap(arr,2,3));
        System.out.println(sumsubarrayoverlap.maxSumTwoNoOverlap(arr,1,2));
    }
}
