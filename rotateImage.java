class rotateImage{
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);   
    }
    void transpose(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for(int j=i;j<matrix.length;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }
    void reflect(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=t;
            }
        }
    }
}