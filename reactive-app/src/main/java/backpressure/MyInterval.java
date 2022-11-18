package backpressure;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MyInterval {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.NANOSECONDS) // Interval-Thread
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.computation()) // Buffer - Queue

                .subscribe(System.out::println); // Computation-Thread

        Thread.sleep(100_000); // main
    }
}
