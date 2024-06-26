package be.pxl.ja.oefening4;

public class Main {
    public static void main(String[] args) {
        ProductionLine line = new ProductionLine();

        Producer producer1 = new Producer(20, line);
        Producer producer2 = new Producer(15, line);
        Producer producer3 = new Producer(12, line);
        Producer producer4 = new Producer(7, line);

        Consumer consumer1 = new Consumer(30, line);
        Consumer consumer2 = new Consumer(25, line);

            producer1.start();
            producer2.start();
            producer3.start();
            producer4.start();

            consumer1.start();
            consumer2.start();
    }
}
