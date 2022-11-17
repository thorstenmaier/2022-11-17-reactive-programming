package clickortime;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ClickOrTime {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> systemEmail = Observable.just("admin@trivadis.com");

        Observable<TimeEvent> timer = Observable.interval(3, TimeUnit.SECONDS)
                .map(i -> new TimeEvent());

        Observable<ClickEvent> clicks = Observable.interval(5, TimeUnit.SECONDS)
                .map(i -> new ClickEvent());

        Observable<MailEvent> mailEventsAusTimer = timer.map(t -> new MailEvent("Timer"));
        Observable<MailEvent> mailEventsAusClicks = clicks.map(t -> new MailEvent("Click"));
        Observable<MailEvent> allMailEvents = mailEventsAusTimer.mergeWith(mailEventsAusClicks);

        Observable.combineLatest(allMailEvents, systemEmail,
                        (mailEvent, mail) -> new MailEvent(mailEvent.getMessage(), mail))
                .blockingSubscribe(e -> {
                    System.out.println("SEND MAIL " + e);
                });
    }
}
