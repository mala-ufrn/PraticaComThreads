package modelos;

/**
 * Classe para execução da multiplicação de matrizes no modelo Sequêncial
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
