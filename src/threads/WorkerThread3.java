package threads;

public class WorkerThread3 extends Thread {

	private int numThreads;
	private int id;
	private Integer[][] matrixA,matrixB, matrixC;


	public WorkerThread3(int id, int numThreads, Integer[][] matrixA, Integer[][] matrixB, Integer[][] matrixC) {
		this.numThreads= numThreads;
		this.id = id;
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
	}

	@Override
	public void run() {
		for(int i = id; i < matrixA.length; i += numThreads) {
			for(int j = 0; j < matrixA.length; j++) {
				matrixC[i][j] = 0;
				for(int k=0;k<matrixA.length;k++) {
					matrixC[i][j]+=(matrixA[i][k]*matrixB[k][j]);
				}
			}
		}
	} 
}
