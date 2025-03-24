package main;

import java.util.Scanner;

public class InputManager {

	final Scanner INPUT = new Scanner(System.in);
	
	public String getString() {
		while(true) {
			String STRING = INPUT.nextLine().trim();
			if(!STRING.isEmpty() && !STRING.isBlank()) {
				return STRING;
			}
			System.out.print("\nInválido, tente novamente: ");
		}
	}
	
	public double getDouble () {
		while(true) {
			try {
				double DOUBLE = INPUT.nextDouble();	
				DOUBLE = Math.round(DOUBLE * 100.0) / 100.0;
				if(DOUBLE <= 0) {
					throw new Exception();
				} 
				INPUT.nextLine();
				return DOUBLE;
			} catch(Exception e) {
				System.out.print("\nValor inválido, tente novamente: ");
				INPUT.nextLine();
			}
		}
	}
	
	public int getInt() {
		while(true) {
			try {
				int INT = INPUT.nextInt();
				if(INT < 0) {
					throw new Exception();
				}
				INPUT.nextLine();
				return INT;
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
