package com.example.exercices;
import java.util.List;

public class Ex07_Generics {

    public static <T> T first(List<T> list){
        return list.getFirst();
    }

    public static <T extends Component> T findHeaviest(List<T> list){
        T currentHeaviest = list.getFirst();
        for (T component : list){
            if (component.getWeight()>currentHeaviest.getWeight()){
                currentHeaviest = component;
            }
        }
        return currentHeaviest;
    }

    public static void main(String[] args){
        List<Integer> newlist = List.of(4,8,3,3);
        List<String> stringList = List.of("qsd","qsd","hehehe");

        System.out.println(first(newlist));
        System.out.println(first(stringList));

        Pair<Integer,String> newpair = new Pair<>(45,"dsq");

        System.out.println(newpair.getFirst());
        System.out.println(newpair.getSecond());

        List<MechanicalComponent> components = List.of(
                new MechanicalComponent("A", 10.0, 1000),
                new MechanicalComponent("B", 50.0, 2000),
                new MechanicalComponent("C", 25.0, 1500)
        );

        System.out.println("tests bounded generics");
        System.out.println(findHeaviest(components).describe());

    }

}
