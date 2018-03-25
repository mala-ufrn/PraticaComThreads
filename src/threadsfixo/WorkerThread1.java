package threadsfixo;

public class WorkerThread1 extends Thread {
	private int k;
	private Integer[][] matrixA, matrixB, matrixC;
	
	
	public WorkerThread1(Integer[][] matrixA, Integer[][] matrixB, Integer[][] matrixC) {
		
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
		this.k = matrixA.length / 4;
		
	}

	@Override
	public void run() {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < matrixB.length; j++) {
				for (k = 0; k < matrixB.length; k++) {
					matrixC[i][j] += (matrixA[i][k] * matrixB[k][j]);
				}
			}
		}

	}

}
