import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class AthleticRaceInterface {
   public static List<Runner> corredores = new ArrayList<>(5);

   public AthleticRaceInterface(){

      JFrame frame = new JFrame("TAP-R5-U3");
      frame.setSize(600,700);
      frame.setLocationRelativeTo(null);






      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      new AthleticRaceInterface();
   }
}
