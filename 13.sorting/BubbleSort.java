public class BubbleSort{
    public static void main(String[] args)
    {
        int[] arr = {5,6,8,9,2,1,4,7};
        int n = arr.length; 
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n-i-1; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("ater sorting the array is : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i]+" ");
        }
    } 
}