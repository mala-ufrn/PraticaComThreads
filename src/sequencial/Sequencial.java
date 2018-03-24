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

	public void execute() {
		
	}
}
