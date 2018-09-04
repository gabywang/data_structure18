public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;
    
    /**The first constructor with 6 instance variables. */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**The second contstructor takes in a planet objecct. */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    /**Calculate the distance between two planets. */
    public double calcDistance(Planet p) {
        return Math.pow(Math.pow(xxPos - p.xxPos, 2) + Math.pow(yyPos-p.yyPos, 2), 0.5);
    }

    /**Calculate the force exerted on the planet by the given planet. */
    public double calcForceExertedBy(Planet p) {
        return G * mass * p.mass / Math.pow(calcDistance(p), 2);
    }

    /**Calculate the force exerted in the X direction. */
    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    /**Calculate the force exerted in the Y direction. */
    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    /**Take in an array of Planets and calculate the net X force exerted by all planets. */
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForce = 0;
        for (int i = 0; i < allPlanets.length; i++) {
            if (!this.equals(allPlanets[i])) {
                netForce += calcForceExertedByX(allPlanets[i]);
            }
        }
        return netForce;
    } 

    /**Take in an array of Planets and calculate the net Y force exerted by all planets. */
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForce = 0;
        for (int i = 0; i < allPlanets.length; i++) {
            if (!this.equals(allPlanets[i])) {
                netForce += calcForceExertedByY(allPlanets[i]);
            }
        }
        return netForce;
    } 
}