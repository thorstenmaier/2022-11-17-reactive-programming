package clickortime;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MailAddressesWithDelay {
    public static void main(String[] args) {
        Observable<String> systemEmailSource = Observable.just("admin@trivadis.com", "admin@accenture.com");
        Observable<Long> takt = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(systemEmailSource, takt, (mail, t) -> mail)
                .blockingSubscribe(System.out::println);
    }
}
