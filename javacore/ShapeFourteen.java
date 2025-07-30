package practice1;


class ShapeQNO14 {

    // Area for square
    public double area(double side) {
        return side * side;
    }

    // Area for rectangle
    public double area(double length, double breadth) {
        return length * breadth;
    }

    // Perimeter for square
    public double perimeter(double side) {
        return 4 * side;
    }

    // Perimeter for rectangle
    public double perimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }
}

public class ShapeFourteen{

    public static void main(String[] args) {
        ShapeQNO14 shape = new ShapeQNO14();

        // Square
        double squareSide = 5;
        System.out.println("Square Side: " + squareSide);
        System.out.println("Square Area: " + shape.area(squareSide));
        System.out.println("Square Perimeter: " + shape.perimeter(squareSide));

        System.out.println();

        // Rectangle
        double length = 8;
        double breadth = 4;
        System.out.println("Rectangle Length: " + length + ", Breadth: " + breadth);
        System.out.println("Rectangle Area: " + shape.area(length, breadth));
        System.out.println("Rectangle Perimeter: " + shape.perimeter(length, breadth));
    }
}
/*Square Side: 5.0
Square Area: 25.0
Square Perimeter: 20.0

Rectangle Length: 8.0, Breadth: 4.0
Rectangle Area: 32.0
Rectangle Perimeter: 24.0
*/