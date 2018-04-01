package modelos;

/**
 * Classe para execu��o da multiplica��o de matrizes no modelo Sequ�ncial
 * @author Paulo & Hugo
 *
 */
public class Sequencial extends MultiplicaMatrizes {
	
	/**
	 * Multiplica matrixA x matrixB
	 */
	protected void execute() {
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
}
