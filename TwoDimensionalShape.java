public abstract class TwoDimensionalShape extends Shape {
    public abstract double getArea();
    public abstract double getCircumference();
    public void showDetail(){
        System.out.println(toString());
    }
}