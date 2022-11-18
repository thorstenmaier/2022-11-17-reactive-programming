package backpressure;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class HotObservable {
    public static void main(String[] args) throws InterruptedException {

        PublishSubject<Long> subject = PublishSubject.create();

        subject // Hot Observable - Thread 1
                .observeOn(Schedulers.computation())
                .subscribe(l -> { // Thread 2
                    System.out.println(l);
                    Thread.sleep(1000);
                });

        long count = 0;
        for(;;) {
            subject.onNext(count++);
        }
    }
}
