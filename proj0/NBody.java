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
        Body[] Bodys = new Body[N];
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
            Bodys[x] = body;
            x = x + 1;
            if (x==N)
                break;


        }
        return Bodys;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
    }

}