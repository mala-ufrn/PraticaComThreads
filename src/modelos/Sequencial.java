package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class Sequencial {
	
	private Integer[][] matrixA;
	private Integer[][] matrixB;
	private Integer[][] matrixC;
	
	
	public ArrayList<ArrayList<Integer>> multiplicar(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {
		this.matrixA = matrixA.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		this.matrixB = matrixB.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
		
		long startTime = System.nanoTime();
		
		execute();
		
		long endTime = System.nanoTime();
		System.out.println("Tempo de execu��o: " + (endTime - startTime)/1000000 + " miliseconds." );
		return getResultArray();
	}

	private void execute() {
		matrixC = new Integer[matrixA.length][matrixA.length];
		
		for(int i=0;i<matrixA.length;i++) {
			for(int j=0;j<matrixA.length;j++) {
				matrixC[i][j] = 0;
				for(int k=0;k<matrixA.length;k++) {
					matrixC[i][j]+=(matrixA[i][k]*matrixB[k][j]);
				}
			}
	    }
	}
	
	private ArrayList<ArrayList<Integer>> getResultArray() {
		
		ArrayList<ArrayList<Integer>> resultArray = new ArrayList<ArrayList<Integer>>();
		
		for (Integer[] linha : matrixC) {
			resultArray.add(new ArrayList<Integer>(Arrays.asList(linha)));
		}
		return resultArray;
	}
}
