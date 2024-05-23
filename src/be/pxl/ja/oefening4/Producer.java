package be.pxl.ja.oefening4;

import java.util.Timer;
import java.util.TimerTask;

public class Producer extends Thread {
    private final ProductionLine line;
    private final int packageRatePerMinute;

    public Producer(int packageRatePerMinute, ProductionLine productionLine) {
        this.packageRatePerMinute = packageRatePerMinute;
        this.line = productionLine;
    }

    @Override
    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Package packageToProduce = new Package();
                System.out.println("Producer [" + Thread.currentThread().getName() + "] produced a package: " + packageToProduce);
                line.addPackage(packageToProduce);
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
