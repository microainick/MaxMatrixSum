import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

  public Node[][] solve_s1(Node[][] nmatrx, Integer[][] imatrx, Matrix theMatrix){
        Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);  // is a column containing 0 freqs of each row
        Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);  // "column frequency" is a row. check it
        for (int a = 0; a < nmatrx.length; a++) {
              if (rowFreq[a] == 1){
                  for (int b = 0; b < nmatrx.length; b++) {
                      if (nmatrx[a][b].getData() == 0) {
                          nmatrx[a][b].set_selected();
                          nmatrx[a][b].set_solution_Data(imatrx[a][b]);
                          for (int c = 0; c < a; c++) {
                              nmatrx[c][b].plusData(10000);
                          } // end for loop c
                          for (int d = (a + 1); d < nmatrx.length; d++) {
                              nmatrx[d][b].plusData(10000);
                          } // end for loop c
                      }  // end inner if
                  }  // end for loop b
              }  //end outer if

        } // end for loop a
    return nmatrx;
  }  //end method

  public Node[][] solve_s2(Node[][] nmatrx, Integer[][] imatrx, Matrix theMatrix){
        Integer[] rowFreq = theMatrix.zeroFreqRowNodev3_select(nmatrx);  // is a column containing 0 freqs of each row
        Integer[] colFreq = theMatrix.zeroFreqColNodev3_select(nmatrx);  // "column frequency" is a row. check it
        for (int a = 0; a < nmatrx.length; a++) {
              if (rowFreq[a] == 1){
                  for (int b = 0; b < nmatrx.length; b++) {
                      if (nmatrx[a][b].getData() == 0) {
                          nmatrx[a][b].set_selected();
                          nmatrx[a][b].set_solution_Data(imatrx[a][b]);
                          for (int c = 0; c < a; c++) {
                              nmatrx[c][b].plusData(10000);
                          } // end for loop c
                          for (int d = (a + 1); d < nmatrx.length; d++) {
                              nmatrx[d][b].plusData(10000);
                          } // end for loop c
                      }  // end inner if
                  }  // end for loop b
              }  //end outer if

        } // end for loop a
    return nmatrx;
  }  //end method

/*
  public Node[][] solve_s3(Node[][] nmatrx, Integer[][] imatrx, Matrix theMatrix){
      Integer[] rowFreq = theMatrix.zeroFreqRowNodev3_select(nmatrx);
      Integer[] colFreq = theMatrix.zeroFreqColNodev3_select(nmatrx);
      for (int a = 0; a < nmatrx.length; a++) {
            if (colFreq[a] == 1)
      } // end for loop a
  } // end method
*/

public int gatherSum(Node[][] nmatrx){
  int myFinalSum = 0;
  for (int i = 0; i < nmatrx.length; i++) {
      for (int j = 0; j < nmatrx.length; j++) {
         if (nmatrx[i][j].get_selected() == true) {
            myFinalSum += nmatrx[i][j].get_solution_Data();
         } //end if
      } // end for loop j
  } // end for loop i
  return myFinalSum;
  } // end method
}  // end class
