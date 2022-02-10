package pl.sda.java.adv.school.util;

import java.util.Iterator;

public class Fibonacci implements Iterable<Long> {

    @Override
    public Iterator<Long> iterator() {
        return new NestedFibonacciIterator();
    }

    private static class NestedFibonacciIterator implements Iterator<Long> {
        private Long first = 0L;
        private Long second = 1L;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Long next() {
            long result = first;
            first = second;
            second = result + first;
            return result;
        }
    }
}
