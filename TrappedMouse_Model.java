import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class TrappedMouse_Model {
   private BufferedImage mouse;
   private BufferedImage mouse_up;
   private BufferedImage mouse_right;
   private BufferedImage mouse_down;
   private BufferedImage mouse_left;
   private int x_position;
   private int y_position;
   public TrappedMouse_Model() {
      try {
         mouse_left = ImageIO.read(new File("left.png"));
         mouse_right = ImageIO.read(new File("right.png"));
         mouse_up = ImageIO.read(new File("up.png"));
         mouse_down = ImageIO.read(new File("down.png"));
      }
      catch (IOException ex) {
         JOptionPane.showMessageDialog(null, "Missing Images");  
      }
      mouse = mouse_right;
   }
   public BufferedImage get_mouse() {
      return mouse;
   }
   public BufferedImage get_mouse_up() {
      return mouse_up;
   }
   public BufferedImage get_mouse_right() {
      return mouse_right;
   }
   public BufferedImage get_mouse_down() {
      return mouse_down;
   }
   public BufferedImage get_mouse_left() {
      return mouse_left;
   }
   public void set_mouse(BufferedImage mouse) {
      this.mouse = mouse;
   }
   public void set_x_position(int x) {
      x_position = x;
   }
   public void set_y_position(int y) {
      y_position = y;
   }
   public int get_x_position() {
      return x_position;
   }
   public int get_y_position() {
      return y_position;
   }
}
