import io.reactivex.rxjava3.core.Observable;

public class MyOperator {
    public static void main(String[] args) {
        Observable.just("1", "2", "!")
                .filter(s -> !s.contains("!"))
                .map(s -> Integer.parseInt(s))
                .subscribe(System.out::println);
    }
}
