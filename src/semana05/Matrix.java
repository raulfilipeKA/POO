package semana05;

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        if(matrix == null){
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[0].length != matrix[i].length){
                throw new IllegalArgumentException("Matriz nao algebrica");
            }
        }
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void ZeroMatrix(int i, int j){
        int[][] Matrix = new int[i][j];
        for(int x = 0; x < i; x++){
            for(int y = 0; y < j; y++){
                Matrix[x][y] = 0;
            }
        } new Matrix(Matrix);
    }
    public void squareMatrix(int i){
        ZeroMatrix(i, i);
    }

    public int getLineCount(){
        return matrix.length;
    }
    public int getColumnCount(){
        return matrix[0].length; //Para matrizes algebricas, todas as linhas tem o mesmo numero de colunas
    }
    public void changeValue(int i, int j, int value){
        if(!validate(i, j)){
            throw new IllegalArgumentException("Invalid index");
        }
        matrix[i][j] = value;
    }
    public int getValue(int i, int j){
        if(!validate(i, j)){
            throw new IllegalArgumentException("Invalid index");
        }
        return matrix[i][j];
    }

    public void multiplyBy(int value){
        for(int i = 0; i < getLineCount(); i++){
            for(int j = 0; j < getColumnCount(); j++){
                matrix[i][j] *= value;
            }
        }
    }

    public boolean sameSameDim(Matrix m){
        return (m.getLineCount() == getLineCount()) && (m.getColumnCount() == getColumnCount());
    }

    public boolean sameDim(Matrix m){
        return (m.getLineCount()*m.getColumnCount()) == (getLineCount()*getColumnCount());
    }

    private boolean validate(int i , int j){
        return i >= 0 && i < getLineCount() && j >= 0 && j < getColumnCount();
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < getLineCount(); i++){
            for(int j = 0; j < getColumnCount(); j++){
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

}
