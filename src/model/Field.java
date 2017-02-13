package model;



public class Field {
	
	
	private final Figure[][] field;
	
	private final int fieldSize;
	
	public Field(final int fieldSize)  {
		 
			this.fieldSize = fieldSize;
			field = new Figure[fieldSize][fieldSize];
		 
	}
	
	
	public int getSize() {
		return fieldSize;
	}
	
	public Figure getFigure(int x,int y)   {
		 
		return field[x][y];
	}
	
	public void setFigure(int x,int y, final Figure figure)   {
		 
		field[x][y] = figure;
	}
	
	public  Figure[][] getField() {return field;}
	
}
