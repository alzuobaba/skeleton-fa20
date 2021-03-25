public class Body {
//    double xxPos: Its current x position
//    double yyPos: Its current y position
//    double xxVel: Its current velocity in the x direction
//    double yyVel: Its current velocity in the y direction
//    double mass: Its mass
//    String imgFileName: The name of the file that corresponds to
//            the image that depicts the body
//            (for example, jupiter.gif)
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt(Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2));
    }
    public double calcForceExertedBy(Body b){
        if (this.equals(b)){
            return 0;
        }
        return 6.67E-11* this.mass * b.mass/Math.pow(this.calcDistance(b), 2);
    }
    public double calcForceExertedByX(Body b){
        return (b.xxPos - this.xxPos) * this.calcForceExertedBy(b)/this.calcDistance(b);
    }
    public double calcForceExertedByY(Body b){
        return (b.yyPos - this.yyPos) * this.calcForceExertedBy(b)/this.calcDistance(b);
    }
    public double calcNetForceExertedByX(Body[] allBodys ){
        double sum  = 0;
        for (int i=0; i < allBodys.length; i++){
            if (this.equals(allBodys[i])){
                continue;
            }
            sum += this.calcForceExertedByX(allBodys[i]);
        }
        return sum;
    }
    public double calcNetForceExertedByY(Body[] allBodys ){
        double sum  = 0;
        for (int i=0; i < allBodys.length; i++){
            if (this.equals(allBodys[i])){
                continue;
            }
            sum += this.calcForceExertedByY(allBodys[i]);
        }
        return sum;
    }
    public void update(double dt, double fX, double fY){
        double ax, ay;
        ax = fX/this.mass;
        ay = fY/this.mass;
        this.xxVel = this.xxVel + dt* ax;
        this.yyVel = this.yyVel + dt* ay;
        this.xxPos = this.xxPos + dt *this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }
}
