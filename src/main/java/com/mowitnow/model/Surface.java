package com.mowitnow.model;

/**
 * Represent the surface to mow
 *
 * @author amine
 */
public class Surface {
    private final int x;
    private final int y;

    public Surface(String x, String y) {
        this.x = Integer.parseInt(x.trim());
        this.y = Integer.parseInt(y.trim());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surface)) return false;

        Surface surface = (Surface) o;

        if (x != surface.x) return false;
        if (y != surface.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Surface{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
