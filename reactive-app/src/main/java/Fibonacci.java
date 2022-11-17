import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        // Fibonacci
        Observable.generate(new Consumer<Emitter<BigInteger>>() {
            BigInteger current = BigInteger.ONE;
            BigInteger last = BigInteger.ZERO;
            @Override
            public void accept(Emitter<BigInteger> t) {
                t.onNext(current);
                BigInteger nextLast = current;
                current = last.add(current);
                last = nextLast;
            }
        }).subscribe(s -> {
            System.out.println(s);
            Thread.sleep(500);
        });
    }
}
