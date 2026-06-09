class Solution {
    public int uniquePaths(int m, int n) {
        	int[][] grid = new int[m][n];
            return dp(m-1, n-1, grid);
    }

    	public int dp(int i, int j, int[][] memo){
		if (i < 0 || j < 0) { // 구간 유효범위 벗어났을때, 재귀호출에 i-1과 같은 인자를 넘겨주기 때문에 구간을 초과하진 않고 음수되는 부분만 신경써줌
			return 0;
		}

		if (i == 0 && j == 0) { // 초기값 세팅 (0,0)에 서있는 방법 1가지에서 출발
			return 1;
		}

		if (memo[i][j] != 0) { // 메모이제이션 : 저장된 값이 있을경우 해당값 리턴
			return memo[i][j];
		}

		memo[i][j] = dp(i, j-1, memo)  + dp(i-1, j, memo); // 내 현재위치 기준 왼쪽에서 오는거랑 위에서 내려오는거 두개

		return memo[i][j];
	}
}