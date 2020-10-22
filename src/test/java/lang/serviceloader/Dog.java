package test.java.lang.serviceloader;

public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}