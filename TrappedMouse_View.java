import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*; 
import java.io.IOException;
import javax.swing.*;
public class TrappedMouse_View extends JPanel {
   private JFrame frame;
   private BufferedImage mouse;
   private BufferedImage mouse_left;
   private BufferedImage mouse_right;
   private BufferedImage mouse_up;
   private BufferedImage mouse_down;
   private int x_position;
   private int y_position;
   String c;
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
   public BufferedImage get_mouse() {
      return mouse;
   }
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
   public void get_direction() {
      c = JOptionPane.showInputDialog(null, "Which direction should the mouse move? : ( F - forward, L - left, R - right )");
      c = c.trim();
      c = c.toUpperCase();
      this.repaint();
      try {
         switch(c) {
            case "L": {
               if(mouse == mouse_left) {
                  mouse = mouse_down;
                  get_direction();
                  break;
               }
               else if(mouse == mouse_right) {
                  mouse = mouse_up;
                  get_direction();
                  break;
               }
               else if(mouse == mouse_down) {
                  mouse = mouse_right;
                  get_direction();
                  break;
               } 
               else if(mouse == mouse_up) {
                  mouse = mouse_left;
                  get_direction();
                  break;
               }
            }
            case "R": {
               if(mouse == mouse_left) {
                  mouse = mouse_up;
                  get_direction();
                  break;
               }
               else if(mouse == mouse_right) {
                  mouse = mouse_down;
                  get_direction();
                  break;
               }
               else if(mouse == mouse_down) {
                  mouse = mouse_left;
                  get_direction();
                  break;
               } 
               else if (mouse == mouse_up) {
                  mouse = mouse_right;
                  get_direction();
                  break;
               }
            }
            case "F": { 
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
               default: {
                  JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");
                  get_direction();
               }
            }
         }
         catch(NullPointerException e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
         }
   }
   public void repaintMethod() {
      this.repaint();
   }
   public void paintComponent(Graphics g) {
      g.setColor(Color.decode("#fefebe"));
      g.fillRect(0,0,970,720);
      g.setColor(Color.decode("#ff0000"));
      g.drawRect(20, 20, 920, 650);
      g.drawImage(mouse, x_position, y_position, this);
  
   }
}