import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class FibonacciTest {

    @Test
    public void testFibonacci() {
        Observable<BigInteger> fibonacci = fibonacci();
        TestObserver<BigInteger> testObserver = fibonacci.take(5).test();
        testObserver.assertValues(BigInteger.ONE, BigInteger.ONE, BigInteger.valueOf(2l), BigInteger.valueOf(3l), BigInteger.valueOf(5l));
        testObserver.assertComplete();
    }

    public Observable<BigInteger> fibonacci() {
        return Observable.generate(new Consumer<Emitter<BigInteger>>() {
            BigInteger current = BigInteger.ONE;
            BigInteger last = BigInteger.ZERO;

            @Override
            public void accept(Emitter<BigInteger> t) {
                t.onNext(current);
                BigInteger nextLast = current;
                current = last.add(current);
                last = nextLast;
            }
        });
    }

}