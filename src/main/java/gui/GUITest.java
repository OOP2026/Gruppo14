package gui;
import javax.swing.SwingUtilities;

import controller.*;
public class GUITest {
/**
 * Method main for GUI test
 * @param args
 */
	public static void main(String[] args) { //NOSONAR
		SwingUtilities.invokeLater(()->{
			Controller controller=new Controller();
			LoginFrame frame=new LoginFrame(controller);
			frame.setVisible(true);
		});

	}

}
