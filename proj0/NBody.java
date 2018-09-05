public class NBody {
    /**Given a file name and return a double corresponding to the radius. */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readLine();
        return in.readDouble();
    }
    /**Return an array of Planets corresponding to the planets. */
    public static Planet[] readPlanets(String fileName) {
        double xP, yP, xV, yV, m;
        String img;
        In in = new In(fileName);
        int size = in.readInt();
        Planet[] result = new Planet[size];
        in.readLine();
        in.readLine();
        for(int i = 0; i < size; i++) {
            xP = in.readDouble();
            yP = in.readDouble();
            xV = in.readDouble();
            yV = in.readDouble();
            m = in.readDouble();
            img = in.readString();
            in.readLine();
            result[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return result;
    }
    /**Collect all needed input. */
    public static void main(String args[]) {
        double T, dt, radius;
        String filename;
        Planet[] planets;
        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        filename = args[2];
        radius = readRadius(filename);
        planets = readPlanets(filename);
        /**Draw the background and planets. */
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (int i = 0; i < planets.length; i++) {
            planets[i].draw();
        }
    }


}
