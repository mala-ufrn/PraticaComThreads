package modelos;

import threads.WorkerThread3;

public class ConcorrenteFixo extends MultiplicaMatrizes {

	private static final int NUMERO_THREADS = 4;
	/**
	 * Multiplica matrixA x matrixB atribuindo uma nova thread de acordo com @const NUMERO_THREADs 
	 */
	protected void execute() {
		try {
			matrixC = new Integer[matrixA.length][matrixA.length];
			WorkerThread3[] threads = new WorkerThread3[NUMERO_THREADS]; // Criando as threads

			for (int i = 0; i < NUMERO_THREADS; i++) {
				threads[i] = new WorkerThread3(i, NUMERO_THREADS, matrixA, matrixB, matrixC);
				threads[i].start();
			}

			for (int i = 0; i < NUMERO_THREADS; i++) {
				threads[i].join();
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
