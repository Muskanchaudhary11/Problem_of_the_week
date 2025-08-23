class Solution {
    public void floodFill(char[][] image, int sr, int sc, char newColor) {
        char original = image[sr][sc];
        if (original == newColor) return; // agar same color h to kuch change nhi

        dfs(image, sr, sc, original, newColor);
    }

    private void dfs(char[][] image, int r, int c, char original, char newColor) {
        // boundary check + color match check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length 
            || image[r][c] != original) {
            return;
        }

        image[r][c] = newColor; // repaint current pixel

        // explore 4 directions
        dfs(image, r + 1, c, original, newColor); // down
        dfs(image, r - 1, c, original, newColor); // up
        dfs(image, r, c + 1, original, newColor); // right
        dfs(image, r, c - 1, original, newColor); // left
    }
}

/*
Time Complexity:  O(n * m)
   -> In worst case, every pixel is visited once.

Space Complexity: O(n * m)
   -> Due to recursion stack (DFS can go as deep as all cells).
*/
