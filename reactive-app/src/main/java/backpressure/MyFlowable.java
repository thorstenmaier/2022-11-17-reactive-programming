package backpressure;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscription;

public class MyFlowable {
    public static void main(String[] args) {
        Flowable.range(1, 100).subscribe(new FlowableSubscriber<Integer>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(@NonNull Subscription s) {
                this.subscription = s;
                s.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
//                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("COMPLETE");
            }
        });
    }
}
