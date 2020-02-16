import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

//ought not forget how to label 2-d array now.

//sales[0,0], sales[0,1], sales[0,2], sales[0,3], sales[0,4]
//sales[1,0], sales[1,1], sales[1,2], sales[1,3], sales[1,4]
//sales[2,0], sales[2,1], sales[2,2], sales[2,3], sales[2,4]

public class Process {

  public Node[][] proIterate(Node[][] nmatrx, Solver theSolver, Matrix theMatrix, Show theShow) {
      Scanner s = new Scanner(System.in);
      theShow.DisplayCrossNodeM(nmatrx);
      System.out.println("\n\nPress any key and then Press Enter to Continue");
      s.next();
      System.out.println("End");
      theSolver.cross_cross(nmatrx, theMatrix, theShow);
      System.out.println("\nbelow is get num lines node m (<15)\n");
      System.out.println(theMatrix.getNumLinesNode(nmatrx));
      if (theMatrix.getNumLinesNode(nmatrx) < 15) {
          int myVar_2dArrayMinVal = theMatrix.get2dNodeArrayMinv2(nmatrx);
          System.out.println("\nbelow is get 2-d node array min v2 (>0)\n");
          System.out.println(myVar_2dArrayMinVal);
          if (myVar_2dArrayMinVal > 0){
              theMatrix.restore(nmatrx);
              theShow.DisplayCrossNodeM(nmatrx);
              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");
              theMatrix.subMinValNodev2(nmatrx);
              theShow.DisplayCrossNodeM(nmatrx);
              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("Reset Matrix bools.");
              theMatrix.resetNodeM(nmatrx);
              theShow.DisplayCrossNodeM(nmatrx);
              theShow.DisplayCrossedNodeMwithZeroFreqs(nmatrx, theMatrix);
              System.out.println("after reset.  All bools false. none crossed.");
          } //end inner if
      } // end outer if (1st)
    return nmatrx;
} // end method


  public Node[][] proIterate2(Node[][] nmatrx, Solver theSolver, Matrix theMatrix, Show theShow) {
      Scanner s = new Scanner(System.in);
      theShow.DisplayCrossNodeM(nmatrx);
      System.out.println("\n\nPress any key and then Press Enter to Continue");
      s.next();
      System.out.println("End");
      theSolver.cross_cross_v2(nmatrx, theMatrix, theShow);
      theSolver.cross_cross_v2_follow(nmatrx, theMatrix, theShow);
      System.out.println("\nbelow is get num lines node m (<15)\n");
      System.out.println(theMatrix.getNumLinesNode(nmatrx));
      if (theMatrix.getNumLinesNode(nmatrx) < 15) {
          int myVar_2dArrayMinVal = theMatrix.get2dNodeArrayMinv2(nmatrx);
          System.out.println("\nbelow is get 2-d node array min v2 (>0)\n");
          System.out.println(myVar_2dArrayMinVal);
          if (myVar_2dArrayMinVal > 0){
              theMatrix.restore(nmatrx);
              theShow.DisplayCrossNodeM(nmatrx);
              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");
              theMatrix.subMinValNodev2(nmatrx);
              theShow.DisplayCrossNodeM(nmatrx);
              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("Reset Matrix bools.");
              theMatrix.resetNodeM(nmatrx);
              theShow.DisplayCrossNodeM(nmatrx);
              theShow.DisplayCrossedNodeMwithZeroFreqs(nmatrx, theMatrix);
              System.out.println("after reset.  All bools false. none crossed.");
          } //end inner if
      } // end outer if (1st)
    return nmatrx;
  } // end method

} // end class
