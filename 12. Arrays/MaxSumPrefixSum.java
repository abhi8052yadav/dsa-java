public class MaxSumPrefixSum {
    public static void main(String[] args)
    {
        int[] arr = {1,2,-3,4,-2,0};
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            int start = i;
            for(int j=i; j<arr.length; j++)
            {
                int end = j;
                int currSum  = start == 0?prefixSum[i] : prefixSum[end] - prefixSum[start-1];
                if(maxSum < currSum)
                {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("this is your maximum subarray sum present in this array : "+maxSum);
    }
}
