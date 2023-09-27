package part01_Ramda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ramda {

    public static void main(String[] args) {

        //함수형 인터페이스

        //Predicate
        Predicate<Integer> p = (t) -> 12 < t;
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3,100));
        new Ramda_Predicate().filter(list, p);

        //Consumer
        new Ramda_Consumer().forEach(Arrays.asList(1,2,3,4)
                ,(t)-> System.out.println(t));

        //Function
        new Ramda_Function().map(Arrays.asList("apple", "orange", "wat"), (String s) -> s.length());

        // sorting
        new Ramda_Function().map(Arrays.asList(1, 2, 3, 4), apple::new);
        List<apple> inventory = new ArrayList<>(Arrays.asList(
                new apple(1),
                new apple(2),
                new apple(3)

        ));
        inventory.sort(Comparator.comparing(apple::getWeigh).reversed());

        inventory.sort(Comparator.comparing(apple::getWeigh).reversed()
                .thenComparing(apple::getWeigh));


        new primitivetype().map(3.2,(t)-> System.out.println("result :"+t));


    }
}

class Ramda_Predicate {
    public <T> void filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        System.out.println(result);
    }
}

class Ramda_Consumer{

    public <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}

class Ramda_Function{

    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
            System.out.println(result);
        }
        return result;
    }
}

class primitivetype{
    public <T> void map(T i, Consumer<T> c) {
        c.accept(i);
    }
}

class apple {

    Integer weigh;
    public apple(int weigh ) {
        this.weigh = weigh*2;
    }

    public  int getWeigh() {
        return weigh;
    }
}



//todo : 120p






