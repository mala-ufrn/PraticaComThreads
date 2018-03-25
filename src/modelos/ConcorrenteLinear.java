package modelos;

import threads.WorkerThread2;

public class ConcorrenteLinear extends MultiplicaMatrizes {

	protected void execute() {

		try {
			matrixC = new Integer[matrixA.length][matrixA.length];
			WorkerThread2[] threads = new WorkerThread2[matrixA.length]; // Criando as threads

			for (int i = 0; i < matrixA.length; i++) {
				threads[i] = new WorkerThread2(i, matrixA, matrixB, matrixC);
				threads[i].start();
			}

			for (int i = 0; i < matrixA.length; i++) {
				threads[i].join();
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}



	}
}
