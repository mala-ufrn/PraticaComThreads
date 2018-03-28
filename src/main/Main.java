package main;

import java.util.ArrayList;

import modelos.ConcorrenteFixo;
import modelos.ConcorrenteLinear;
import modelos.ConcorrenteQuadrado;
import modelos.Sequencial;
import utils.Reader;
import utils.Writer;

public class Main {
	
	/**
	 * M�todo Principal
	 * @param args
	 */

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
				matrixC = sequencial.multiplicar(matrixA, matrixB, args);
				break;
			case "C1":
				ConcorrenteQuadrado concorrenteQuadrado = new ConcorrenteQuadrado();
				matrixC = concorrenteQuadrado.multiplicar(matrixA, matrixB, args);
				break;
			case "C2":
				ConcorrenteLinear concorrenteLinear = new ConcorrenteLinear();
				matrixC = concorrenteLinear.multiplicar(matrixA, matrixB, args);
				break;
			case "C3":
				ConcorrenteFixo concorrenteFixo = new ConcorrenteFixo();
				matrixC = concorrenteFixo.multiplicar(matrixA, matrixB, args);
				break;
			default:
				System.out.println("O que você está fazendo?");
				System.exit(0);
			}
			
			writer.writeFile(matrixC);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
