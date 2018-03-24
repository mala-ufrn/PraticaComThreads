package sequencial;

import java.util.ArrayList;

public class Sequencial {
	private Integer[][] matrixA;
	private Integer[][] matrixB;

	
	public void multiplicar(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		execute();
	}

	private void execute() {
		Integer[][] matrixC = new Integer[matrixA.length][matrixA.length];
		int i, j;
		System.out.println("=== Matrix C ===");
		for(i=0;i<matrixA.length;i++){
	        for(j=0;j<matrixA.length;j++)
	            matrixC[i][j]=(matrixA[i][j]*matrixB[j][i]);
	    }
		
		
		for (i = 0; i < matrixC.length; i++) {
			for (j = 0; j < matrixC.length; j++) {
				System.out.print(matrixC[i][j]);
			}
			System.out.println("");
		}
		
	}
}
