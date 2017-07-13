package com.capgemini.gameoflife;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * UserManager to klasa, która odpowiada za kontakt z użytkownikiem i pobranie danych 
 * (tj liczba puntów, rozmiat tablicy, ilość generacji) potrzebnych do wykonania się gry.
 */

public class UserManager {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		Set<Point> points = new HashSet<Point>();
		Random random = new Random();
		
		System.out.println("All numbers must be greater then 0!");
		System.out.println("Enter a number of points to create set of points: ");
		int numberOfPoints = sc.nextInt();
		System.out.println("Enter a size of board. First enter a number of rows: ");
		int rowsBoard = sc.nextInt();
		System.out.println("Enter a number of columns: ");
		int columnsBoard = sc.nextInt();
		System.out.println("Enter a number of generations in Game Of Life: ");
		int numberOfGeneration = sc.nextInt();
		
		for(int i= 0; i< numberOfPoints; i++){
			points.add(new Point(random.nextInt(rowsBoard), random.nextInt(columnsBoard)));		
		}		
	
		for (int i = 0; i < numberOfGeneration; i++) {
			Thread.sleep(500);
			BoardVisualisation.makeVisualisation(rowsBoard, columnsBoard, points);
		}
	}

}
