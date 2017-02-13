package controller;

import model.Field;
import model.Figure;

public class WinContoller {
	public Figure getWinner(final Field field) {
		final int size = field.getSize();
		final Figure[][] fig = field.getField();
		// check col
		for (int i = 0; i < size; i++) {
			if (fig[i][0] == fig[i][1] && fig[i][1] == fig[i][2])
				return field.getFigure(i, 2);
			
		}
		
		// check row
		for (int i = 0; i < size; i++) {
			if (fig[0][i] == fig[1][i] && fig[1][i] == fig[2][i]) return field.getFigure(2, i);
		}
		
		// check diagonal
		if (fig[0][0] == fig[1][1] && fig[1][1] == fig[2][2]) {
			return field.getFigure(1, 1);
		}
		
		
		// check diagonal 2
		if (fig[2][0] == fig[1][1] && fig[1][1] == fig[0][2]) {
			return field.getFigure(1, 1);
		}
		return null;
		
	}
	
	
}
