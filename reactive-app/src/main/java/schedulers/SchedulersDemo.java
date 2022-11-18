package schedulers;

import io.reactivex.rxjava3.core.Observable;

public class SchedulersDemo {
    public static void main(String[] args) {
        Observable.range(0, 5).subscribe(i -> {
            System.out.println(i);
            Thread.sleep(1000);
        });
        Observable.range(0, 5).subscribe(i -> {
            System.out.println(i);
            Thread.sleep(1000);
        });
    }
}
