import io.reactivex.rxjava3.subjects.PublishSubject;

public class ProgrammaticalEvents {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(System.out::println);

        subject.onNext("Hallo");
        subject.onNext("Welt");
    }
}
