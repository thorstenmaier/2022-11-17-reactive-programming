package connectables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class MyConnectable {
    public static void main(String[] args) throws InterruptedException {
        ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).replay();
        observable.connect();

        observable.subscribe(l -> System.out.println("1: " + l));
        Thread.sleep(3000);
        observable.subscribe(l -> System.out.println("2: " + l));
        Thread.sleep(3000);
        observable.subscribe(l -> System.out.println("3: " + l));

    }
}
