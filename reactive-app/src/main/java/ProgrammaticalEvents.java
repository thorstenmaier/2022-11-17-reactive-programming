import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class ProgrammaticalEvents {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(
                s -> System.out.println(s),
                e -> e.printStackTrace(),
                () -> System.out.println("COMPLETE")
        );
        subject.subscribe(
                s -> System.out.println(s),
                e -> e.printStackTrace(),
                () -> System.out.println("COMPLETE")
        );

        subject.onNext("Hallo");
        subject.onNext("Welt");
        subject.onError(new RuntimeException("Fehler"));
    }
}
