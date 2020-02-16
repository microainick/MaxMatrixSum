import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Begin {

  // this function uses the size of the first argument oldMatrx
  //no i in matrx.   naming convention used for variable name of input paramater args
  //   this naming convention is consistant throughout
    public void negPopulate(Integer[][] oldMatrx, Integer[][] newMatrx, Show theShow, Scanner s) {
        //Scanner s = new Scanner(System.in);
        int val = oldMatrx.length;
        for (int i = 0; i < val; i++) {
          for (int j = 0; j < val; j++) {
              newMatrx[i][j] = (oldMatrx[i][j])*(-1);
          }//end for loop j
        }//end for loop i
        System.out.println("\n");
        System.out.println("\n\nAlgo Step 1 complete");
        System.out.println("Multiply all Matrix elements by negative one.\n");
        theShow.DisplayM(newMatrx);
        System.out.println("\n\n\nPress any key and then Press Enter to Continue");
        s.next();
    }

    public void rowReduce(Integer[][] matrx, Integer[][] matrx2, Show theShow, Scanner s){
      int val = matrx.length;
      Integer[] num = new Integer[val];
      for (int row = 0; row < val; row++) {
        for (int i = 0; i < val; i++) {
          num[i] = matrx[row][i]; }//end for loop i
        int minVal = Collections.min(Arrays.asList(num));
        //return minVal;
        for (int j = 0; j < val; j++) {
          matrx2[row][j] = (matrx[row][j] - (minVal));
        }//end nested for loop (j)
      }// end for loop row
      System.out.println("\n");
      System.out.println("\n\nAlgo Step 2 complete");
      System.out.println("Smallest Value from each row has been identified");
      System.out.println("This value has been subtracted from all elements in the corresponding row.\n");

      theShow.DisplayM(matrx2);
      System.out.println("\n\n\nPress any key and then Press Enter to Continue");
      s.next();
    }//  end method

    public void ColReduce(Integer[][] matrx, Integer[][] matrx2, Show theShow, Scanner s){
        int val = matrx.length;
        Integer[] temp_array = new Integer[val];
        for (int col = 0; col < val; col ++) {
          for (int i = 0; i < val; i++) {
            temp_array[i] = matrx[i][col];
          }//end for loop i
          int minCval = Collections.min(Arrays.asList(temp_array));
          for (int j = 0; j < val; j++) {
            matrx2[j][col] = (matrx[j][col] - (minCval));
          }  //end for loop j
        } // end for loop col
        System.out.println("\n\n\n\nAlgo Step 3 complete");
        System.out.println("Smallest Value from each column has been identified");
        System.out.println("This value has been subtracted from all elements in the corresponding column.\n");
        theShow.DisplayM(matrx2);
        System.out.println("\n\n\nPress any key and then Press Enter to Continue");
        s.next();
    }//end method

    public Node[][] prodNodeMatrix(Integer[][] matrx, Node[][] nmatrx) {
      for(int i = 0; i < 15; i++) {
        for(int j = 0; j < 15; j++) {
            Integer val = matrx[i][j];
            nmatrx[i][j] = new Node(val);
        } //end for loop j
      } // end for loop i
      return nmatrx;
    }  // end method

}// end class
