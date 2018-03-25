package threadsfixo;

public class WorkerThread3 extends Thread {
	private int i, j, k, s;
	private Integer[][] matrixA, matrixB, matrixC;

	public WorkerThread3(Integer[][] matrixA, Integer[][] matrixB, Integer[][] matrixC) {

		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
		this.k = ((3*matrixA.length) / 4)+1;
		this.s = ((matrixA.length) / 2) + 1;
	}

	@Override
	public void run() {
		for (int i = s; i < k; i++) {
			for (int j = 0; j < matrixB.length; j++) {
				for (k = 0; k < matrixB.length; k++) {
					matrixC[i][j] += (matrixA[i][k] * matrixB[k][j]);
				}
			}
		}

	}

}
