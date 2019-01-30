/**
 * PointedRect is a RotatedRect with additional fields for vertices.
 */
public class PointedRect extends RotatedRect
{
    private Point[] vertices;
    
    public PointedRect(RotatedRect rect) {
        super(rect.center, rect.size, rect.angle);
        
        this.setAtOrigin();
        this.rotate();
        this.translate();
    }
    
    private void setAtOrigin() {
        Point bottomLeft = new Point(-1.0 * size.width / 2, -1.0 * size.height / 2);
        Point topLeft = new Point(-1.0 * size.width / 2, size.height / 2);
        Point topRight = new Point(size.width / 2, size.height / 2);
        Point bottomRight = new Point(size.width / 2, -1.0 * size.height / 2);
        
        vertices = new Point[] {bottomLeft, topLeft, topRight, bottomRight};
    }    
  
    private void rotate() {
       // https://en.wikipedia.org/wiki/Rotation_matrix#In_two_dimensions
       
       for (Point p: vertices) {
           double xPrime = p.x * Math.cos(angle) - p.y * Math.sin(angle);
           double yPrime = p.x * Math.sin(angle) + p.y * Math.cos(angle);
           
           p.x = xPrime;
           p.y = yPrime;
       }
    }
    
    private void translate() {
        for (Point p: vertices) {
            p.x += center.x;
            p.y += center.y;
        }
    }
    
    public Point[] points() {
        return vertices;
    }
}
