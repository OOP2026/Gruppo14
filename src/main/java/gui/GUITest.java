package GUI;
import controller.*;
import javax.swing.SwingUtilities;
public class GUITest {
/**
 * Metodo main per testare l'applicazione GUI
 * @param args
 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			Controller controller=new Controller();
			LoginFrame frame=new LoginFrame(controller);
			frame.setVisible(true);
		});

	}

}
