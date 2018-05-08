package LeetCode;
import java.util.*;

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> it;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        next = it.hasNext() ? it.next() : null;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = next;
        next = it.hasNext() ? it.next() : null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        PeekingIterator solution = new PeekingIterator(it);
        System.out.println(solution.next());
    }
}
