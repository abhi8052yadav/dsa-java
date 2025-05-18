import java.util.*;
public class PushAtBottom {
    public static void pushAtBottom(int val,Stack<Integer> st){
        if(st.isEmpty())
        {
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtBottom(val,st);
        st.push(top);
        // Stack<Integer> st2 = new Stack<>();
        // if(st.isEmpty()) {
        //     st.push(val);
        //     return;
        // }
        // while(!st.isEmpty())
        // {
        //     st2.push(st.pop());
        // }
        // st.push(val);
        // while(!st2.isEmpty())
        // {
        //     st.push(st2.pop());
        // }
    }
    public static void main(String[] args)
    {
       Stack<Integer> st = new Stack<>();
       st.push(2);
       st.push(3);
       st.push(4);
       pushAtBottom(1, st);
       while(!st.isEmpty())
       {
        System.out.println(st.pop());
       }
    }
    
}
