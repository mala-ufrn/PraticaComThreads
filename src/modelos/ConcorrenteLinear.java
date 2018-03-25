package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class ConcorrenteLinear {
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
			e.printStackTrace();
		}

		return getResultArray();
	}

	private void execute() throws InterruptedException {
		matrixC = new Integer[matrixA.length][matrixA.length];
		WorkerThread2[] threads = new WorkerThread2[matrixA.length]; // Criando as threads

		for (int i = 0; i < matrixA.length; i++) {
			threads[i] = new WorkerThread2(i, matrixA, matrixB, matrixC);
			threads[i].start();
		}

		for (int i = 0; i < matrixA.length; i++) {
			threads[i].join();
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
