public class Main {

    public static void main(String[] args)
    {
        Circle innerCircle = new Circle(1,10);
        Circle middleCircle = new Circle(5,5);
        Circle outerCircle = new Circle(10,1);

        Board board = new Board(innerCircle,middleCircle,outerCircle);

        Dart dartCoordinates = new Dart(0.75, 0.5);

        Double pointsEarned = board.throwDart(dartCoordinates);

        if (pointsEarned == -1)
        {
            System.out.println("Invalid Dart Coordinates");
        }
        else if (pointsEarned == -2)
        {
            System.out.println("Dart is outside the target. 0 Points");
        }
        else
        {
            System.out.println("Points Earned = " + pointsEarned);
        }

    }
}
