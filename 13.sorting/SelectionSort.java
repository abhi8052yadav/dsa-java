public class SelectionSort{
    public static void main(String[] args)
    {
        int[] arr = {2,3,4,5,6,4,9,8,7};
        int n = arr.length; 
        for(int i=0; i<n; i++)
        {
            int minIdx = i;
            for(int j = i+1; j<n; j++)
            {
                if(arr[j]<arr[i])
                {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}