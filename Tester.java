import java.util.Arrays;

public class Tester
{
    public static void main(String[] args) {
        Point center = new Point(3.0, 4.0);
        Size size = new Size(1.0, 1.0);
        double angle = Math.PI / 4;
        
        RotatedRect rect1 = new RotatedRect(center, size, angle);
        PointedRect rect2 = new PointedRect(rect1);
        
        Point[] points = rect2.points();
        System.out.println(Arrays.toString(points));
    }
}
