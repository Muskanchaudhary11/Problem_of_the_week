class Solution {
    public boolean wordSearch(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check rows
        for (int r = 0; r < rows; r++) {
            StringBuilder rowStr = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                rowStr.append(matrix[r][c]);
            }
            if (rowStr.toString().contains(word)) return true;
        }

        // Check columns
        for (int c = 0; c < cols; c++) {
            StringBuilder colStr = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                colStr.append(matrix[r][c]);
            }
            if (colStr.toString().contains(word)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] matrix = {
            {'F', 'A', 'C', 'I'},
            {'O', 'B', 'Q', 'P'},
            {'A', 'N', 'O', 'B'},
            {'M', 'A', 'S', 'S'}
        };

        System.out.println(sol.wordSearch(matrix, "FOAM")); // true
        System.out.println(sol.wordSearch(matrix, "MASS")); // true
        System.out.println(sol.wordSearch(matrix, "FACE")); // false
    }
}

/*
Complexity:
------------
Time:  O(M × N)   (M rows, N cols, each cell visited once while building strings)
Space: O(max(M, N)) for row/col string building
*/
