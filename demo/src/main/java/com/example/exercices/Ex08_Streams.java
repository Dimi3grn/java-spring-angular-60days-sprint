package com.example.exercices;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex08_Streams {

    public static void main(String[] args){

        List<Integer> numbers = List.of(1, 2, 3, 4,5,6,7,8,9,10,11);

        List<Integer> pairs = numbers.stream()
                .filter(x -> x%2 == 0)
                .toList();

        System.out.println(pairs);

        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna", "Bruno");

        List<String> namesA = names.stream()
                .filter(x -> x.startsWith("A"))
                .map(x -> x.toUpperCase())
                .toList();

        System.out.println(namesA);

        List<MechanicalComponent> toolbox = List.of(
                new MechanicalComponent("A", 10.0, 1000),
                new MechanicalComponent("B", 50.0, 2000),
                new MechanicalComponent("C", 25.0, 1500),
            new MechanicalComponent("C", 45.0, 5225)
        );

        toolbox.stream()
                .filter(x -> x.getWeight()>20)
                .forEach(x -> System.out.println(x.getName()));

        toolbox.stream()
                .sorted(Comparator.comparingDouble(x -> x.getWeight()))
                .map(x -> x.describe())
                .forEach(x -> System.out.println(x));

        Integer reduced = numbers.stream()
                .reduce(0, (acc, x)-> acc + x);

        System.out.println(reduced);

        List<String> namesToolbox = toolbox.stream()
                .filter(x -> x.getMaxRPM()>1500)
                .sorted(Comparator.comparingDouble((MechanicalComponent x) -> x.getWeight()).reversed())
                .map(MechanicalComponent::getName)
                .toList();

        System.out.println(namesToolbox);
    }

}
