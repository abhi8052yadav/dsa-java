public class StackUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    static class Stack {
        static Node head = null;
        //isEmpty()
        public boolean isEmpty()
        {
            return head == null;
        }
        //push
        public void push(int val)
        {
            Node newNode = new Node(val);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        //pop
        public int pop()
        {
            if(isEmpty()) return -1;
            int val = head.data;
            head = head.next;
            return val;
        }
        //peek
        public int peek()
        {
            if(isEmpty()) return -1;
            return head.data;
        }

    }
    public static void main(String[] args)
    {
        Stack st = new Stack();
        st.push(2);
        st.push(3);
        st.push(4);
        while(!st.isEmpty())
        {
            System.out.print(st.pop()+",");
        }
    }
    
}
