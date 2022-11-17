import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRange;

import java.util.concurrent.TimeUnit;

public class AdvancedReactiveHelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Observable.empty().subscribe(System.out::println);

        Observable.range(100, 10).subscribe(System.out::println);

        Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);

        Thread.sleep(10_000);
    }
}
