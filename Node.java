public class Node {
      private
          Integer data;
          Integer solution_data;
          boolean h_cross = false;
          boolean v_cross = false;
          boolean g_cross = false;
          boolean selected = false;


      public static final String ANSI_RESET = "\u001B[0m";
      public static final String ANSI_BLACK = "\u001B[30m";
      public static final String ANSI_RED = "\u001B[31m";
      public static final String ANSI_GREEN = "\u001B[32m";
      public static final String ANSI_YELLOW = "\u001B[33m";
      public static final String ANSI_BLUE = "\u001B[34m";
      public static final String ANSI_PURPLE = "\u001B[35m";
      public static final String ANSI_CYAN = "\u001B[36m";
      public static final String ANSI_WHITE = "\u001B[37m";


      public Node(Integer d) {
        data = d;
      }

      public void plusData(Integer plus) {
          data+=plus;
      }

      public void setData(int val) {
          data = val;
      }

      public boolean get_selected(){
          return selected;
      }

      public void set_selected(){
          selected = true;
      }

      public Integer getData(){
  	     return data;
      }

      public void set_solution_Data(int val) {
          solution_data = val;
      }

      public Integer get_solution_Data(){
   	     return solution_data;
      }

      public void highlight_cross(){
          if (this.getH_cross() == true && this.getV_cross() == true) {
              System.out.printf(ANSI_GREEN + "%5d " + ANSI_RESET, this.getData());
          }
          else if (this.getH_cross() == true ) {
              System.out.printf(ANSI_YELLOW + "%5d " + ANSI_RESET, this.getData());
          }  // end 1st else if
          else if (this.getV_cross() == true ) {
              System.out.printf(ANSI_CYAN + "%5d " + ANSI_RESET, this.getData());
          } //end 2nd else if
          else if (this.get_selected()  == true) {
              System.out.printf(ANSI_PURPLE + "%5d " + ANSI_RESET, this.getData());
          }
          else
          {
              System.out.printf(ANSI_WHITE + "%5d " + ANSI_RESET, this.getData());
          } // end else
       } //end method

      public boolean getV_cross(){
        return v_cross;
      }

      public boolean getH_cross(){
        return h_cross;
      }

      public boolean getG_cross(){
        return g_cross;
      }

      public void setV_cross(){
        v_cross = true;
        g_cross = true;
      }

      public void setG_cross(){
        g_cross = true;
      }

      public void resetNode(){
        v_cross = false;
        h_cross = false;
        g_cross = false;
      }

      public void setH_cross(){
        h_cross = true;
        g_cross = true;
      }

}
