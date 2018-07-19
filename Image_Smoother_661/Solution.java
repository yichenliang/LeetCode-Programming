class Solution {
    
	public int[][] imageSmoother(int[][] M) {
		
		int row = M.length;
		int column = M[0].length;
		int count = 0;
		int[][] res = new int[row][column];
		
		for(int r = 0; r < row; r++) {
			
			for (int c = 0; c < column; c++) {
				count = 0;
				res[r][c] = 0;
				
				for (int localR = r - 1; localR <= r + 1; localR++ ) {
					
					for (int localC = c - 1; localC <= c + 1; localC++) {
						
						if((localR >= 0 && localR < row) && (localC >=0 && localC < column)) {
							res[r][c] += M[localR][localC];
							count++;
						}
					}
				}
				
				res[r][c] /= count;
			}
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] rep = solution.imageSmoother(input);
		System.out.println(rep);
	}
}
