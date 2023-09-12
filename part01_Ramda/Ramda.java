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

        new Ramda_Function().map(Arrays.asList(1, 2, 3, 4), apple::new);

        //생성자 참조




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

class apple extends fruit{
    public apple(int weigh ) {
        this.weigh = weigh*2;
    }
}

class orange extends fruit{
    public orange(int weigh) {
        this.weigh = weigh * 3;
    }
}

class fruit{
    int weigh;
}
//todo : 120p
class MyFruit{

    public fruit givemefruit(String fruit, Integer weigh) {
        return
    }
}





