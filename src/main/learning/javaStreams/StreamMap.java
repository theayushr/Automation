package main.learning.javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args){

        ArrayList<String> names = new ArrayList<>();
        names.add("Ayush");
        names.add("Sysquare");
        names.add("jaipur");
        names.add("AStart");
        names.add("Aseem");
        names.add("jp");
        names.add("Aa");
        names.add("Area");
        names.add("EndsWithA");

        List<String> students = Arrays.asList("Jasona", "Ramesha", "Shiv", "Ayuhasha", "Martin", "Eaa", "Aacdasaa");


        //print names of len>2 in uppercase
        names.stream().filter(name -> name.length()>5).sorted().forEach(name->System.out.println(name.toUpperCase()));

        //print name which have last letter with 'a' and print then in upper case
        names.stream().filter(name -> name.toLowerCase().endsWith("a")).map(name -> name.toUpperCase()).forEach(name-> System.out.println(name));

        //apply both filters
        names.stream().filter(name -> name.length()>2).filter(name-> name.toLowerCase().endsWith("a")).map(name-> name.toLowerCase()).forEach(name->System.out.println(name));
        System.out.println("------------------------------------------");
        //concat two lists

        Stream<String> joined = Stream.concat(names.stream(), students.stream());
        //joined.forEach(name ->System.out.println(name));
        //joined.filter(name -> name.toLowerCase().endsWith("a")).sorted().forEach(name -> System.out.println(name));
        //boolean flag = joined.anyMatch(name-> name.equalsIgnoreCase("AYusH"));
        //long aytimes = joined.filter(name->name.contains("Ay")).count();
        //System.out.println(aytimes);

        //List<String>result = joined.filter(name-> name.toLowerCase().endsWith("a")).toList();
        List<String>result = joined.filter(name-> name.toLowerCase().endsWith("a")).collect(Collectors.toList());
        for(String value : result){
            System.out.println(value);
        }


        //sort the unique numbers
        List<Integer> values = Arrays.asList(1,2,3,4,2,3,4,1,2,3,4,5,6,3,4,5,8);
        values.stream().distinct().forEachOrdered(num->System.out.println(num));


        ArrayList<String> stdnames = new ArrayList<>(Arrays.asList("tim", "martin", "jaina", "jasona", "jamesclear", "magnuscarlsen", "hikarunakamura", "chess"));

        List<String> filter = stdnames.stream().filter(name -> name.length()>5).toList();
        filter.forEach(name -> System.out.println(name));



        //values.forEach(num->System.out.println(num));




    }
}
