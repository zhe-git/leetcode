// TC:O(M×N)
// SC:O(M×N)

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int r = grid.length, c = grid[0].length, count = 0;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        int r = grid.length, c = grid[0].length;
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == '0') return;
        
        // set '0' means that we have visited
        grid[i][j] = '0';
        
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}