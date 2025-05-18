public class MaxSumSimple{
    public static void main(String[] args)
    {
        int[] arr = {1,2-3,4,-2,0};
        int maxSum = arr[0];
        for(int i=0; i<arr.length; i++)
        {
            for(int j = i; j<arr.length; j++)
            {
                int currSum = 0;
                for(int k=i; k<=j; k++)
                {
                    currSum += arr[k];
                    if(currSum > maxSum )
                    {
                        maxSum = currSum;
                    }
                }
            }
        }
        System.out.println("the maxSum of the array is this : "+maxSum);
    }
}