package main;

import java.util.ArrayList;

import modelos.Concorrente;
import modelos.Sequencial;
import utils.Reader;
import utils.Writer;

public class Main {

	public static void main(String[] args) {

		String resource1 = "matrizes/A" + args[0] + "x" + args[0] + ".txt";
		String resource2 = "matrizes/B" + args[0] + "x" + args[0] + ".txt";
		String targetFile = "resultado/C" + args[0] + "x" + args[0] + ".txt";
		
		ArrayList<ArrayList<Integer>> matrixA = null;
		ArrayList<ArrayList<Integer>> matrixB = null;
		ArrayList<ArrayList<Integer>> matrixC = null;

		Reader reader1 = new Reader(resource1);
		Reader reader2 = new Reader(resource2);
		
		Writer writer = new Writer(targetFile);

		try {
			matrixA = reader1.readFile();
			matrixB = reader2.readFile();

			switch (args[1].toUpperCase()) {
			case "S":
				Sequencial sequencial = new Sequencial();
				matrixC = sequencial.multiplicar(matrixA, matrixB);
				break;
			case "C":
				Concorrente concorrente = new Concorrente();
				matrixC = concorrente.multiplicar(matrixA, matrixB);
				break;
			default:
				System.out.println("O que você está fazendo?");
			}
			
			writer.writeFile(matrixC);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
