import io.reactivex.rxjava3.core.Observable;

public class FlatMapOperator {
    public static void main(String[] args) {
        Observable.just("1 2 3", "4 5", "6")
                .flatMap(s -> Observable.fromArray(s.split(" ")))
                .subscribe(System.out::println);
    }
}
