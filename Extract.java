import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Extract extends Show {
    public void answer(Node[][] nmatrx, Integer[][] imatrx) {
      System.out.print("\t Collumn #\t");
      for (int h = 0; h < nmatrx.length; h++){
        //System.out.print(" ");
        System.out.printf("%4d", h);
        System.out.print("  ");
      } //end for h
      System.out.println("\n\n\tRow #\t");
      for (int i = 0; i < nmatrx.length; i++) {
        System.out.printf("\t %3d", i);
        System.out.print("\t\t");
            for (int j = 0; j < nmatrx[i].length; j++) {
                if (nmatrx[i][j].get_selected() == true) {
                    System.out.printf(ANSI_GREEN + "%5d " + ANSI_RESET, imatrx[i][j]);
                } // end if
                else {
                    System.out.printf("%5d ", imatrx[i][j]);
                } // end else
          } // end for j
          System.out.println("\n");
      } //end for i
  } // end method

} // end class
