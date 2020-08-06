package test.java.test;

public class JavaDemo {

    public static void main(String[] args) {
        
        String str = new String("ada");
        char[] ch = { 'a', 'b', 'c' };

        change(str,ch);

        System.out.print(str +" and ");
        System.out.print(ch);
    }


    public static void change(String str, char ch[]) {
        str = "ada 111";

        ch[0] = 'd';
    }
}