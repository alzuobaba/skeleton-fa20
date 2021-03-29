public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }
    public static Body[] readBodies(String fileName){
        In in = new In(fileName);
        int N = in.readInt();
        Body[] bodies = new Body[N];
        double R = in.readDouble();
        int x = 0;
        while (!in.isEmpty()){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            System.out.println("xP:"+ xP);
            String ImgFileName = in.readString();
            Body body = new Body(xP, yP, xV, yV, mass, ImgFileName);
            bodies[x] = body;
            x = x + 1;
            if (x==N)
                break;


        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        for (double times=0;times <= T;times++){

            double[] xForce = new double[bodies.length];
            double[] yForce = new double[bodies.length];
            for (int index=0; index< bodies.length; index++){
                Body b = bodies[index];
                double netx = b.calcNetForceExertedByX(bodies);
                double nety = b.calcNetForceExertedByY(bodies);
                xForce[index] = netx;
                yForce[index] = nety;
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int index=0; index < bodies.length; index++){
                Body body = bodies[index];
                body.update(dt, xForce[index], yForce[index]);
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

        }


    }

}