package GUI;
import Controller.*;
import javax.swing.SwingUtilities;
public class GUITest {
/**
 * Metodo main per testare l'applicazione GUI
 * @param args
 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			controller controller=new controller();
			LoginFrame frame=new LoginFrame(controller);
			frame.setVisible(true);
		});

	}

}
