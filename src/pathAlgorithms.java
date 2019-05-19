import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class pathAlgorithms {
    public int[][] bfs(char arr[][],int row ,int column)
    {
        int [][]path = new int[row][column];
        boolean startPoint = false;
        boolean [][]visited = new boolean[row][column];
        int i=0,j=0;
        for( i = 0;i<row  ;i++)
        {
            for( j = 0 ; j<column; j++)
            {
                if(arr[i][j] == 'S')
                {
                    startPoint = true;
                    break;
                }
            }
            if(startPoint)
                break;
        } // end the search of the start point
        Queue<Point> q = new LinkedList<Point>() ;
        Point tmp = new Point(i,j); /// start index
        q.add(tmp);
        visited[i][j] = true;
        while(q.isEmpty() == false )
        {
            tmp = getNeighbour(arr,i,j,visited);
            if(tmp.x == -1)
            {
                tmp = q.poll();
                System.out.println(tmp.x+","+tmp.y);
                if(!q.isEmpty())
                {
                    i = q.peek().x;
                    j = q.peek().y;
                }

                // dequeue element
            }else{
                q.add(tmp);
                visited[tmp.x][tmp.y] = true;

            }
        }







        return path;
    }
    public Point getNeighbour(char arr[][],int i,int j,boolean [][]visited)
    {
        if(valid(arr,i,j) == true )
        {
            if(valid(arr,i,j+1) &&visited[i][j+1] == false && arr[i][j+1] != '#')
            {
                return new Point (i,j+1);
            }else  if(valid(arr,i+1,j) &&visited[i+1][j] == false && arr[i+1][j] != '#')
            {
                return new Point (i+1,j);
            }else  if(valid(arr,i,j-1) &&visited[i][j-1] == false && arr[i][j-1] != '#')
            {
                return new Point (i,j-1);
            }else  if(valid(arr,i-1,j) &&visited[i-1][j] == false && arr[i-1][j] != '#')
            {
                return new Point (i-1,j);
            }
        }
        return new Point(-1,-1); // not found
    }
    boolean valid (char arr[][],int i ,int j)
    {
        int row = arr.length;
        int column = arr[0].length;
        if(i<row && j<column && i>=0 && j>=0)
            return true ;
        return false;
    }
    public int[][] dfs(char arr[][],int row ,int column)
    {
        int [][]path = new int[row][column];
        boolean startPoint = false;
        boolean [][]visited = new boolean[row][column];
        int i=0,j=0;
        for( i = 0;i<row  ;i++)
        {
            for( j = 0 ; j<column; j++)
            {
                if(arr[i][j] == 'S')
                {
                    startPoint = true;
                    break;
                }
            }
            if(startPoint)
                break;
        } // end the search of the start point
        Stack<Point> st = new Stack<Point>() ;
        Point tmp = new Point(i,j); /// start index
        st.push(tmp);
        System.out.println(tmp.x+","+tmp.y);
        visited[i][j] = true;
        while(st.isEmpty() == false )
        {
            i = st.peek().x;
            j = st.pop().y;
            while ((tmp = getNeighbour(arr,i,j,visited) ).x != -1 )
            {
                st.push(tmp);
                System.out.println(tmp.x+","+tmp.y);
                i = tmp.x;
                j = tmp.y;
                visited[i][j] = true;
            }
        }
        return path;
    }
    public int[][] best_fs(char arr[][],int row ,int column)
    {
        int [][]path = new int[row][column];
        return path;
    }


}
