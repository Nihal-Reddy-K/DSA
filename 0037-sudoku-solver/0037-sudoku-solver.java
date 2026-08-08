class Solution {
    public void solveSudoku(char[][] board) {
        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[] boxes = new HashSet[9];

        for(int i=0; i<=8; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    rows[i].add(num);
                    cols[j].add(num);

                    int box = (i/3)*3 + j/3;
                    boxes[box].add(num);
                }
            }
        }

        solve(board, rows, cols, boxes);
    }

    public boolean solve(char[][] board, HashSet<Integer>[] rows, HashSet<Integer>[] cols, HashSet<Integer>[] boxes){
        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++){
                if(board[i][j] == '.'){
                    int box = (i/3)*3 + j/3;

                    for(int num=1; num<=9; num++){

                        if(rows[i].contains(num) || cols[j].contains(num) || boxes[box].contains(num)){
                            continue;
                        }

                        board[i][j] = (char)(num + '0');

                        rows[i].add(num);
                        cols[j].add(num);
                        boxes[box].add(num);

                        if(solve(board, rows, cols, boxes)){
                            return true;
                        }

                        board[i][j] = '.';
                        rows[i].remove(num);
                        cols[j].remove(num);
                        boxes[box].remove(num);
                    }

                    return false;
                }
            }
        }

        return true;
    }
}