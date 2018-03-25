package modelos;

import threads.WorkerThread1;

public class ConcorrenteQuadrado extends MultiplicaMatrizes {

	protected void execute() {

		try {
			matrixC = new Integer[matrixA.length][matrixA.length];
			WorkerThread1[][] threads = new WorkerThread1[matrixA.length][matrixA.length];

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
		}catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
