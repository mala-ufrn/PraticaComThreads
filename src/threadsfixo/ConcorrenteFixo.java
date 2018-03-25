package threadsfixo;

import java.util.ArrayList;
import java.util.Arrays;

public class ConcorrenteFixo {
	private final int NUMERO_THREADS = 4;
	private Integer[][] matrixA;
	private Integer[][] matrixB;
	private Integer[][] matrixC;
	Thread[] threads = new Thread[NUMERO_THREADS] ;

	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

		this.matrixC = new Integer[this.matrixA.length][this.matrixA.length];

		long startTime = System.nanoTime();
		
		try {
			execute();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime = System.nanoTime();
		System.out.println("Tempo de execucao da: "+ (endTime - startTime) / 1000000 + " miliseconds.");

		return getResultArray();
	}

	private void execute() throws InterruptedException {
		
		for (int i = 0; i < this.matrixA.length; i++) {
			for (int j = 0; j < this.matrixA.length; j++) {
				this.matrixC[i][j] = 0;
			}
		}
			threads[0] = new WorkerThread1(this.matrixA, this.matrixB, this.matrixC);
			threads[1] = new WorkerThread2(this.matrixA, this.matrixB, this.matrixC);
			threads[2] = new WorkerThread3(this.matrixA, this.matrixB, this.matrixC);
			threads[3] = new WorkerThread4(this.matrixA, this.matrixB, this.matrixC);

			threads[0].start();
			threads[1].start();
			threads[2].start();
			threads[3].start();

			threads[0].join();
			threads[1].join();
			threads[2].join();
			threads[3].join();
	}

	private ArrayList<ArrayList<Integer>> getResultArray() {

		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();

		for (Integer[] linha : matrixC) {
			resultArray.add(new ArrayList<Integer>(Arrays.asList(linha)));
		}
		return resultArray;
	}
}
