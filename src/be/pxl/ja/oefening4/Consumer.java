package be.pxl.ja.oefening4;

import java.util.Timer;
import java.util.TimerTask;

public class Consumer extends Thread {
    private final ProductionLine line;
    private final int packageRatePerMinute;

    public Consumer(int packageRatePerMinute, ProductionLine line) {
        this.packageRatePerMinute = packageRatePerMinute;
        this.line = line;
    }

    @Override
    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Package packageToTake = line.getPackage();
                if (packageToTake != null) {
                    System.out.println("Consumer [" + Thread.currentThread().getName() + "] getting " + packageToTake);
                } else {
                    System.out.println("No package to take");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 0, (60 / packageRatePerMinute) * 1000);
    }
}
