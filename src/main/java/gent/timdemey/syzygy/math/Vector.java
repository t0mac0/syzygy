package gent.timdemey.syzygy.math;

public class Vector {
    
    /** The start point. */
    private final double[][] t_0;
    /** The (denormalized) direction. */
    private final double[][] m;
    
    public Vector (Point first, Point second) {
        t_0 = first.getMatrix();
        m = first.substractFrom(second).getMatrix();
    }
}
