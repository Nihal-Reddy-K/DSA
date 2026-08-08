class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        } 

        solve(0, board, result);

        return result;
    }

    void solve(int row, char[][] board, List<List<String>> result){
        if(row==board.length){
            List<String> solution = new ArrayList<>();

            for(int i=0; i<board.length; i++){
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        for(int col=0; col<board.length;col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';

                solve(row+1, board, result);

                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}