public class Main{
  // Recursive brute force , time complexity is O(kⁿ)
   public int solve1(int[][] costs, int i, int prevColor) {
    if (i == costs.length) return 0;

    int minCost = Integer.MAX_VALUE;
    for (int color = 0; color < costs[0].length; color++) {
        if (color != prevColor) {
            int cost = costs[i][color] + solve(costs, i + 1, color);
            minCost = Math.min(minCost, cost);
        }
    }
    return minCost;
 }
  //
 public int solve2(int[][] costs) {
   //optimized approach with time complexity O(n*k)
    int n = costs.length, k = costs[0].length;
    int min1 = -1, min2 = -1;

    for (int i = 0; i < n; i++) {
        int lastMin1 = min1, lastMin2 = min2;
        min1 = -1; min2 = -1;

        for (int j = 0; j < k; j++) {
            if (i > 0) {
                if (j != lastMin1) {
                    costs[i][j] += costs[i - 1][lastMin1];
                } else {
                    costs[i][j] += costs[i - 1][lastMin2];
                }
            }

            // updating min1 and min2 for current row
            if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                min2 = min1;
                min1 = j;
            } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                min2 = j;
            }
        }
    }
    return costs[n - 1][min1];
 }
}
}
