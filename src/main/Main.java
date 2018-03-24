package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import utils.Reader;

public class Main {
	
	public static void main(String[] args) {
		
		String resource1 = "Matrizes/A" + args[0] + "x" + args[0] + ".txt";
		String resource2 = "Matrizes/B" + args[0] + "x" + args[0] + ".txt";
		
		Reader reader1 = new Reader(resource1);
		Reader reader2 = new Reader(resource2);
		
		try {
			ArrayList<ArrayList<Integer>> matrix1 = reader1.readFile();
			ArrayList<ArrayList<Integer>> matrix2 = reader2.readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
