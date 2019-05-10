public class Board  {
     Circle innerCircle;
     Circle middleCircle;
     Circle outerCircle;
     private double boardXcoordinate=0;
     private double boardYcoordiante=0;
     private double dartLocation;
     private double deltaX, deltaY;
     private double score;

     Board(Circle innerCircle, Circle middleCircle, Circle outerCircle)
     {
         this.innerCircle=innerCircle;
         this.middleCircle=middleCircle;
         this.outerCircle=outerCircle;
     }

     public double throwDart(Dart dart) {
         if ((dart.getdartXCoordinate() < boardXcoordinate) || (dart.getDartYcoordinate() < boardYcoordiante)) {
             return -1;
         } else {
             dartLocation = calculateDartDistanceFromCenter(dart.getdartXCoordinate(), dart.getDartYcoordinate());

             if (dartLocation > outerCircle.getRadius()) {
                 return -2;
             } else {
                 score = calculateScore(dartLocation);
                 return score;
             }
         }


     }


    private double calculateDartDistanceFromCenter(double dartXcoordinate, double dartYcoordinate)
    {

        deltaX = (dartXcoordinate - boardXcoordinate);
        System.out.println(deltaX);
        deltaY = (dartYcoordinate - boardYcoordiante);
        System.out.println(deltaY);
        dartLocation = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
        System.out.println(dartLocation);
        return dartLocation;
    }



    private double calculateScore(double dartLocation)
    {

        if ((dartLocation >= 0) && (dartLocation <= innerCircle.getRadius()))
        {
            System.out.println("Dart is inside the inner circle.");
            return innerCircle.getScore();
        }
        else if
        ((dartLocation > innerCircle.getRadius()) && (dartLocation <= middleCircle.getRadius()))
        {
            System.out.println("Dart is inside the middle circle.");
            return middleCircle.getScore();
        }
        else
        {
            System.out.println("Dart is inside the outer circle.");
            return outerCircle.getScore();
        }

    }


}
