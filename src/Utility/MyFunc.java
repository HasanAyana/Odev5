package Utility;

public class MyFunc {
    public static void main(String[] args) {

    }
    public static void Bekle(int saniye){
        try {
            Thread.sleep(saniye*100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
