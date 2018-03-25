package threads;

public class WorkerThread1 extends Thread {
	private int i, j;
	private Integer[][] matrixA,matrixB, matrixC;
	
	
	public WorkerThread1(int i, int j, Integer[][] matrixA, Integer[][] matrixB, Integer[][] matrixC) {
		this.i= i;
		this.j = j;
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
	}
	
	@Override
	public void run() {
		matrixC[i][j] = 0;
		for(int k=0;k<matrixA.length;k++) {
			matrixC[i][j]+=(matrixA[i][k]*matrixB[k][j]);
		}
    } 
}
