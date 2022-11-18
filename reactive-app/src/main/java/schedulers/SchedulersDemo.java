package schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulersDemo {
    public static void main(String[] args) {
        Observable.range(0, 5)
                .observeOn(Schedulers.newThread())
                .subscribe(i -> {
                    System.out.println(i);
                    Thread.sleep(1000);
                });
        Observable.range(0, 5).subscribe(i -> {
            System.out.println(i);
            Thread.sleep(1000);
        });
    }
}
