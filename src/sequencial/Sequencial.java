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
		
		System.out.println("---------Matriz C----------");
		
		for(int i=0;i<matrixA.length;i++) {
			for(int j=0;j<matrixA.length;j++) {
				matrixC[i][j] = 0;
				for(int k=0;k<matrixA.length;k++) {
					matrixC[i][j]+=(matrixA[i][k]*matrixB[k][j]);
				}
			}
	    }
		
		for (int i = 0; i < matrixC.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matrixC.length; j++) {
				String aux = j == matrixC.length-1? "]\n" : ", ";
				System.out.print(matrixC[i][j] + aux);
			}
			
		}
		
	}
}
