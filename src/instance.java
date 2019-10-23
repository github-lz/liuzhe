
public class instance {
    private static instance instance1=null;
    private instance(){
        System.out.println(Thread.currentThread().getName()+"\t我是构造函数");
    }
    public  static instance getInstance()
    {
        if(instance1==null)
        {
            synchronized (instance.class)
            {
                if(instance1==null)
                {
                    instance1 = new instance();
                }
            }
        }
        return instance1;
    }
    public static void main(String[] args)
    {
//        System.out.println(instance.getInstance()==instance.getInstance());
//        System.out.println(instance.getInstance()==instance.getInstance());
//        System.out.println(instance.getInstance()==instance.getInstance());
        for (int i=1;i<=100;i++)
        {
            new Thread(()->{
                instance.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
