package i.am.jameshughkim.interviewsPrep.code_rust.math;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import lombok.Data;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * <h1>Closest Meeting Point</h1>
 * Given N people on MxM matrix, find the point that requires the least total distance
 * covered by all the people to meet at that point.
 * <Hint>
 *     * Distance between two points
 *     * Centroid of two-dimensional region
 * </Hint>
 */
public class ClosestMeetingPoint {
    @Data
    public class Point {
        Pair<Integer, Integer> pair;

        public Point(int x, int y) {
            this.pair = Pair.of(x, y);
        }
    }

    Point closestMeetingPoint(int m, ArrayList<Point> points) {
        throw new NotImplementedException();
    }


}
