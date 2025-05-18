import java.util.*;
public class ReverseAStack {

    public static void reverseStack(Stack<Integer> st)
    {
        if(st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);
        pushAtBottom(top,st);
    }
    public static void pushAtBottom(int val,Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtBottom(val,st);
        st.push(top);
    }
    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
}
