public class ConnectFourModel {

    public void fillColumn(int column, int[][] matrix, int player) {

        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][column] == 0) {
                if (player == 1) {
                    matrix[i][column] = 1;
                    break;
                }
                if (player == 0) {
                    matrix[i][column] = 2;
                    break;
                }
            }
        }

    }

    public boolean draw(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(int player, int[][] matrix) {
        int count;

        // Row
        for (int i = 0; i < matrix.length; i++) {
            count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != player) { count = 0; }
                else { count++; }
                if (count == 4) { return true; }
            }
        }
        // column
        for (int i = 0; i < matrix[0].length; i++) {
            count = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != player) { count = 0; }
                else { count++; }
                if (count == 4) { return true; }
            }
        }

        // Kontrollimi per fitues ne diagonalen  e majte
        for (int i = 0; i < matrix.length; i++) {
            count = 0;
            for (int j = i + 1, k = 1; j < matrix.length && k < matrix[j].length;
                 j++, k++) {
                if (matrix[j][k] != player) { count = 0; }
                else { count++; }
                if (count == 4) { return true; }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            count = 0;
            for (int j = 1, k = i + 1; j < matrix.length && k < matrix[j].length;
                 j++, k++) {
                if (matrix[j][k] != player) { count = 0; }
                else { count++; }
                if (count == 4) { return true; }
            }
        }

        // Kontrollimi per fitues ne diagonalen  e majte
        for (int i = 0; i < matrix.length; i++) {
            count = 0;
            for (int j = i + 1, k = matrix[i].length - 2; j < matrix.length &&
                    k >= 0; j++, k--) {
                if (matrix[j][k] != player) { count = 0; }
                else { count++; }
                if (count == 4) { return true; }
            }
        }

        for (int i = matrix[0].length - 2; i >= 0; i--) {
            count = 0;
            for (int j = 1, k = i - 1; j < matrix.length && k >= 0; j++, k--) {
                if (matrix[j][k] != player) { count = 0; }
                else { count++; }
                if (count == 4) { return true; }
            }
        }


        return false;
    }

}
