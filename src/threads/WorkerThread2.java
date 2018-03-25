package threads;

public class WorkerThread2 extends Thread {
	private int i;
	private Integer[][] matrixA,matrixB, matrixC;
	
	
	public WorkerThread2(int i, Integer[][] matrixA, Integer[][] matrixB, Integer[][] matrixC) {
		this.i= i;
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
	}
	
	@Override
	public void run() {
		for(int j=0;j<matrixA.length;j++) {
			matrixC[i][j] = 0;
			for(int k=0;k<matrixA.length;k++) {
				matrixC[i][j]+=(matrixA[i][k]*matrixB[k][j]);
			}
		}
    } 
}
