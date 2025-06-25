
public class StaticAndGlobal {
    static int x = 0;
    public static int fun(int n)
    {
        if(n>0)
        {
            x++;
            return fun(n-1)+x;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println(fun(n));
    }
}
