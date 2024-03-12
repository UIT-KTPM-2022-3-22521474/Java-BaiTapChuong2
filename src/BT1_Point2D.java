import java.util.Scanner;

class Point2D {
    private double x;
    private double y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(Point2D otherPoint) {
        double dx = this.x - otherPoint.x;
        double dy = this.y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class BT1_Point2D {
    public static void main(String[] args) {
        System.out.println("\nPoint2D - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter coordinates for 1st point: ");
        System.out.print("Enter 1st point's x: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter 1st point's y: ");
        double y1 = scanner.nextDouble();
        Point2D point1 = new Point2D(x1, y1);

        System.out.println("\nEnter coordinates for 2nd point: ");
        System.out.print("Enter 2nd point's x: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter 2nd point's y: ");
        double y2 = scanner.nextDouble();
        Point2D point2 = new Point2D(x2, y2);

        System.out.println("\nEnter coordinates for the movement vector:");
        System.out.print("Enter movement vector's x: ");
        double dx = scanner.nextDouble();
        System.out.print("Enter movement vector's y: ");
        double dy = scanner.nextDouble();

        System.out.println("\nPoint's coordinate before movement:");
        System.out.println("Point 1: " + point1 + ".");
        System.out.println("Point 2: " + point2 + ".");

        point1.move(dx, dy);
        point2.move(dx, dy);

        System.out.println("\nPoint's coordinate after movement:");
        System.out.println("Point 1: " + point1 + ".");
        System.out.println("Point 2: " + point2 + ".");

        double distance = point1.distanceTo(point2);
        String formattedDistance = String.format("%.4f", distance);
        System.out.println("\nDistance between the two points after movement: " + formattedDistance + ".");
    }
}