package Algorithms;
import java.util.*;

public class MergeIntervals {
    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    class IntervalsComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval) o1;
            Interval i2 = (Interval) o2;
            return Integer.compare(i1.start, i2.start);
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return new LinkedList<>();
        Collections.sort(intervals, new IntervalsComparator());
        List<Interval> result = new LinkedList<>();
        Interval curr = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start > curr.end) {
                result.add(curr);
                curr = interval;
            } else {
                curr.end = Math.max(curr.end, interval.end);
            }
        }
        result.add(curr);
        return result;
    }
}
