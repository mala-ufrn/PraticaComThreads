package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class Concorrente {

	private Integer[][] matrixA;
	private Integer[][] matrixB;
	private Integer[][] matrixC;

	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

		// TODO pegar o tempo de início e fim
		try {
			execute();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getResultArray();
	}

	private void execute() throws InterruptedException {
		matrixC = new Integer[matrixA.length][matrixA.length];
		WorkerThread[][] threads = new WorkerThread[matrixA.length][matrixA.length]; // Criando as threads

		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				matrixC[i][j] = 0;
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
