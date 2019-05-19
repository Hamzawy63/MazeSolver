public class myMain {
    public static void main(String[] args) {
        char [][]arr = {
                {'#','#','.','.','S'},
                {'0','0','#','0','0'},
                {'0','#','#','0','0'},
                {'E','0','0','0','0'},
                {'0','0','#','#','#'}
        };
        char [][]arr2 = {
                {'#','#','S'},
                {'0','0','#'},
                {'0','#','#'},
                {'E','0','0'},
                {'0','0','#'}
        };

        for( int i = 0;i<5  ;i++)
        {
            for( int j = 0 ; j<5; j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        } // end the search of the start point
        pathAlgorithms search = new pathAlgorithms();
        search.dfs(arr,5,5);
    }
}
