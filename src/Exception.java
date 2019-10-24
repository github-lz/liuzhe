public class Exception {
    public static void main(String[] args) {
        String st1 = "asd";
        StringBuilder st2 = new StringBuilder("asd");
        String st3 = new String("asd");
        System.out.println(st1.equals(st2));
        System.out.println(st2.equals(st3));
        System.out.println(st2);
    }

}
