package Controller;


class ControllerTest {
public static void main(String[] args) {
	System.out.println("Test della classe Controller:");
	Controller controller=new Controller();
	if(controller!=null) {
		System.out.println("Test superato con successo!");
	}
	else {
		throw new RuntimeException("Test fallito: Controller nullo");
	}
}
}
