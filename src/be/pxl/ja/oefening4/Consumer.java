package be.pxl.ja.oefening4;

import java.util.Optional;
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
        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                Optional<Package> packageToTake = line.getPackage();
                if (packageToTake.isPresent()) {
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
        timer.schedule(repeatedTask, 0, (60 / packageRatePerMinute) * 1000);
    }
}
