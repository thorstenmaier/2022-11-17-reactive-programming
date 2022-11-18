package backpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ColdObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 100_000) // Cold Observable - Thread 1
                .observeOn(Schedulers.computation())
                .subscribe(l -> { // Thread 2
                    System.out.println(l);
                    Thread.sleep(1000);
                });

        Thread.sleep(100_000);
    }
}
