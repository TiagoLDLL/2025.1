package main;

import java.util.Scanner;

public class InputManager {

	final static Scanner INPUT = new Scanner(System.in);
	
	public String getString() {
		while(true) {
			String string = INPUT.nextLine().trim();
			if(!string.isEmpty() && !string.isBlank()) {
				return string;
			}
			System.out.print("\nInválido, tente novamente: ");
		}
	}
	
	public double getDouble () {
		while(true) {
			try {
				double doubleVar = INPUT.nextDouble();	
				doubleVar = Math.round(doubleVar * 100.0) / 100.0;
				if(doubleVar <= 0) {
					throw new Exception();
				} 
				INPUT.nextLine();
				return doubleVar;
			} catch(Exception e) {
				System.out.print("\nValor inválido, tente novamente: ");
				INPUT.nextLine();
			}
		}
	}
	
	public int getInt() {
		while(true) {
			try {
				int intVar = INPUT.nextInt();
				if(intVar < 0) {
					throw new Exception();
				}
				INPUT.nextLine();
				return intVar;
			} catch (Exception e) {
				System.out.print("\nValor inválido, tente novamente: ");
				INPUT.nextLine();
			}
		}
	}
	
	public void cleanBuffer() {
		INPUT.nextLine();
	}
}
