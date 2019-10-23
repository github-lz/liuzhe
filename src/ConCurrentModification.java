import java.util.*;

public class ConCurrentModification {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //Map<String,Integer> map = new HashMap<>();
        for (int i = 0;i<=20;i++)
        {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
    }
}
