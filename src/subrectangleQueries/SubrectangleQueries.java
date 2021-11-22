package subrectangleQueries;

/*
Runtime: 47 ms, faster than 12.76% of Java online submissions for Subrectangle Queries.
Memory Usage: 52.1 MB, less than 7.01% of Java online submissions for Subrectangle Queries.
 */
public class SubrectangleQueries {

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                rectangle[i][j]=newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
