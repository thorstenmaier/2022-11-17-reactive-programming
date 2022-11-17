import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class ProgrammaticalEvents {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(
                s -> System.out.println(s)
        );

        subject.onNext("Hallo");
        subject.subscribe(
                s -> System.out.println(s)
        );
        subject.onNext("Welt");
    }
}
