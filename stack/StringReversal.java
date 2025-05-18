import java.util.*;
public class StringReversal {
    public static String reverseString(String s)
    {
       Stack<Character> st = new Stack<>();
       int idx = 0;
       while(idx < s.length())
       {
        st.push(s.charAt(idx));
        idx++;
       }
       StringBuilder str = new StringBuilder();
       while(!st.isEmpty())
       {
        char top = st.pop();
        str.append(top);
       }
       return str.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string : ");
        String s = sc.next();
        System.out.println(s);
        System.out.println(reverseString(s));
        sc.close();
    }
}
