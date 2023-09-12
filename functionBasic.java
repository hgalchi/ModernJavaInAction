import java.util.function.Function;

public class functionBasic {
    public static void funApply() {
        Function<Integer, String> functionAdd =
                (num) -> Integer.toString(num + 100);
        Function<Integer, String> functionminus =
                (num) -> Integer.toString(num - 100);
        Function<Integer, String> functionmultiple =
                (num) -> Integer.toString(num * 100);

        System.out.println(functionAdd.apply(50));
        System.out.println(functionminus.apply(50));
        System.out.println(functionmultiple.apply(50));
    }

    public static void funCompose() {
        Function<Integer, Integer> functionAdd =
                (num) -> num + 100;
        Function<Integer, Integer> functionMultiple =
                (num) -> num * 10;
        System.out.println
                (functionAdd.compose(functionMultiple).apply(50));

    }

    public static void funAndThen() {
        Function<Integer, Integer> functionAdd =
                (num) -> num + 100;
        Function<Integer, Integer> functionMultiple =
                (num) -> num * 10;
        System.out.println(functionAdd.andThen(functionMultiple).apply(50));
    }

    public static void main(String[] args) {
        funAndThen();

    }

}
