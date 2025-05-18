import java.util.*;
public class StockSpan {
    public static int[] stockSpan(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        int[] a = new int[arr.length];
        a[0] = 1;
        st.push(0);
        for(int i = 0; i < arr.length; i++)
        {
           int curr = arr[i];
           while(!st.isEmpty() && curr > arr[st.peek()])
           {
            st.pop();
           }
           if(st.isEmpty())
           {
            a[i] = i+1;
           }
           else{
            int prevHigh = st.peek();
            a[i] = i - prevHigh;
           }
           st.push(i);
        }
        return a;
    }
    public static void main(String[] args)
    {
        int arr[] = {100,80,60,70,60,85,100};
        System.out.println(Arrays.toString(stockSpan(arr)));
    }
}
