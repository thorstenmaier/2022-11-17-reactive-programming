package backpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MyInterval {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.NANOSECONDS)
                .observeOn(Schedulers.computation())
                .subscribe(System.out::println);

        Thread.sleep(100_000);
    }
}
