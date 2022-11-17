package clickortime;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ClickOrTime {
    public static void main(String[] args) {
        Observable<TimeEvent> timer = Observable.interval(3, TimeUnit.SECONDS)
                .map(i -> new TimeEvent());

        Observable<ClickEvent> clicks = Observable.interval(5, TimeUnit.SECONDS)
                .map(i -> new ClickEvent());
    }
}
