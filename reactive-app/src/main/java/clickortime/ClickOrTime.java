package clickortime;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ClickOrTime {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> systemEmailSource = Observable.just("admin@trivadis.com", "admin@accenture.com");
        Observable<String> systemEmail = Observable.zip(systemEmailSource, Observable.interval(3, TimeUnit.SECONDS), (s, i) -> s);

        Observable<TimeEvent> timer = Observable.interval(3, TimeUnit.SECONDS)
                .map(i -> new TimeEvent());

        Observable<ClickEvent> clicks = Observable.interval(5, TimeUnit.SECONDS)
                .map(i -> new ClickEvent());

        Observable<MailEvent> mailEventsAusTimer = timer.map(t -> new MailEvent("Timer"));
        Observable<MailEvent> mailEventsAusClicks = clicks.map(t -> new MailEvent("Click"));
        Observable<MailEvent> allMailEvents = mailEventsAusTimer.mergeWith(mailEventsAusClicks);

        Observable<MailEvent> mailEventMailAddress = systemEmail.map(mailAddress -> new MailEvent(null, mailAddress));

        allMailEvents.withLatestFrom(mailEventMailAddress, (mailEvent, addressEvent) ->
                new MailEvent(mailEvent.getMessage(), addressEvent.getEmail()))
                .blockingSubscribe(e -> {
                    System.out.println("SEND MAIL " + e);
                });
    }
}
