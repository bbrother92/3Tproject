package controller;


import controller.exception.OccupiedException;
import controller.exception.PointValidationException;
import model.Field;
import model.Figure;

public class MoveController {
	public void applyFigure(final Field field, final Figure figure, int x, int y) throws OccupiedException,PointValidationException {
		if (x>=3 || x<0||y>=3 || y<0 ){ throw  new PointValidationException();}
		
		if (field.getFigure(x, y) != null) {
			throw new OccupiedException();
		}
		field.setFigure(x, y, figure);
		
	}
	
	//calculation of next move
	public Figure currentMove(Figure current) {
		if (current == Figure.X) { return Figure.O;}
		else return Figure.X;
	}
	public  boolean isDraw(Field field) {
		int countFigure = 0;
		//counting
		final int size = field.getSize();
		for (int i = 0; i <size ; i++) {
			for (int j = 0; j <size; j++) {
				if (field.getFigure(i,j)!=null) countFigure++;
			}
		}
		if (countFigure==size*size) return true; else return false;
		
	}
	
	
}
