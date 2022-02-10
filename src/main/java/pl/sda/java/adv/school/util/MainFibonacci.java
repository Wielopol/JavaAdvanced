package pl.sda.java.adv.school.util;

import java.util.stream.StreamSupport;

public class MainFibonacci {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int i = 0;

        for (Long l : fib) {
            System.out.println(l);
            i++;
            if (i >= 15) {
                break;
            }
        }
        System.out.println();

        StreamSupport.stream(fib.spliterator(), false)
                .skip(5)
                .limit(15)
                .forEach(System.out::println);
    }
}
