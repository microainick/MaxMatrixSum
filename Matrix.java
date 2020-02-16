import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Matrix {

    //Scanner s = new Scanner(System.in);

    // this function creates two new arrays. The first array gets filled with all values in the first row
// then we call collections.frequency on that array of first row elements, this value is the first element in the 2nd array
//repeat this 15 time with loop and then our 2nd array is an array of the frequency of zeros by row by index
//so 1st element(0th) is number of zeros in first row(0th row), 2nd is # of zeros in 2n row and so
    public Integer[] zeroFreqRowNode(Node[][] nmatrx) {
        int val = nmatrx.length;
        Integer[] rowZeroFreqArray = new Integer[val];
        Integer[] temp_array2 = new Integer[val];
        for (int row = 0; row < val; row++) {
          for (int i = 0; i < val; i++) {
            temp_array2[i] = nmatrx[row][i].getData();
          }  // end for loop i
          rowZeroFreqArray[row] = Collections.frequency(Arrays.asList(temp_array2), 0);
        } // end for loop row
        return rowZeroFreqArray;
    } // end method

    public Integer[] zeroFreqColNode(Node[][] nmatrx) {
      int val = nmatrx.length;
      Integer[] colZeroFreqArray = new Integer[val];
      Integer[] temp_array3 = new Integer[val];
      for (int col = 0; col < val; col++) {
        for (int i = 0; i < val; i++) {
          temp_array3[i] = nmatrx[i][col].getData();
        } // end for loop i
        colZeroFreqArray[col] = Collections.frequency(Arrays.asList(temp_array3), 0);
      } // end for loop col
      return colZeroFreqArray;
    } // end method

    public Integer[] zeroFreqRowNodev2(Node[][] nmatrx) {
        int val = nmatrx.length;
        Integer[] rowZeroFreqArray = new Integer[val];
        Integer[] temp_array2 = new Integer[val];
        for (int row = 0; row < val; row++) {
          for (int i = 0; i < val; i++) {
              if (nmatrx[row][i].getG_cross() == false) {
                temp_array2[i] = nmatrx[row][i].getData();
              }
              else {
                temp_array2[i] = 999;
              }
          }  // end for loop i
          rowZeroFreqArray[row] = Collections.frequency(Arrays.asList(temp_array2), 0);
        } // end for loop row
        return rowZeroFreqArray;
    } // end method

    public Integer[] zeroFreqColNodev2(Node[][] nmatrx) {
      int val = nmatrx.length;
      Integer[] colZeroFreqArray = new Integer[val];
      Integer[] temp_array3 = new Integer[val];
      for (int col = 0; col < val; col++) {
        for (int i = 0; i < val; i++) {
            if (nmatrx[i][col].getG_cross() == false) {
                temp_array3[i] = nmatrx[i][col].getData();
            }
            else {
                temp_array3[i] = 999;
            }
        } // end for loop i
        colZeroFreqArray[col] = Collections.frequency(Arrays.asList(temp_array3), 0);
      } // end for loop col
      return colZeroFreqArray;
    } // end method

    public Integer[] zeroFreqRowNodev3_select(Node[][] nmatrx) {
        int val = nmatrx.length;
        Integer[] rowZeroFreqArray = new Integer[val];
        Integer[] temp_array2 = new Integer[val];
        for (int row = 0; row < val; row++) {
          for (int i = 0; i < val; i++) {
              if (nmatrx[row][i].get_selected() == false) {
                temp_array2[i] = nmatrx[row][i].getData();
              }
              else {
                temp_array2[i] = 999;
              }
          }  // end for loop i
          rowZeroFreqArray[row] = Collections.frequency(Arrays.asList(temp_array2), 0);
        } // end for loop row
        return rowZeroFreqArray;
    } // end method

    public Integer[] zeroFreqColNodev3_select(Node[][] nmatrx) {
      int val = nmatrx.length;
      Integer[] colZeroFreqArray = new Integer[val];
      Integer[] temp_array3 = new Integer[val];
      for (int col = 0; col < val; col++) {
        for (int i = 0; i < val; i++) {
            if (nmatrx[i][col].get_selected() == false) {
                temp_array3[i] = nmatrx[i][col].getData();
            }
            else {
                temp_array3[i] = 999;
            }
        } // end for loop i
        colZeroFreqArray[col] = Collections.frequency(Arrays.asList(temp_array3), 0);
      } // end for loop col
      return colZeroFreqArray;
    } // end method


    public int getHighestZeroFreqIndex(Integer[] array) {
        int most = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[most]) {
                most = i;
            }  // end if
        } // end for loop i
        return most; // position of the row or collumn with the most zeros
    }


//make get one-zero frequency and cross opposite horz->vert

    public int getHighestZeroFreqIndex_right2left(Integer[] array) {
        int most = (array.length);
        for (int i = ((array.length) - 1); i > -1; i--) {
            if (array[i] > array[most]) {
                most = i;
            }  // end if
        } // end for loop i
        return most; // position of the row or collumn with the most zeros
    }

// returns int conatining # of un crossed.
    public int evalZerosNodeM(Node[][] nMatrx) {
        //this.populate(nMatrx, cMatrx);
        int mySum = 0;
        for (int g = 0; g < nMatrx.length; g++) {
            for (int h = 0; h < nMatrx.length; h++) {
                if (nMatrx[g][h].getV_cross() == true) {
                    nMatrx[g][h].plusData(10000);
                }
                if (nMatrx[g][h].getH_cross() == true) {
                    nMatrx[g][h].plusData(10000);
                }
            } //end for loop h
        } // end for loop g
        Integer[] rowFreq = this.zeroFreqRowNode(nMatrx);
        for (int i = 0; i < nMatrx.length; i++) {
          mySum+=(rowFreq[i]);
        }  // end for loop i
        System.out.println("the sum of zeros remaining which are un-crossed:  ");
        System.out.println(mySum);
        return mySum;
    }

    public Integer get2dNodeArrayMin(Node[][] matrx) {
        int val = matrx.length;
        Integer[] temp_NarrayRo = new Integer[val];
        Integer[] minRval_Narray = new Integer[val];
        Integer[] temp_NarrayCo = new Integer[val];
        Integer[] minCval_Narray = new Integer[val];
        for (int h = 0; h < val; h ++) {
          for (int i = 0; i < val; i++) {
            if (matrx[i][h].getH_cross() == false && matrx[i][h].getV_cross() == false) {
                temp_NarrayCo[i] = matrx[i][h].getData();
            }else{
              temp_NarrayCo[i] = 999;
            } //end else 1
            if (matrx[h][i].getH_cross() == false && matrx[h][i].getV_cross() == false) {
                temp_NarrayRo[i] = matrx[h][i].getData();
            }else{
              temp_NarrayRo[i] = 999;
            } //end else 2
          }//end for loop i
          minCval_Narray[h] = Collections.min(Arrays.asList(temp_NarrayCo));
          minRval_Narray[h] = Collections.min(Arrays.asList(temp_NarrayRo));
        }// end for loop h
        Integer min2dValC = Collections.min(Arrays.asList(minCval_Narray));
        Integer min2dValR = Collections.min(Arrays.asList(minRval_Narray));
        System.out.print("\n2d Node array min val (Uncrossed):  ");
        System.out.println(min2dValR);
        System.out.println(min2dValC);
        System.out.print("\n");
        return min2dValC;
    }

// new variable val = to size of Matrix
// create 4 new arrays with size val
// 2 for loops from 0 to val. one embedded
    public Integer get2dNodeArrayMinv2(Node[][] matrx) {
        int val = matrx.length;
        Integer[] temp_NarrayRo = new Integer[val];
        Integer[] minRval_Narray = new Integer[val];
        Integer[] temp_NarrayCo = new Integer[val];
        Integer[] minCval_Narray = new Integer[val];
        for (int h = 0; h < val; h ++) {
          for (int i = 0; i < val; i++) {
            if (matrx[i][h].getG_cross() == false) {
                temp_NarrayCo[i] = matrx[i][h].getData();
            }else{
              temp_NarrayCo[i] = 999;
            } //end else 1
            if (matrx[h][i].getG_cross() == false) {
                temp_NarrayRo[i] = matrx[h][i].getData();
            }else{
              temp_NarrayRo[i] = 999;
            } //end else 2
          }//end for loop i
          minCval_Narray[h] = Collections.min(Arrays.asList(temp_NarrayCo));
          minRval_Narray[h] = Collections.min(Arrays.asList(temp_NarrayRo));
        }// end for loop h
        Integer min2dValC = Collections.min(Arrays.asList(minCval_Narray));
        Integer min2dValR = Collections.min(Arrays.asList(minRval_Narray));
        System.out.print("\n2d Node array min val (Uncrossed):  ");
        System.out.println(min2dValR);
        System.out.println("Processed through rows (above) should match process by collumn (below)");
        System.out.println(min2dValC);
        System.out.print("\n");
        return min2dValC;
    }

//

    public int getNumLinesNode(Node[][] nmatrx) {
        int mySum = 0;
        for (int i = 0; i < nmatrx.length; i++) {
            if (nmatrx[0][i].getV_cross() == true) {
                mySum+=1;
            } //end if 1
            if (nmatrx[i][0].getH_cross() == true) {
                mySum+=1;
            } // end if 2
        } //end for loop i
//newly added if to adjust the number based on array element 0,0 repeating
//        if (nmatrx[0][0].getV_cross() == true && nmatrx[0][0].getV_cross() == true) {
//              mySum-=1;
//        }
//newly added

        System.out.println(mySum);
        return mySum;
    } //end method

    public Node[][] subMinValNode(Node[][] nmatrx) {
      Integer minVal = this.get2dNodeArrayMin(nmatrx);
      System.out.println(minVal);
      Integer minValNeg = minVal*(-1);
      System.out.println(minValNeg);
      for (int i = 0; i < nmatrx.length; i++) {
          for (int j = 0; j < nmatrx.length; j++) {
              if (nmatrx[i][j].getH_cross() == false) {
                  nmatrx[i][j].plusData(minValNeg);
              } //end if 1
              if (nmatrx[i][j].getV_cross() == true) {
                  nmatrx[i][j].plusData(minVal);
              } //end if 2
          } //end for loop j
        } //end for loop i
        return nmatrx;
    } // end method

    public Node[][] subMinValNodev2(Node[][] nmatrx) {
      Integer minVal = this.get2dNodeArrayMinv2(nmatrx);
      System.out.println(minVal);
      Integer minValNeg = minVal*(-1);
      System.out.println("minVal:  If getH_cross() == false:   subtract.");
      System.out.println("minVal:  If getV_cross() == true:   add.");
      System.out.println(minValNeg);
      for (int i = 0; i < nmatrx.length; i++) {
          for (int j = 0; j < nmatrx.length; j++) {
              if (nmatrx[i][j].getH_cross() == false) {
                  nmatrx[i][j].plusData(minValNeg);
              } //end if 1
              if (nmatrx[i][j].getV_cross() == true) {
                  nmatrx[i][j].plusData(minVal);
              } //end if 2
          } //end for loop j
        } //end for loop i
        return nmatrx;
    } // end method

    public Node[][] restore(Node[][] nmatrx) {
      for (int i = 0; i < nmatrx.length; i++) {
          for (int j = 0; j < nmatrx.length; j++) {  ////////////////this restores the correct value2435%1000=435
              Integer var = (nmatrx[i][j].getData())%10000;
              nmatrx[i][j].setData(var);
          } //end j
      } //end i
      return nmatrx;
    } //end method

    public Node[][] resetNodeM(Node[][] nmatrx) {
        for (int i = 0; i < nmatrx.length; i++) {  ///////////  this sets both bools to false
            for (int j = 0; j < nmatrx.length; j++) {
                nmatrx[i][j].resetNode();  ///where?
            } // end for loop j
        } // end for loop i
      return nmatrx;
    }

    public void finalizeAlgoSteps5n6(Node[][] nmatrx, Show theShow, Solver theSolver, Scanner s, Matrix theMatrix) {
            theSolver.OptimalCross(nmatrx, theMatrix, theShow);
          //while ((theSolver.OptimalCross(nmatrx, theMatrix, theShow)) < 15) {
            //this.iterate1Node(nmatrx); //cross out zeros
            System.out.print("\n\n\nAlgo Step 5 complete\n");
            System.out.println("\n\nAll of the zeros must be crossed out with horizontal or vertical lines.");
            System.out.println("This has to be done in the fewest lines possible.");
            System.out.println("Identify the minimum number of lines required to do so.");
            System.out.println("Then Identify the smallest value in the Matrix, which is not crossed out.");
            System.out.print("\n\nAll zeros crossed out with:  ");
            System.out.print(this.getNumLinesNode(nmatrx));
            System.out.print("  Lines used.\n");
            System.out.print("\n2d Node array Minimum value (Uncrossed):  ");
            System.out.print(this.get2dNodeArrayMin(nmatrx));
            System.out.print("\n");
            theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
            System.out.println("\n\nPress any key and then Press Enter to Continue");
            s.next();

            System.out.print("\n\n\nAlgo Step 6 complete\n");
            System.out.print("\n2d Node array Minimum value (Uncrossed):  ");
            System.out.print(this.get2dNodeArrayMin(nmatrx));
            System.out.println("\nThis Minimum value is subtracted from each element in all uncovered rows.");
            System.out.println("Then added to each element in all covered columns.\n\n");

            this.subMinValNode(nmatrx);
            theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
            this.resetNodeM(nmatrx); //bools to false
            System.out.println("\n\nPress any key and then Press Enter to Continue");
            s.next();
        } // end method

    public void finalizeAlgoSteps5n6no2(Node[][] nmatrx, Show theShow, Solver theSolver, Scanner s, Matrix theMatrix) {
            //theSolver.OptimalCross(nmatrx, theMatrix, theShow);
          while (theSolver.OptimalCross(nmatrx, theMatrix, theShow) < 15) {
            System.out.print("\n\nAll zeros crossed out with:  ");
            System.out.print(this.getNumLinesNode(nmatrx));
            System.out.print("  Lines used.\n");
            System.out.print("\n2d Node array Minimum value (Uncrossed):  ");
            System.out.print(this.get2dNodeArrayMin(nmatrx));
            System.out.print("\n");

            theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
            System.out.println("\n\nPress any key and then Press Enter to Continue");
            s.next();

            this.subMinValNode(nmatrx);
            theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
            this.resetNodeM(nmatrx);
            System.out.println("\n\nPress any key and then Press Enter to Continue");
            s.next();

        } // end while loop
    }//end method
  } //end class
