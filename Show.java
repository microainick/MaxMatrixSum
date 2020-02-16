import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Show {
    public Show() {
    }

      public static final String ANSI_RESET = "\u001B[0m";
      public static final String ANSI_BLACK = "\u001B[30m";
      public static final String ANSI_RED = "\u001B[31m";
      public static final String ANSI_GREEN = "\u001B[32m";
      public static final String ANSI_YELLOW = "\u001B[33m";
      public static final String ANSI_BLUE = "\u001B[34m";
      public static final String ANSI_PURPLE = "\u001B[35m";
      public static final String ANSI_CYAN = "\u001B[36m";
      public static final String ANSI_WHITE = "\u001B[37m";

      public void showProblem(Integer[][] matrx, Scanner s) {
        System.out.println("\n\n\n\n\n   The Initial Matrix:\n");
        this.DisplayM(matrx);
        System.out.println("\n\nPress any key and then Press Enter to Continue");
        s.next();
      }

      public void DisplayM(Integer[][] matrx){
        System.out.print("\n\t Column #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } // end for loop h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx[i].length; j++) {
                  System.out.printf("%5d ", matrx[i][j]);
              } // end for loop j
              System.out.println("\n");
          } //end for loop i
      } //end method

      public void DisplayNodeM(Node[][] matrx){
        System.out.print("\t Collumn #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } //end for h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx[i].length; j++) {
                  System.out.printf("%5d ", matrx[i][j].getData());
              } // end for j
              System.out.println("\n");
          } //end for i
      } // end method

      public void DisplayCrossNodeM(Node[][] matrx){
        System.out.print("\t Collumn #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } //end for h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx[i].length; j++) {
                  matrx[i][j].highlight_cross();
              } // end for j
              System.out.println("\n");
          } //end for i
      } // end method

      public void DisplayNodeMboolV(Node[][] matrx){
        System.out.print("\t Collumn #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } //end for h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx[i].length; j++) {
                  System.out.printf("%5b ", matrx[i][j].getV_cross());
              } // end for j
              System.out.println("\n");
          } //end for i
      } // end method

      public void DisplayNodeMboolH(Node[][] matrx){
        System.out.print("\t Collumn #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } //end for h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx[i].length; j++) {
                  System.out.printf("%5b ", matrx[i][j].getH_cross());
              } // end for j
              System.out.println("\n");
          } //end for i
      } // end method

      public void DisplayNodeMwithZeroFreqsNcolor(Node[][] matrx, Matrix theMatrix) {
        Integer[] arrayRow = theMatrix.zeroFreqRowNode(matrx);
        Integer[] arrayCol = theMatrix.zeroFreqColNode(matrx);
        System.out.print("\n\n\t Collumn #\t");
        for (int g = 0; g < matrx.length; g++){
          //System.out.print(" ");
          System.out.printf("%4d", g);
          System.out.print("  ");
        } //end for g
        System.out.print("\n\n                Zero's\t");
        for (int h = 0; h < matrx.length; h++) {
            System.out.printf("%4d", arrayCol[h]);
            System.out.print("  ");
        } // end for loop h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("       ");
          System.out.printf("%d", arrayRow[i]);
          System.out.print("\t");
              for (int j = 0; j < matrx.length; j++) {
                  if (matrx[i][j].getH_cross() == true) {
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j].getData());
                  }
                  else if (matrx[i][j].getV_cross() == true) {
                      System.out.printf(ANSI_GREEN + "%5d " + ANSI_RESET, matrx[i][j].getData());
                  } else {
                      System.out.printf("%5d ", matrx[i][j].getData());
                  }
              } // end for j
              System.out.println("\n");
          } //end for i
      } // end method

//what do i do?
//create 2 arrays containing the frequency of zeros in rows and collumns

      public void DisplayNodeMwithZeroFreqs(Node[][] matrx, Matrix theMatrix){
        Integer[] arrayRow = theMatrix.zeroFreqRowNode(matrx);
        Integer[] arrayCol = theMatrix.zeroFreqColNode(matrx);
        System.out.print("\n\n\t Collumn #\t");
        for (int g = 0; g < matrx.length; g++){
          //System.out.print(" ");
          System.out.printf("%4d", g);
          System.out.print("  ");
        } //end for g
        System.out.print("\n\n                Zero's\t");
        for (int h = 0; h < matrx.length; h++) {
            System.out.printf("%4d", arrayCol[h]);
            System.out.print("  ");
        } // end for loop h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("       ");
          System.out.printf("%d", arrayRow[i]);
          System.out.print("\t");
              for (int j = 0; j < matrx.length; j++) {
                  System.out.printf("%5d ", matrx[i][j].getData());
              } // end for j
              System.out.println("\n");
          } //end for i
    } // end method


    public void DisplayCrossedNodeMwithZeroFreqs(Node[][] matrx, Matrix theMatrix){
            Integer[] arrayRow = theMatrix.zeroFreqRowNode(matrx);
            Integer[] arrayCol = theMatrix.zeroFreqColNode(matrx);
            System.out.print("\n\n\t Collumn #\t");
            for (int g = 0; g < matrx.length; g++){
              //System.out.print(" ");
              System.out.printf("%4d", g);
              System.out.print("  ");
            } //end for g
            System.out.print("\n\n                Zero's\t");
            for (int h = 0; h < matrx.length; h++) {
                System.out.printf("%4d", arrayCol[h]);
                System.out.print("  ");
            } // end for loop h
            System.out.println("\n\n\tRow #\t");
            for (int i = 0; i < matrx.length; i++) {
              System.out.printf("\t %3d", i);
              System.out.print("       ");
              System.out.printf("%d", arrayRow[i]);
              System.out.print("\t");
                  for (int j = 0; j < matrx.length; j++) {
                      matrx[i][j].highlight_cross();
                  } // end for j
                  System.out.println("\n");
              } //end for i
  } // end method

      public void DisplayCrossedNodeMwithZeroFreqsv3(Node[][] matrx, Matrix theMatrix){
              Integer[] arrayRow = theMatrix.zeroFreqRowNodev3_select(matrx);
              Integer[] arrayCol = theMatrix.zeroFreqColNodev3_select(matrx);
              System.out.print("\n\n\t Collumn #\t");
              for (int g = 0; g < matrx.length; g++){
                //System.out.print(" ");
                System.out.printf("%4d", g);
                System.out.print("  ");
              } //end for g
              System.out.print("\n\n                Zero's\t");
              for (int h = 0; h < matrx.length; h++) {
                  System.out.printf("%4d", arrayCol[h]);
                  System.out.print("  ");
              } // end for loop h
              System.out.println("\n\n\tRow #\t");
              for (int i = 0; i < matrx.length; i++) {
                System.out.printf("\t %3d", i);
                System.out.print("       ");
                System.out.printf("%d", arrayRow[i]);
                System.out.print("\t");
                    for (int j = 0; j < matrx.length; j++) {
                        matrx[i][j].highlight_cross();
                    } // end for j
                    System.out.println("\n");
                } //end for i
    } // end method

      public void DisplayCrossedNodeMwithZeroFreqsv2(Node[][] matrx, Matrix theMatrix){
          Integer[] arrayRow = theMatrix.zeroFreqRowNodev2(matrx);
          Integer[] arrayCol = theMatrix.zeroFreqColNodev2(matrx);
          System.out.print("\n\n\t Collumn #\t");
          for (int g = 0; g < matrx.length; g++){
            //System.out.print(" ");
            System.out.printf("%4d", g);
            System.out.print("  ");
          } //end for g
          System.out.print("\n\n                Zero's\t");
          for (int h = 0; h < matrx.length; h++) {
              System.out.printf("%4d", arrayCol[h]);
              System.out.print("  ");
          } // end for loop h
          System.out.println("\n\n\tRow #\t");
          for (int i = 0; i < matrx.length; i++) {
            System.out.printf("\t %3d", i);
            System.out.print("       ");
            System.out.printf("%d", arrayRow[i]);
            System.out.print("\t");
                for (int j = 0; j < matrx.length; j++) {
                    matrx[i][j].highlight_cross();
                } // end for j
                System.out.println("\n");
            } //end for i
      } // end method


//just part of the demo
      public void DisplaySol2(Integer[][] matrx, Node[][] nmatrx){
        System.out.print("\n\n\n\n\n\n\t Column #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } // end for loop h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx.length; j++) {
                  if (i==0 && j==0){
                      System.out.printf(ANSI_RED + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==8 && j==14){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==6 && j==13){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==12 && j==12){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==2 && j==7){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==14 && j==1){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==7 && j==2){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==11 && j==5){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==10 && j==6){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==0 && j==9){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  //else if (i==0 && j==9){
                    //  System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  //}
                  else if (j == 0) {
                    System.out.printf("%5d ", matrx[i][j]);
                  }
                  else if (nmatrx[i][j].getData() == 0) {
                    System.out.printf(ANSI_BLUE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }else{
                    System.out.print(ANSI_RED + "  0   " + ANSI_RESET);
                  }
                } // end for loop j
              System.out.println("\n");
          } //end for loop i
      } //end method

      public void DisplaySol3(Integer[][] matrx, Node[][] nmatrx){
        System.out.print("\n\n\n\n\n\n\t Column #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } // end for loop h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx.length; j++) {
                  if (i==0 && j==0){
                      System.out.printf(ANSI_RED + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==8 && j==14){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==6 && j==13){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==12 && j==12){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i== 0 && j== 9){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i== 4 && j== 3){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==2 && j==7){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==14 && j==1){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==7 && j==2){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==11 && j==5){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==10 && j==6){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==5 && j==0){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==1 && j==10){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==3 && j==4){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==9 && j==11){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }
                  else if (i==13 && j==8){
                      System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }else{
                    System.out.print(ANSI_RED + "  0   " + ANSI_RESET);
                  }
                } // end for loop j
              System.out.println("\n");
          } //end for loop i
      } //end method




      public void DisplaySol(Integer[][] matrx, Node[][] nmatrx){
        System.out.print("\n\n\n\n\n\n\t Column #\t");
        for (int h = 0; h < matrx.length; h++){
          //System.out.print(" ");
          System.out.printf("%4d", h);
          System.out.print("  ");
        } // end for loop h
        System.out.println("\n\n\tRow #\t");
        for (int i = 0; i < matrx.length; i++) {
          System.out.printf("\t %3d", i);
          System.out.print("\t\t");
              for (int j = 0; j < matrx.length; j++) {
                  //if (i=0 && j=8)
                  if (j == 0) {
                    System.out.printf("%5d ", matrx[i][j]);
                  }
                  else if (nmatrx[i][j].getData() == 0) {
                    System.out.printf(ANSI_BLUE + "%5d " + ANSI_RESET, matrx[i][j]);
                  }else{
                    System.out.print(ANSI_RED + "  0   " + ANSI_RESET);
                  }
                } // end for loop j
              System.out.println("\n");
          } //end for loop i
      } //end method


      public Node[][] ProcessSolution(Node[][] nmatrx, Integer[][] matrx, Node[][] smatrx) {
          for (int i = 0; i < nmatrx.length; i++) {
              for (int j = 0; j < nmatrx.length; j++) {
                  if (nmatrx[i][j].getData() == 0) {
                      int var = matrx[i][j];
                      smatrx[i][j].setData(var);
                      //System.out.printf(ANSI_CYAN + "%5d " + ANSI_RESET, matrx[i][j]);
                  } else {
                      //System.out.printf(ANSI_RED + "%5d " + ANSI_RESET, matrx[i][j]);
                      smatrx[i][j].setData(5);
                  }
              }
            }
          return smatrx;
      }

}
