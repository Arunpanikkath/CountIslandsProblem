package com.oracle;

public class Countislands {
	
	public int countislands(int[][] grid) {
		
		if(grid == null || grid.length ==0) {
			return 0;
		}
		int rows=grid.length;
		int cols=grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int islandcount=0;
		
		for(int row=0;row<rows;row++) {
			for(int col=0;col<cols;col++) {
				if(grid[row][col]==1 &&!visited[row][col]) {
					dfs(grid,row,col,visited);
					islandcount++;
				}
			}
		}
		
		return islandcount;
	
	}

	private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
		if(row<0||row>=grid.length||col<0||col>=grid[0].length||visited[row][col]||grid[row][col]==0) {
			return;
		}
		visited[row][col]=true;
		
		dfs(grid, row-1, col, visited);
		dfs(grid, row+1, col, visited);
		dfs(grid, row, col-1, visited);
		dfs(grid, row, col+1, visited);
		
	}

	public static void main(String[] args) {
		Countislands sol = new Countislands();
		int[][] grid1= {
				{1, 1, 0, 0},
				{1, 0, 0, 1},
				{0, 0, 1, 1},
				{0, 0, 0, 0}
		};
		
		System.out.println("number of islands:"+ sol.countislands(grid1));
		
		int[][] grid2= {
				{1, 1, 0, 0},
				{0, 1, 0, 0},
				{0, 1, 1, 1},
				{0, 0, 0, 1}
		};
		System.out.println("number os islands:"+sol.countislands(grid2));
		
		System.out.println("number os islands:"+sol.countislands(new int[][] {{}}));
		
		System.out.println("number os islands:"+sol.countislands(new int[][] {{1}}));

		System.out.println("number os islands:"+sol.countislands(new int[][] {{1,0,1}}));

		System.out.println("number os islands:"+sol.countislands(new int[][] {{0,0},{0,0}}));

	}

}
