package Algorithms;
import java.util.*;

public class MeetingRoom {
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
     public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 1) return true;
        List<Interval> list = Arrays.asList(intervals);
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval curr = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval interval = list.get(i);
            if (interval.start < curr.end) return false;
            else curr = interval;
        }
        return true;
     }
}
