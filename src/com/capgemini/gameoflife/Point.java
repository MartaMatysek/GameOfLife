package com.capgemini.gameoflife;

/**
 *  Point to klasa przechowująca punkty reprezentowane przez współrzędne (x,y)
 */

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
			this.x = x;
			this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * isInBoard to metoda, która sprawdza, czy nasz punkt znajduje się w tablicy o zadanej ilości wierszy i kolumn
	 * @param xBoard ilość wierszy tablicy
	 * @param yBoard ilość kolumn tablicy
	 * @return
	 */
	
	public boolean isInBoard(int xBoard, int yBoard){
		if( (this.x > -1 && this.x < xBoard+1) && (this.y > -1 && this.y < yBoard+1) ){
			return true;
		}
		else{
			return false;			
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}