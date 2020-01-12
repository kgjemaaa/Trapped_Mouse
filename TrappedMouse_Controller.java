public class TrappedMouse_Controller {
   public static void main(String[] args) {
   //Thirrja e klasave TrappedMouse_Model dhe TrapepdMouse_View
      TrappedMouse_Model model = new TrappedMouse_Model();
      TrappedMouse_View view = new TrappedMouse_View(model.get_mouse());
      
      //kommunikimi me shfrytezuesin
      view.add_listener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent windowEvent) {
              int answer = view.get_answer();
              if (answer == 0) {
                  System.exit(0);
              }
              if(answer == 1) {
                  view.get_direction();
              }
              if(answer == -1) {
                  view.get_direction();
              }
          }
      });
      //pozicioni fillestar i miut
      model.set_x_position(20);
      model.set_y_position(20);
      //pozicioni i tanishem i miut
      view.set_x_position(model.get_x_position());
      view.set_y_position(model.get_y_position());
      //metodat per ndrrimin e drejtimit te miut
      view.set_mouse_left(model.get_mouse_left());
      view.set_mouse_right(model.get_mouse_right());
      view.set_mouse_up(model.get_mouse_up());
      view.set_mouse_down(model.get_mouse_down());
      //metoda qe e merr urdherin nga perdoruesi, mund te gjendet te klasa TrapepdMouse_View 
      view.get_direction();
      //metoda per vizatimin e miut
      model.set_mouse(view.get_mouse());
   }
}
