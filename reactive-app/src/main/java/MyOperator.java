import io.reactivex.rxjava3.core.Observable;

public class MyOperator {
    public static void main(String[] args) {
        Observable.just("Hallo", "Welt", "!")
                .filter(s -> s.contains("l"))
                .subscribe(System.out::println);
    }
}
