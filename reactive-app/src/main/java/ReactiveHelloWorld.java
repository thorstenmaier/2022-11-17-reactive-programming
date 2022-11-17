import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class ReactiveHelloWorld {
    public static void main(String[] args) {
        Observable.just("Hallo", "Welt", "!")
                .subscribe(System.out::println);

        String[] array = new String[] {"Hallo", "Welt", "!"};
        Observable.fromArray(array)
                .subscribe(System.out::println);

        List<String> list = Arrays.asList("Hallo", "Welt", "!");
        Observable.fromIterable(list)
                .subscribe(System.out::println);
    }
}
