import java.util.*;
public class StackUsingArrayList{
    static class Stack{
        static ArrayList<Integer> ar = new ArrayList<>();
        //isEmpty()
        public boolean isEmpty()
        {
            return ar.size() == 0;
        }
        //push
        public void push(int val)
        {
            ar.add(val);
        }
        //pop
        public int pop()
        {
            if(ar.size() == 0) return -1;
            int top = ar.get(ar.size()-1);
            ar.remove(ar.size()-1);
            return top;
        }
        //peek
        public int peek()
        {
            if(ar.size() == 0) return -1;
            return ar.get(ar.size()-1);
        }
    }
    public static void main(String[] args)
    {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        while(!st.isEmpty())
        {
           System.out.print(st.pop()+",");
        }
    }
}