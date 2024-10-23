package semana05;

public class MatrixTest {

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix m = new Matrix(matrix);
        System.out.println(m);

    }

    static Matrix sumAndScale(Matrix a, Matrix b, int scalar){
        Matrix m = sum(a, b);
        m.multiplyBy(scalar);
        return m;
    }

    static Matrix sum(Matrix a, Matrix b){
        if(a.sameSameDim(b)){
            int[][] result = new int[a.getLineCount()][a.getColumnCount()];
            Matrix matrix = new Matrix(result);
            for(int i = 0; i < a.getLineCount(); i++){
                for(int j = 0; j < a.getColumnCount(); j++){
                    matrix.changeValue(i, j, a.getValue(i, j) + b.getValue(i, j));
                }
            }
            return matrix;
        }
        throw new IllegalArgumentException("Matrizes de dimensões diferentes");
    }
}
