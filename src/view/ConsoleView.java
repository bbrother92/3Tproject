package view;


import controller.MoveController;
import controller.WinContoller;
import controller.exception.OccupiedException;
import controller.exception.PointValidationException;
import model.Field;
import model.Figure;


import java.util.Scanner;

public class ConsoleView {
	private final WinContoller winContoller;
	
	private final MoveController moveController;
	
	private Figure currentPlayer = Figure.X;
	
	public ConsoleView(WinContoller winContoller, MoveController moveController) {
		this.winContoller = winContoller;
		this.moveController = moveController;
	}
	
	// show
	public void show(Field field) {
		for (int x = 0; x < field.getSize(); x++) {
			printLine(field, x);
		}
		printdelimiter();
	}
	
	private void printLine(Field field, int x) {
		Figure figure;
		for (int y = 0; y < field.getSize(); y++) {
			figure = field.getFigure(x, y);
			System.out.print(figure != null ? figure : " ");
			System.out.print("|");
		}
		System.out.println();
		
	}
	
	// main move logic
	
	public boolean move(Field field) {
		//check winner
		final Figure winner = winContoller.getWinner(field);
		if (winner != null) {
			System.out.format("Winner is: %s\n", winner);
			return false;
		}
		if (moveController.isDraw(field)) {
			System.out.println("No winner!");
			return false;
		}
		
		
		boolean onemoreturn = false;
		//prompt
		do {
			System.out.format("Please enter move   for: %s\n", currentPlayer.toString());
			int x = askMove("row");
			int y = askMove("col");
			//setting the figure
			try {
				moveController.applyFigure(field, currentPlayer, x, y);
				onemoreturn = false;
			} catch (PointValidationException e2) {
				System.out.println("Please enter numbers between 0 and 2 only");
				onemoreturn = true;
			} catch (OccupiedException e) {
				System.out.println("Point is occupied");
				onemoreturn = true;
			}
			
			
		} while (onemoreturn);
		
		
		currentPlayer = moveController.currentMove(currentPlayer); //changing next move
		return true;
		
		
	}
	
	private void printdelimiter() {
		System.out.println("======");
		
	}
	
	public int askMove(String val) {
		System.out.format("Please input %s:", val);
		final Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	
}
