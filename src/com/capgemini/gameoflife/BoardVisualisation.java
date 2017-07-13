package com.capgemini.gameoflife;

import java.util.Set;

/**
 * BoardVisualisation to klasa zawierająca metodę wyświetlająca tablicę Punktów
 * @author MMATYSEK
 *
 */

public class BoardVisualisation {
	
	/**
	 * makeVisualisation wyświetla tablicę Punktów jako + lub - w zależności od stanu danego punktu
	 * @param xSize liczba wierszy w tablicy
	 * @param y liczba kolumn w tablicy
	 * @param activeCells
	 */
	
	public static void makeVisualisation(int xSize, int ySize, Set<Point> activeCells){
		GameOfLife gol = new GameOfLife(xSize,ySize,activeCells);
		activeCells = gol.scoreGame();
		
		String message = "";
		for(int i = 0; i < xSize; i++){
			for(int j = 0; j < ySize; j++){
				Point p =new Point(i,j);
				if(activeCells.contains(p)){
					message += "+ ";
				}
				else{
					message += "- ";
				}
			}
			message += System.lineSeparator();
		}
			
		System.out.println(message);
	}
}
