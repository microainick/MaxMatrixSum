import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Solver {

    private Integer[][] oGpmatrix;
    private Integer[][] oGmatrix;
    private Integer[][] newoGmatrix;
    private Integer[][] newTwoGmatrix;
    private Node[][] nodeMatrix;
    private Node[][] solutionNodeMatrix;

    public Solver() {
            oGpmatrix = new Integer[][]{{  7,  53, 183, 439, 863, 497, 383, 563,  79, 973, 287,  63, 343, 169, 583},
                                        {627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583, 639, 913},
                                        {447, 283, 463,  29,  23, 487, 463, 993, 119, 883, 327, 493, 423, 159, 743},
                                        {217, 623,   3, 399, 853, 407, 103, 983,  89, 463, 290, 516, 212, 462, 350},
                                        {960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172, 812, 350},
                                        {870, 456, 192, 162, 593, 473, 915,  45, 989, 873, 823, 965, 425, 329, 803},
                                        {973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165, 992, 326},
                                        {322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601,  95, 973},
                                        {445, 721,  11, 525, 473,  65, 511, 164, 138, 672,  18, 428, 154, 448, 848},
                                        {414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430, 392, 198},
                                        {184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284, 760, 390},
                                        {821, 461, 843, 513,  17, 901, 711, 993, 293, 157, 274,  94, 192, 156, 574},
                                        { 34, 124,   4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823, 329, 699},
                                        {815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251, 631, 107},
                                        {813, 883, 451, 509, 615,  77, 281, 613, 459, 205, 380, 274, 302,  35, 805}};

            oGmatrix = new Integer[15][15];
            newoGmatrix = new Integer[15][15];
            newTwoGmatrix = new Integer[15][15];
            nodeMatrix = new Node[15][15];
            solutionNodeMatrix = new Node[15][15];
    } // end constructor

//this is one direction to take for an iteration not the greedy algo.
    public Node[][] iterate1Node(Node[][] nmatrx, Matrix theMatrix, Show theShow) {
      while (theMatrix.evalZerosNodeM(nmatrx) > 0) {
          //theMatrix.restore(nmatrx);
          Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);   // make array of zero freqs by row printed left
          Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);
          int acVal = Collections.max(Arrays.asList(colFreq));  // highest zero frequency in any column
          int arVal = Collections.max(Arrays.asList(rowFreq));  // highest zero frequency in any row
          int cVal = theMatrix.getHighestZeroFreqIndex(colFreq);
          int rVal = theMatrix.getHighestZeroFreqIndex(rowFreq);
          if (acVal > arVal) {
            for (int i = 0; i < nmatrx.length; i++) {
              nmatrx[i][cVal].setV_cross();
            } // end for loop i
          }else {
            //this else here dismisses equality bc I think I will negate it for now
            //if the collumns and rows both have the same # I will always cross out rows first
            for (int j = 0; j < nmatrx.length; j++) {
              nmatrx[rVal][j].setH_cross();
            } // end for loop j
          } // end else
          theShow.DisplayNodeMboolV(nmatrx);
          theShow.DisplayNodeMboolH(nmatrx);
          theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
          System.out.println(theMatrix.evalZerosNodeM(nmatrx));
      } // end while loop
      theMatrix.restore(nmatrx);
      System.out.println("iterate1Node has finished!");
      return nmatrx;
    } // end method

    public Node[][] iterate2Node(Node[][] nmatrx, Matrix theMatrix, Show theShow) {
        while (theMatrix.evalZerosNodeM(nmatrx) > 0) {
            Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);   // make array of zero freqs by row printed left
            Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);
            int acVal = Collections.max(Arrays.asList(colFreq));  // highest zero frequency in any column
            int arVal = Collections.max(Arrays.asList(rowFreq));  // highest zero frequency in any row
            int cVal = theMatrix.getHighestZeroFreqIndex(colFreq);
            int rVal = theMatrix.getHighestZeroFreqIndex(rowFreq);
            if (acVal < arVal) {
              for (int i = 0; i < nmatrx.length; i++) {
                nmatrx[rVal][i].setH_cross();
              } // end for loop i
            }else {
              //this else here dismisses equality bc I think I will negate it for now
              //if the collumns and rows both have the same # I will always cross out rows first
              //version 2 of this method will break ties with columns first
              for (int j = 0; j < nmatrx.length; j++) {
                nmatrx[j][cVal].setV_cross();
              } // end for loop j
            } // end else
            theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
        } // end while loop
        theMatrix.restore(nmatrx);
        System.out.println("iterate2Node has finished!");
        return nmatrx;
    } // end method

//dr.cross method

    public Node[][] cross_cross(Node[][] nmatrx, Matrix theMatrix, Show theShow) {
      // this is while the matrix still has zeros uncrossed
      //while (theMatrix.evalZerosNodeM(nmatrx) > 0) {
          //theMatrix.restore(nmatrx);
          //theShow.DisplayNodeMwithZeroFreqs(nmatrx, theMatrix);
          Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);   // make array of zero freqs by row printed left
          Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);
          //cycle throught these two arrays and look for 1's
          //theShow.DisplayNodeMwithZeroFreqs(nmatrx, theMatrix);
          //theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);

// **** new code
          //
          for (int a = 0; a < nmatrx.length; a++) {
              if (rowFreq[a] == 1) {
                    for (int b = 0; b < nmatrx.length; b++) {
                          if (nmatrx[a][b].getData() == 0 && colFreq[b] != 1) {
                                for (int c = 0; c < nmatrx.length; c++) {
                                      nmatrx[c][b].setV_cross();
                                      //nmatrx[b][c].plusData(10000);
                                } // end for loop c
                          } // end inner if
                    } //end for (b)
              } // end outter if
          } //end for (a)

          for (int d = 0; d < nmatrx.length; d++) {
              if (colFreq[d] == 1) {
                    for (int e = 0; e < nmatrx.length; e++) {
                          if (nmatrx[e][d].getData() == 0) {
                                for (int f = 0; f < nmatrx.length; f++) {
                                        nmatrx[e][f].setH_cross();
                                } // end for loop (f)
                          } // end 2nd inner if
                    }// end for loop (e)
                } //end 2nd outter if
          } //end for loop (d)

          Integer[] rowFreq2 = theMatrix.zeroFreqRowNodev2(nmatrx);   // make array of zero freqs by row printed left
          //Integer[] colFreq2 = theMatrix.zeroFreqColNodev2(nmatrx);
          for (int g = 0; g < nmatrx.length; g++) {
                if (rowFreq2[g] > 0) {
                      for (int h = 0; h < nmatrx.length; h++) {
                            nmatrx[g][h].setH_cross();
                      }
                }
          }
// **** new code


          //theShow.DisplayNodeMwithZeroFreqs(nmatrx, theMatrix);
          //theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);


// get num lines node

          //theShow.DisplayNodeMboolV(nmatrx);
          //theShow.DisplayNodeMboolH(nmatrx);
          //theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
          System.out.println(theMatrix.evalZerosNodeM(nmatrx));
   // } // end while loop
      //theMatrix.restore(nmatrx);
      System.out.println("iterate Node with Cross_cross has finished!");
      return nmatrx;
} // end method



    public Node[][] cross_cross_v2(Node[][] nmatrx, Matrix theMatrix, Show theShow) {
      // this is while the matrix still has zeros uncrossed
      //while (theMatrix.evalZerosNodeM(nmatrx) > 0) {
          //theMatrix.restore(nmatrx);
          //theShow.DisplayNodeMwithZeroFreqs(nmatrx, theMatrix);
          Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);   // make array of zero freqs by row printed left
          Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);
          //cycle throught these two arrays and look for 1's
          //theShow.DisplayNodeMwithZeroFreqs(nmatrx, theMatrix);
          //theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);

// **** new code
          //
          for (int a = 0; a < nmatrx.length; a++) {
              if (rowFreq[a] == 1) {
                    for (int b = 0; b < nmatrx.length; b++) {
                          if (nmatrx[a][b].getData() == 0 && colFreq[b] != 1) {
                                for (int c = 0; c < nmatrx.length; c++) {
                                      nmatrx[c][b].setV_cross();
                                      //nmatrx[b][c].plusData(10000);
                                } // end for loop c
                          } // end inner if
                    } //end for (b)
              } // end outter if
          } //end for (a)

          for (int d = 0; d < nmatrx.length; d++) {
              if (colFreq[d] == 1) {
                    for (int e = 0; e < nmatrx.length; e++) {
                          if (nmatrx[e][d].getData() == 0 && rowFreq[e] != 1) {
                                for (int f = 0; f < nmatrx.length; f++) {
                                        nmatrx[e][f].setH_cross();
                                } // end for loop (f)
                          } // end 2nd inner if
                    }// end for loop (e)
                } //end 2nd outter if
          } //end for loop (d)

          Integer[] rowFreq2 = theMatrix.zeroFreqRowNodev2(nmatrx);   // make array of zero freqs by row printed left

          //Integer[] colFreq2 = theMatrix.zeroFreqColNodev2(nmatrx);
          for (int g = 0; g < nmatrx.length; g++) {
                if (rowFreq2[g] > 1) {
                      for (int h = 0; h < nmatrx.length; h++) {
                            nmatrx[g][h].setH_cross();
                      }
                }
          }
          Integer[] colFreq2 = theMatrix.zeroFreqColNodev2(nmatrx);
          for (int z = 0; z < nmatrx.length; z++) {
                if (colFreq2[z] > 1) {
                    for (int y = 0; y < nmatrx.length; y++) {
                            nmatrx[y][z].setV_cross();
                    }
                }
          }

// **** new code


          //theShow.DisplayNodeMwithZeroFreqs(nmatrx, theMatrix);
          //theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);


// get num lines node

          //theShow.DisplayNodeMboolV(nmatrx);
          //theShow.DisplayNodeMboolH(nmatrx);
          //theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
          System.out.println(theMatrix.evalZerosNodeM(nmatrx));
   // } // end while loop
      //theMatrix.restore(nmatrx);
      System.out.println("iterate Node with Cross_cross has finished!");
      return nmatrx;
      } // end method


    public Node[][] cross_cross_v2_follow(Node[][] nmatrx, Matrix theMatrix, Show theShow) {
      theShow.DisplayCrossNodeM(nmatrx);
      Integer[] rowFreq3 = theMatrix.zeroFreqRowNode(nmatrx);
      Integer[] colFreq3 = theMatrix.zeroFreqColNode(nmatrx);

      for (int x = 0; x < nmatrx.length; x++) {
          if (rowFreq3[x] > 0) {
              for (int w = 0; w < nmatrx.length; w++) {
                  nmatrx[x][w].setH_cross();
              }  // end for loop w
          }  // end if
      } // end for loop x
      theShow.DisplayCrossNodeM(nmatrx);
      return nmatrx;
    }  // end method



    public Node[][] cross_lines_optimal2(Node[][] nmatrx, Matrix theMatrix, Solver theSolver, Show theShow, Scanner s) {
        //while (theMatrix.evalZerosNodeM(nmatrx) > 0) {
          theMatrix.restore(nmatrx); //%1000
          Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);   // make array of zero freqs by row printed left
          Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);
          Integer acVal = Collections.max(Arrays.asList(colFreq));  // highest zero frequency in any column
          Integer arVal = Collections.max(Arrays.asList(rowFreq));  // highest zero frequency in any row
          Integer cVal = theMatrix.getHighestZeroFreqIndex(colFreq);
          Integer rVal = theMatrix.getHighestZeroFreqIndex(rowFreq);
          if (acVal == arVal) {
            System.out.printf("index of highest freq of zeros in any row is:  %d", rowFreq[rVal]);
            System.out.println(" ");
            //get index locations of the zeros in that row and then and check use that index to
            //check the zero freq of corresponding column.   if zerofreq of col is one less
            //of either 2!  then set vals for h_cross to true bc that row is getting crossed out
            for(int i = 0; i < 15; i++) {
              if(colFreq[i] == acVal){
                Integer[] temp_array = new Integer[15];
                for(int a = 0; a < 15; a++){
                  temp_array[a] = nmatrx[a][i].getData();
                }
              Integer pos1 = Arrays.asList(temp_array).indexOf(0);//4
              Integer newVar1 = ((Arrays.asList(temp_array).indexOf(0))+1); //5
              Integer newVar2 = (temp_array.length - newVar1); //10
              Integer[] newArray2 = new Integer[newVar2];
              for (int b = newVar1; b < nmatrx.length; b++) {
                newArray2[(b-newVar1)] = temp_array[b];
              }
              Integer pos2 = (Arrays.asList(newArray2).indexOf(0) + newVar1); //6
              if ((rowFreq[pos1] == (acVal - 1)) || (rowFreq[pos2] == (acVal - 1))) {
                for (int c = 0; c < nmatrx.length; c++) {
                  nmatrx[c][i].setV_cross();
                  nmatrx[c][i].plusData(10000);
                  //nmatrx[i][cVal].setH_cross();  *****************************
                } // end if for h cross
              } // end if ==
            }
          }
        }
        return nmatrx;
      }


      public void cross_lines_optimal2_follow(Node[][] nmatrx, Matrix theMatrix, Show theShow, Scanner s) {
        while (theMatrix.evalZerosNodeM(nmatrx) > 0) {
            theShow.DisplayNodeMboolH(nmatrx);
            theShow.DisplayNodeMboolV(nmatrx);
            Integer[] rowFreq = theMatrix.zeroFreqRowNode(nmatrx);   // make array of zero freqs by row printed left
            Integer[] colFreq = theMatrix.zeroFreqColNode(nmatrx);
            int acVal = Collections.max(Arrays.asList(colFreq));  // highest zero frequency in any column
            int arVal = Collections.max(Arrays.asList(rowFreq));  // highest zero frequency in any row
            int cVal = theMatrix.getHighestZeroFreqIndex(colFreq);
            int rVal = theMatrix.getHighestZeroFreqIndex(rowFreq);
            if (acVal > arVal) {
              for (int i = 0; i < nmatrx.length; i++) {
                nmatrx[i][cVal].setV_cross();
              } // end for loop i
            }else {
              //this else here dismisses equality bc I think I will negate it for now
              //if the collumns and rows both have the same # I will always cross out rows first
              for (int j = 0; j < nmatrx.length; j++) {
                nmatrx[rVal][j].setH_cross();
              } // end for loop j
            } // end else
          } //end while
          theMatrix.restore(nmatrx);
          theShow.DisplayNodeMwithZeroFreqsNcolor(nmatrx, theMatrix);
        } //end method


    public int OptimalCross(Node[][] nmatrx, Matrix theMatrix, Show theShow) {
      //while()
        int num3 = 0;
        this.iterate1Node(nmatrx, theMatrix, theShow);
        //System.out.println("Hello2");
        theMatrix.restore(nmatrx); //%1000
        //System.out.println("Hello3");
        int num1 = theMatrix.getNumLinesNode(nmatrx);
        theMatrix.resetNodeM(nmatrx);  //bools false
        //System.out.println("Hello4");
        this.iterate2Node(nmatrx, theMatrix, theShow);
        //System.out.println("Hello5");
        theMatrix.restore(nmatrx); //%1000
        int num2 = theMatrix.getNumLinesNode(nmatrx);
        //System.out.println("Hello6");
        if (num1 < num2) {
          theMatrix.resetNodeM(nmatrx); // bools false
          //System.out.println("Hello7");
          this.iterate1Node(nmatrx, theMatrix, theShow);
          //System.out.println("Hello8");
          theMatrix.restore(nmatrx); //%1000
          int num4 = theMatrix.getNumLinesNode(nmatrx);
          num3+=num4;
          ///System.out.println("Hello9");
        }else{
          num3+=num2;
        }
        return num3;
    }

    public void runProgram() {
          Scanner s = new Scanner(System.in);
          Solver theSolver = new Solver();
          Begin theBegin = new Begin();
          Show theShow = new Show();
          Matrix theMatrix = new Matrix();

          theShow.showProblem(oGpmatrix, s);
          theBegin.negPopulate(oGpmatrix, oGmatrix, theShow, s);
          theBegin.rowReduce(oGmatrix, newoGmatrix, theShow, s);
          theBegin.ColReduce(newoGmatrix, newTwoGmatrix, theShow, s);

          theBegin.prodNodeMatrix(newTwoGmatrix, nodeMatrix);

          System.out.println("\n\n\n\nAlgo Step 4 Complete");
          System.out.println("Display frequency of zeros indexed by row and column.\n");
          theShow.DisplayNodeMwithZeroFreqs(nodeMatrix, theMatrix);
          System.out.println("\n\nPress any key and then Press Enter to Continue");
          s.next();
          System.out.println("End");//////////////

          //typically i just use while but I wanted to count the iterations to see them each.
          theMatrix.finalizeAlgoSteps5n6(nodeMatrix, theShow, theSolver, s, theMatrix);
          theMatrix.finalizeAlgoSteps5n6(nodeMatrix, theShow, theSolver, s, theMatrix);
          theMatrix.finalizeAlgoSteps5n6(nodeMatrix, theShow, theSolver, s, theMatrix);
          theMatrix.finalizeAlgoSteps5n6(nodeMatrix, theShow, theSolver, s, theMatrix);
          theMatrix.finalizeAlgoSteps5n6(nodeMatrix, theShow, theSolver, s, theMatrix);
          theSolver.cross_lines_optimal2(nodeMatrix, theMatrix, theSolver, theShow, s);
          theSolver.cross_lines_optimal2_follow(nodeMatrix, theMatrix, theShow, s);

          theMatrix.subMinValNode(nodeMatrix);
          theShow.DisplayNodeMwithZeroFreqsNcolor(nodeMatrix, theMatrix);

          theShow.DisplaySol(oGpmatrix, nodeMatrix);
          System.out.println("\n\nPress any key and then Press Enter to Continue");
          s.next();
          theShow.DisplaySol2(oGpmatrix, nodeMatrix);
          theShow.DisplaySol3(oGpmatrix, nodeMatrix);

        }


    public void runProgram2() {
              Scanner s = new Scanner(System.in);
              Solver theSolver = new Solver();
              Begin theBegin = new Begin();
              Show theShow = new Show();
              Matrix theMatrix = new Matrix();
              Process theProcess = new Process();
              Solution theSolution = new Solution();
              Extract theExtract = new Extract();

              theShow.showProblem(oGpmatrix, s);
              theBegin.negPopulate(oGpmatrix, oGmatrix, theShow, s);
              theBegin.rowReduce(oGmatrix, newoGmatrix, theShow, s);
              theBegin.ColReduce(newoGmatrix, newTwoGmatrix, theShow, s);

              theBegin.prodNodeMatrix(newTwoGmatrix, nodeMatrix);

              System.out.println("\n\n\n\nAlgo Step 4 Complete");
              System.out.println("Display frequency of zeros indexed by row and column.\n");
              theShow.DisplayNodeMwithZeroFreqs(nodeMatrix, theMatrix);
              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");//////////////

                  //typically i just use while but I wanted to count the iterations to see them each.
            for (int i = 1; i < 6; i++) {
              theMatrix.finalizeAlgoSteps5n6(nodeMatrix, theShow, theSolver, s, theMatrix);
              System.out.print("\n***************Completed_");
              System.out.print(i);
              System.out.print("_times*************************************\n");
              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");//////////////
            }
/////
              theShow.DisplayCrossNodeM(nodeMatrix);
              theSolver.cross_cross(nodeMatrix, theMatrix, theShow);
              theMatrix.get2dNodeArrayMinv2(nodeMatrix);
              theMatrix.restore(nodeMatrix);
              theShow.DisplayCrossNodeM(nodeMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              theMatrix.subMinValNodev2(nodeMatrix);
              theShow.DisplayCrossNodeM(nodeMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              System.out.println("*****************************flag_check_values***************************************");
              theMatrix.getNumLinesNode(nodeMatrix);

              theMatrix.resetNodeM(nodeMatrix);

              System.out.println("*****************************flag_check_values***************************************");
              theMatrix.getNumLinesNode(nodeMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              System.out.println("Completed 6 times.  start function call here proIterate");
              theProcess.proIterate(nodeMatrix, theSolver, theMatrix, theShow);
              System.out.println("Completed 7 times.  start function call here proIterate");
              theProcess.proIterate(nodeMatrix, theSolver, theMatrix, theShow);
              System.out.println("Completed 8 times.  start function call here proIterate");
              theProcess.proIterate2(nodeMatrix, theSolver, theMatrix, theShow);
              System.out.println("Completed 9 times.  start function call here proIterate");
              //theProcess.proIterate2(nodeMatrix, theSolver, theMatrix, theShow);
              //System.out.println("Completed 10 times.  start function call here proIterate");
              //theProcess.proIterate(nodeMatrix, theSolver, theMatrix, theShow);
              //System.out.println("Completed 10 times.  start function call here proIterate");
              //theProcess.proIterate(nodeMatrix, theSolver, theMatrix, theShow);
              //System.out.println("Completed 11 times.  start function call here proIterate");
              //theProcess.proIterate(nodeMatrix, theSolver, theMatrix, theShow);
              theShow.DisplayCrossNodeM(nodeMatrix);

              theSolution.solve_s1(nodeMatrix, oGpmatrix, theMatrix);

              theShow.DisplayCrossedNodeMwithZeroFreqsv3(nodeMatrix, theMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              theSolution.solve_s2(nodeMatrix, oGpmatrix, theMatrix);

              theShow.DisplayCrossedNodeMwithZeroFreqsv3(nodeMatrix, theMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              theSolution.solve_s2(nodeMatrix, oGpmatrix, theMatrix);

              theShow.DisplayCrossedNodeMwithZeroFreqsv3(nodeMatrix, theMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              theSolution.solve_s2(nodeMatrix, oGpmatrix, theMatrix);

              theShow.DisplayCrossedNodeMwithZeroFreqsv3(nodeMatrix, theMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              s.next();
              System.out.println("End");

              theSolution.solve_s2(nodeMatrix, oGpmatrix, theMatrix);

              theMatrix.restore(nodeMatrix);

              theShow.DisplayCrossedNodeMwithZeroFreqsv3(nodeMatrix, theMatrix);

              System.out.println("\n\nPress any key and then Press Enter to Continue");
              System.out.println("\n\nFinal Solution!\n\n");
              s.next();
              System.out.println("End");

              theExtract.answer(nodeMatrix, oGpmatrix);

              System.out.print("\n\n The Max Matrix Sum is:     ");
              System.out.println(theSolution.gatherSum(nodeMatrix));
              System.out.println("\n\n  Project Euler #345\n\n\n");
          } // end method




      }//end class
