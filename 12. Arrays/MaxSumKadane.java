public class MaxSumKadane {
    public static void main(String[] args) {
        int[] arr = {1,2,-3,4,-2,0};
        int currSum = arr[0];
        int maxSum = arr[0];
        for(int i=0; i<arr.length; i++)
        {
            currSum = Math.max(arr[i],currSum+arr[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        System.out.println("the best way to calculating the maxSubArraySum which is : "+maxSum);
    }
}
