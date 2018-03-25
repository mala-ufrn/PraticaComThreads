package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class Concorrente {

	private Integer[][] matrixA;
	private Integer[][] matrixB;
	private Integer[][] matrixC;
	WorkerThread[][] threads = null;

	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

		this.matrixC = new Integer[this.matrixA.length][this.matrixA.length];
		threads = new WorkerThread[this.matrixA.length][this.matrixA.length]; // Criando as threads

		// TODO pegar o tempo de início e fim
		try {
			long startTime = System.nanoTime();
			execute();
			long endTime = System.nanoTime();
			System.out.println("Tempo de execu��o da "+ (endTime - startTime) / 1000000 + " miliseconds.");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getResultArray();
	}

	private void execute() throws InterruptedException {

		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				threads[i][j] = new WorkerThread(i, j, matrixA, matrixB, matrixC);
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
