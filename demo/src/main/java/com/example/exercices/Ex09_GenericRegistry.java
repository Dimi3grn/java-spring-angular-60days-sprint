package com.example.exercices;

public class Ex09_GenericRegistry {

    public static void main(String[] args) {
        Product Product1 = new Product("Product 1");
        Product Product2 = new Product("Product 2");
        Product Product3 = new Product("Product 3");

        GenericRegistry<Product> myRegistry =  new GenericRegistry<>();
        myRegistry.add(Product1);
        myRegistry.add(Product2);
        myRegistry.add(Product3);

        myRegistry.listAll();

        try {
            myRegistry.findByName("dsqdqs");
        }catch (NotFoundException error){
            System.out.println(error.getMessage());
        }


        myRegistry.findByName("Product 2");
        myRegistry.remove("Product 3");

        myRegistry.listAll();

        myRegistry.getAll().stream()
                .map(x -> x.getName().toUpperCase())
                .forEach( System.out::println);

    }
}
