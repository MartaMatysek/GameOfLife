package com.capgemini.gameoflife;

import java.util.HashSet;
import java.util.Set;

/**
 * GameOfLife to klasa reprezentująca grę Game Of Life z uwzględnieniem wszystkich zasach i zachowań.
 * Zawiera xSize i ySize, które odpowiadają liczbie wierszy i kolumn w tablicy oraz zbiór aktialnych punktów z klasy {@link Point}. 
 */

public class GameOfLife {

	private int xSize;
	private int ySize;
	private Set<Point> activeCells = new HashSet<Point>();
	
	public GameOfLife(int xSize, int ySize, Set<Point> activeCells) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.activeCells = activeCells;
	}

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}
	
	/**
	 * scoreGame to metoda zwracająca ostateczny zbiór punktów w następnej generacji na podstawie stanu obcenego.
	 * Wykorzystuje do tego metody {{@link #findDeathCellsInNextGeneration(Set)} oraz {{@link #findNewBornCellsInNextGeneration(Set)}.
	 * @return zbiór punktów
	 */

	public Set<Point> scoreGame() {
		Set<Point> deathCells = findDeathCellsInNextGeneration(activeCells);
		Set<Point> bornCells = findNewBornCellsInNextGeneration(activeCells);
		activeCells.removeAll(deathCells);
		activeCells.addAll(bornCells);

		return activeCells;
	}
	
	/**
	 * findDeathCellsInNextGeneration tworzy zbiór punktów, które nie pojawią się w zbiorze w następnej generacji
	 * @param points zbiór puntów dla których sprawdzamy sprawdzamy dalszą żywotność
	 *               poprzez wywołanie na nich metody {{@link #checkIsStayAllive(Point)}.
	 * @return zbiór punktów
	 */

	private Set<Point> findDeathCellsInNextGeneration(Set<Point> points) {
		Set<Point> deathCells = new HashSet<Point>();

		for (Point p : points) {
			if (!checkIsStayAllive(p))
				deathCells.add(p);
		}
		return deathCells;
	}
	
	/**
	 * checkIsStayAllive sprawdza, czy dany punkt zostanie w następnej generacji
	 * @param point punkt dla którego sprawdzamy żywotność na podstawie ilości sąsiadów z metody {{@link #countNumberOfNeighbours(Point)}.
	 * @return true, jeśli liczba podbliskich punktów jest równa 2 lub 3, false w przeciwnym wypadku
	 */

	private boolean checkIsStayAllive(Point point) {
		int numberOfNeighbours = countNumberOfNeighbours(point);

		if (numberOfNeighbours == 2 || numberOfNeighbours == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * findNewBornCellsInNextGeneration tworzy zbiór Punktów, które pojawią się w następnej generacji.
	 * Wykorzystuje do tego metodę {{@link #checkIsBorn(Point)}.
	 * @param points zbiór punktów, dla których sprawdzamy, czy pojawią się w następnej generacji
	 * @return zbiór punktów
	 */

	private Set<Point> findNewBornCellsInNextGeneration(Set<Point> points) {
		Set<Point> newBornCells = new HashSet<Point>();

		for (Point p : points) {
			int x = p.getX();
			int y = p.getY();

			for (int i = x - 1; i < x + 2; i++) {
				for (int j = y - 1; j < y + 2; j++) {
					Point temp = new Point(i, j);
					if (checkIsBorn(temp))
						newBornCells.add(temp);
				}
			}
		}
		return newBornCells;
	}
	
	/**
	 * checkIsBorn to metoda, która sprawdza, czy dany Punkt pojawi się w następnej generacji. 
	 * Wykorzystuje do tego metodę {{@link #countNumberOfNeighbours(Point)}.
	 * @param point punkt którego stan sprawdzamy
	 * @return prawda, jeśli punkt ma 3 sąsiadów, fałsz- w przeciwnym razie
	 */

	private boolean checkIsBorn(Point point) {
		int numberOfNeighbours = countNumberOfNeighbours(point);

		if (numberOfNeighbours == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * countNumberOfNeighbours sprawdza, ile obiektów jest w pobliżu zadanego Punktu(x,y)
	 * @param point punkt dla którego sprawdzamy liczbę punktów znajdujących się z pobliżu
	 * @return liczba punktów znajdujących się w pobliżu
	 */

	private int countNumberOfNeighbours(Point point) {
		int numberOfNeighbours = 0;
		int x = point.getX();
		int y = point.getY();

		for (int i = x - 1; i < x + 2; i++) {
			for (int j = y - 1; j < y + 2; j++) {
				Point temp = new Point(i, j);
				if (activeCells.contains(temp) && temp.isInBoard(xSize, ySize) && !temp.equals(point)) {
					numberOfNeighbours++;
				}
			}
		}
		return numberOfNeighbours;
	}

}
