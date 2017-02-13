import controller.MoveController;
import controller.WinContoller;
import model.Field;
import model.Figure;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
		Field testfield = new Field(3);
		
		//test
		testfield.setFigure(0,0, Figure.X);
		testfield.setFigure(0,1, Figure.X);
		testfield.setFigure(0,2, Figure.O);

		testfield.setFigure(1,0, Figure.O);
		testfield.setFigure(1,1, Figure.O);
		testfield.setFigure(1,2, Figure.X);

		testfield.setFigure(2,0, Figure.X);
//		testfield.setFigure(2,1, Figure.O);
//		testfield.setFigure(2,2, Figure.O);
	
		WinContoller wc = new WinContoller();
		MoveController mc = new MoveController();
		
		ConsoleView cli =new ConsoleView(wc,mc);
		cli.show(testfield );
		while(cli.move(testfield)) {
			cli.show(testfield);
		}
		
		
		
    }
}
