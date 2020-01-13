import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*; 
import java.io.IOException;
import javax.swing.*;
public class TrappedMouse_View extends JPanel {
   //deklarimi i variables per JFrame,variablat e imazheve, te pozicionit te miut,dhe e mesazhit per perdorues
   private JFrame frame;
   private BufferedImage mouse;
   private BufferedImage mouse_left;
   private BufferedImage mouse_right;
   private BufferedImage mouse_up;
   private BufferedImage mouse_down;
   private int x_position;
   private int y_position;
   String c;
   //Konstruktori i cili e krijon nje dritare dhe e vizaton dritaren
   public TrappedMouse_View(BufferedImage mouse) {
      frame = new JFrame();
      frame.setTitle("The Trapped Mouse");
      frame.setVisible(true);
      frame.setSize(970,720);
      frame.setResizable(false);
      frame.getContentPane().add(this);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.mouse = mouse;
   }
   //metodat per komunikim me perdorues
   public void add_listener(WindowListener window_listener) {
      frame.addWindowListener(window_listener);
   }
   public int get_answer() {
      int answer = JOptionPane.showConfirmDialog(frame, 
                  "Do you want to quit the game?", "Close Window?", 
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.QUESTION_MESSAGE);
      return answer;
   }
   //metodat per ndrrimin e drejtimit te mausit
   public void set_mouse_left(BufferedImage mouse) {
      mouse_left = mouse;
   }
   public void set_mouse_right(BufferedImage mouse) {
      mouse_right = mouse;
   }
   public void set_mouse_up(BufferedImage mouse) {
      mouse_up = mouse;
   }
    public void set_mouse_down(BufferedImage mouse) {
      mouse_down = mouse;
   }
   //metoda per thirrjen e imazhit te miut me drejtimit aktual
   public BufferedImage get_mouse() {
      return mouse;
   }
   //metodat per marrjen dhe ndryshimin e drejtimit te mausit
   public void set_x_position(int x) {
      x_position = x;
   }
   public int get_x_position() {
      return x_position;
   }
   public void set_y_position(int y) {
      y_position = y;
   }
   public int get_y_position() {
      return y_position;
   }
   //metoda e cila e ben komunikimin me perdorues dhe qe e leviz miun
   public void get_direction() {
      //Dialogu per komunikim me perdoruesin, i cili e pyet per drejtim
      c = JOptionPane.showInputDialog(null, "Which direction should the mouse move? -(F: forward; R: right; L: left)");
      //per evitimin e gabimeve e formatizojmë tekstin nga perdoruesi
      c = c.trim();
      c = c.toUpperCase();
      this.repaint();
      try {
         switch(c) {
               //ne rastin kur perdoruesi deshiron te kthej miun ne te majtë
            case "L": {
               //nese miu është në drejtimin left do te kthehet ne drejtimin down
               if(mouse == mouse_left) {
                  mouse = mouse_down;
                  get_direction();
                  break;
               }
               //nese miu është në drejtimin right do te kthehet ne drejtimin up
               else if(mouse == mouse_right) {
                  mouse = mouse_up;
                  get_direction();
                  break;
               }
               //nese miu është në drejtimin down do te kthehet ne drejtimin right
               else if(mouse == mouse_down) {
                  mouse = mouse_right;
                  get_direction();
                  break;
               } 
               //nese miu është në drejtimin up do te kthehet ne drejtimin left
               else if(mouse == mouse_up) {
                  mouse = mouse_left;
                  get_direction();
                  break;
               }
            }
            //ne rastin kur perdoruesi deshiron te kthej miun ne te djathë
            case "R": {
               //nese miu është në drejtimin left do te kthehet ne drejtimin up
               if(mouse == mouse_left) {
                  mouse = mouse_up;
                  get_direction();
                  break;
               }
               //nese miu është në drejtimin right do te kthehet ne drejtimin down
               else if(mouse == mouse_right) {
                  mouse = mouse_down;
                  get_direction();
                  break;
               }
               //nese miu është në drejtimin down do te kthehet ne drejtimin left
               else if(mouse == mouse_down) {
                  mouse = mouse_left;
                  get_direction();
                  break;
               } 
               //nese miu është në drejtimin up do te kthehet ne drejtimin right
               else if (mouse == mouse_up) {
                  mouse = mouse_right;
                  get_direction();
                  break;
               }
            }
               //nese perdoruesi dëshiron ta qoj miun përpara
            case "F": { 
               //nese miu eshte para kufirit ai mund te leviz nese jo do  te dal nje mesazh qe i tregon 
               //qe nuk mundet te leviz ne kete drejtim
                  if(mouse == mouse_right) {
                     if(x_position < 776) {
                        x_position += 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null, "You're trapped, try another way!");
                     }
                     get_direction();
                     break;
                  }
                //nese miu eshte para kufirit ai mund te leviz nese jo do  te dal nje mesazh qe i tregon 
               //qe nuk mundet te leviz ne kete drejtim
                  else if (mouse == mouse_left) {
                     if(x_position > 70) {
                        x_position -= 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null,  "You're trapped, try another way!");
                     }
                     get_direction();
                     break;
                  }
                //nese miu eshte para kufirit ai mund te leviz nese jo do  te dal nje mesazh qe i tregon 
               //qe nuk mundet te leviz ne kete drejtim
                  else if(mouse == mouse_up) {
                     if(y_position > 70) {
                        y_position -= 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null,  "You're trapped, try another way!");
                     }
                     get_direction();
                     break;
                  }
                //nese miu eshte para kufirit ai mund te leviz nese jo do  te dal nje mesazh qe i tregon 
               //qe nuk mundet te leviz ne kete drejtim
                  else if(mouse == mouse_down) {
                     if(y_position < 487) {
                        y_position += 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null,  "You're trapped, try another way!");
                     }
                     get_direction();
                     break;
                  }
               }
               //ne rastin  qe perdoruesi shtyp komanda te panjohura per aplikacionin del mesazhi qe i tregon qe ka gabim, 
               //dhe hapet perseri ddritarja per marrjen e urdherave
               default: {
                  JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");
                  get_direction();
               }
            }
         }
      //ne rast qe paraqitet ndonje gabim
         catch(NullPointerException e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
         }
   }
   //metoda qe sherbern per ri-vizatimin e miut ne pozicionin e ri
   public void repaintMethod() {
      this.repaint();
   }
   //Metoda per ngjyrosjen e kornizes, vendsojen e kufirit dhe vizatimin i miut
   public void paintComponent(Graphics g) {
      g.setColor(Color.decode("#fefebe"));
      g.fillRect(0,0,970,720);
      g.setColor(Color.decode("#ff0000"));
      g.drawRect(20, 20, 920, 650);
      g.drawImage(mouse, x_position, y_position, this);
  
   }
}
