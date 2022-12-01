package InterfaceExamples;

public interface Distance {

    // compute the distance between the current point and p
    // current point is the one that the user implemented - why Point implements distance
    double distance(Point p);

    // static version of distance
    static double distance(Point p1, Point p2) {
        return p1.distance(p2);
    }

}
