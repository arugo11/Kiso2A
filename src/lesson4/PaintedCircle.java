public class PaintedCircle implements Circle,Painted{
    double r = 1.0;
    public void setR(double r)
    {
        this.r = r;
    }
    public double getArea()
    {
        return r * r * 3.14;
    }
    public boolean isFilled()
    {
        return true;
    }
    public static void main(String[] args)
    {
        PaintedCircle pc = new PaintedCircle();
        pc.setR(10.0);
        System.out.println(pc.getArea());
    }
}