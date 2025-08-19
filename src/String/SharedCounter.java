package String;

public class SharedCounter {
    public static int count = 0;
    
    public static void main(String[] args) {
        // 创建两个线程，都会增加同一个静态变量
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
                System.out.println("线程1完成，count = " + count);
            }

        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
                System.out.println("线程2完成，count = " + count);

            }
        });
        
        t1.start();
        t2.start();
    }
}