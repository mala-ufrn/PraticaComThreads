package main;

import java.util.ArrayList;

import sequencial.Sequencial;
import utils.Reader;

public class Main {

	public static void main(String[] args) {

		String resource1 = "Matrizes/A" + args[0] + "x" + args[0] + ".txt";
		String resource2 = "Matrizes/B" + args[0] + "x" + args[0] + ".txt";
		ArrayList<ArrayList<Integer>> matrixA;
		ArrayList<ArrayList<Integer>> matrixB;

		Reader reader1 = new Reader(resource1);
		Reader reader2 = new Reader(resource2);

		try {
			matrixA = reader1.readFile();
			matrixB = reader2.readFile();

			switch (args[1]) {
			case "S":
				Sequencial s = new Sequencial();
				s.multiplicar(matrixA, matrixB);
				break;
			case "C":
				// TODO Estratégia Concorrente
			default:
				System.out.println("O que você está fazendo?");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
