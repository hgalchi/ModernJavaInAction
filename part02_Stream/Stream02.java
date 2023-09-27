package part02_Stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Stream02 {

    public static void main(String[] args) {
        List<Dish> list = new ArrayList<>(Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("frcnch fries", true, 300, Dish.Type.FISH),
                new Dish("rice",true,560, Dish.Type.OTHER)
        ));

        //takewhile
        //new takeWhile().run(list);

        new flatMap().run2();

        // stream 소비
        /*Stream s = list.stream();
        s.forEach(System.out::println);*/
        //s.forEach(System.out::println);


       /* // stream 중간연산
        new stream_4().run(list);*/

        /*new ex2().run_Map();
        System.out.println("==================");
        new ex2().run_flatMap();*/

    }


}
class Dish{

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    String name;
    boolean vegetarian;
    int calories;
    Type type;

    public enum Type {MEAT, FISH, OTHER}

    public Dish(String name,boolean vegetarian, int calories,Type type){
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName(){return name;}

    @Override
    public String toString() {
        return name;
    }
}

class stream_4{

    public void run(List<Dish> list ) {
        List<String> names=list.stream()
                .filter(d->{  System.out.println("filtering "+d.getName());
                    return d.getCalories()>300;
                })
                .map(d->{
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(names);


    }
}

class ex2{

    //두개의 숫자 리스트가 있을 때 모든 숫자쌍의 리스트를 반환하시오
    List<Integer> number1 = Arrays.asList(1, 2, 3);
    List<Integer> number2 = Arrays.asList(3, 4);

    public void run_Map() {
        List<List<int[]>> result = number1.stream()
                .map(i -> number2.stream()
                        .map(j -> new int[]{i, j}).collect(Collectors.toList())).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    public void run_flatMap() {
        List<int[]> result=number1.stream().flatMap(i->number2.stream()
                .map(j->new int[]{i,j})).collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    public void anyMatch() {
        boolean isnum = number1.stream().anyMatch(t -> "1".equals(t));
    }



}

class takeWhile {
    void run(List<Dish> list) {
        List<Dish>dish=list.stream().takeWhile(d -> d.getCalories() > 300)
                .collect(Collectors.toList());
        dish.forEach(System.out::println);

    }
}

class flatMap {
    String[] wordList = {"good", "hi"};

    //두개의 stream list
    /*void run1() {
        Stream<String> list = Arrays.stream(wordList);
        List<String> result=list.map(w -> w.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }*/

    void run2() {
        Stream<String> list = Arrays.stream(wordList);
        List<String>result=list.map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}






















