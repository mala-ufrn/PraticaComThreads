package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class ConcorrenteQuadrado {

	private Integer[][] matrixA;
	private Integer[][] matrixB;
	private Integer[][] matrixC;

	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

		long startTime = System.nanoTime();
		
		try {
			execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.nanoTime();
		System.out.println("Tempo de execucao da: "+ (endTime - startTime) / 1000000 + " miliseconds.");

		return getResultArray();
	}

	private void execute() throws InterruptedException {
		matrixC = new Integer[matrixA.length][matrixA.length];
		WorkerThread1[][] threads = new WorkerThread1[matrixA.length][matrixA.length]; // Criando as threads

		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				matrixC[i][j] = 0;
				threads[i][j] = new WorkerThread1(i, j, matrixA, matrixB, matrixC);
				threads[i][j].start();
			}
		}
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				threads[i][j].join();
			}
		}
		

	}

	private ArrayList<ArrayList<Integer>> getResultArray() {

		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();

		for (Integer[] linha : matrixC) {
			resultArray.add(new ArrayList<Integer>(Arrays.asList(linha)));
		}
		return resultArray;
	}
}
