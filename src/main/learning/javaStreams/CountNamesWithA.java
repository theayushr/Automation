package main.learning.javaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountNamesWithA {
    public static void main(String[] args){

        ArrayList<String> names = new ArrayList<>();
        names.add("Ayush");
        names.add("Sysquare");
        names.add("jaipur");
        names.add("AStart");
        names.add("Aseem");
        names.add("jp");
        names.add("Aa");
        names.add("area");

        int namewitha = 0;
        /*
        for(String name:names){
            if(name.toLowerCase().startsWith("a")){
                namewitha++;
            }
        }
        */

        long startsWithA = names.stream().filter(name->name.toLowerCase().startsWith("a")).count();

        long value = Stream.of("James", "Ay", "Alex", "martinc", "magnus").filter(name -> name.toLowerCase().startsWith("a")).count();


        //print all the names from names

        /*
        names.stream().filter(name ->
        {   System.out.println(name);
            return true;
        }).count();

         */

        //print names where length > 3

        long morethan3 = names.stream().filter(name -> name.length()>3).count();

        List<String> namemorethanthree =  names.stream().filter(name -> name.length()>3 ).toList(); //can print the list further

        /*
        names.stream().filter(name ->
        {
            if(name.toLowerCase().startsWith("a")){
                System.out.println(name);
            }
            if(name.length()>3){
                System.out.println(name + " : HEY!! I have more than three letters");
            }

            return true;
        }
        ).count();

         */

        //names.stream().filter(name -> name.length()>2).forEach(System.out::println);
        names.stream().filter(name -> name.length()>2).forEach(name->System.out.println(name));


    }
}
