package clickortime;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ClickOrTime {
    public static void main(String[] args) throws InterruptedException {
        Observable<TimeEvent> timer = Observable.interval(3, TimeUnit.SECONDS)
                .map(i -> new TimeEvent());

        Observable<ClickEvent> clicks = Observable.interval(5, TimeUnit.SECONDS)
                .map(i -> new ClickEvent());

        Observable<MailEvent> mailEventsAusTimer = timer.map(t -> new MailEvent());
        Observable<MailEvent> mailEventsAusClicks = clicks.map(t -> new MailEvent());

        mailEventsAusTimer.mergeWith(mailEventsAusClicks)
                .blockingSubscribe(e -> {
                    System.out.println("SEND MAIL " + e);
                });
    }
}
