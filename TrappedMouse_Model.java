import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class TrappedMouse_Model {
   //deklarimi i variablave te cilat do te lidhen me imazhet e miut
   private BufferedImage mouse;
   private BufferedImage mouse_up;
   private BufferedImage mouse_right;
   private BufferedImage mouse_down;
   private BufferedImage mouse_left;
   //deklarimi i variablave qe paraqesin pozicionin e miut
   private int x_position;
   private int y_position;
   //Konstrukturi i TrappedMouse_Model i cili fillimisht permes metodes i merr imazhet e miut dhe pastaj e tregon drejtimin fillestar
   //te miut
   public TrappedMouse_Model() {
      try {
         //integrimi i fotove
         mouse_left = ImageIO.read(new File("left.png"));
         mouse_right = ImageIO.read(new File("right.png"));
         mouse_up = ImageIO.read(new File("up.png"));
         mouse_down = ImageIO.read(new File("down.png"));
      }
      //Ne rast qe fotot nuk gjinden
      catch (IOException ex) {
         JOptionPane.showMessageDialog(null, "Missing Images");  
      }
      //drejtimi fillestar i miut
      mouse = mouse_right;
   }
   //metoda per thirrjen e imazhit te miut momental
   public BufferedImage get_mouse() {
      return mouse;
   }
   //metoda per thirrjen e imazhit te miut me drejtim up
   public BufferedImage get_mouse_up() {
      return mouse_up;
   }
   //metoda per thirrjen e imazhit te miut me drejtim right
   public BufferedImage get_mouse_right() {
      return mouse_right;
   }
   //metoda per thirrjen e imazhit te miut me drejtim down
   public BufferedImage get_mouse_down() {
      return mouse_down;
   }
   //metoda per thirrjen e imazhit te miut me drejtim left
   public BufferedImage get_mouse_left() {
      return mouse_left;
   }
   //metoda per ndrrimin e drejtimit te miut
   public void set_mouse(BufferedImage mouse) {
      this.mouse = mouse;
   }
   //metoda per ndrrimin e x pozicionit
   public void set_x_position(int x) {
      x_position = x;
   }
   //metoda per ndrrimin e y pozicionit
   public void set_y_position(int y) {
      y_position = y;
   }
   //metoda per marrjen e x pozicionit momental
   public int get_x_position() {
      return x_position;
   }
   //metoda per marrjen e y pozicionit momental
   public int get_y_position() {
      return y_position;
   }
}
