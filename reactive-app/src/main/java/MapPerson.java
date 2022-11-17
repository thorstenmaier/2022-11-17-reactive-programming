import io.reactivex.rxjava3.core.Observable;

public class MapPerson {
    public static void main(String[] args) {
        Observable.just("Simon", "Markus", "Thorsten")
                .map(Person::new)
                .subscribe(System.out::println);
    }
}
