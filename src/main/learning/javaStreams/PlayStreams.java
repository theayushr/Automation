package main.learning.javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class PlayStreams {
    public static void main(String[] args){

        List<String> nums = new ArrayList<>();
        nums = Arrays.asList("23","25", "12","34", "97", "38");

        //int sum = nums.stream().mapToInt(value -> Integer.parseInt(value)).sum();
        OptionalInt maxi = nums.stream().mapToInt(value -> Integer.parseInt(value)).max();


        System.out.println(maxi.getAsInt());

    }
}
