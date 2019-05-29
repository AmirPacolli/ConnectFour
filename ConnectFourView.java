public class ConnectFourView {

    public void displayMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) { System.out.print("|R"); }
                else if (matrix[i][j] == 2) { System.out.print("|B"); }
                else { System.out.print("| "); }
            }
            System.out.println("|");
        }
        System.out.println("---------------");


    }

}
