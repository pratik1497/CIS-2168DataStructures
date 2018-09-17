
package maze;

/**
 *
 * @author pratik patel
 */
import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class DepthFirst
{       
    private InputGraphicMaze maze;
    private int R, C; 
   //YOU'LL NEED TO ADD MORE CODE HERE!!!!!!! 
    //A list of what has been visted
    private LinkedList<Point> v;
    
    public DepthFirst() 
    {  
        System.out.println("Depth First Search");
       // an R rows x C columns maze
       maze = new InputGraphicMaze();
       R=maze.Rows(); C=maze.Cols(); 
       //Creates space in memory for visted
       v=new LinkedList<>();
       // Path holds the cells of the path
       LinkedList<Point> Path = new LinkedList<>();
       // Create the path
       CreatePath(maze, 1, 1, R, C, Path);
       Path.addFirst(new Point(1,1));

       // show the path in the maze
       maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePath(InputGraphicMaze maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        boolean notdone=true;
         // YOUR CODE FOR THE PATH GENERATION GOES HERE!!!!!!!
        v.addLast(new Point(srow,scol));
        if((srow!=erow )|| (scol!=ecol))
        {
              if (notdone && (srow>1)&&(!v.contains(new Point(srow-1,scol)))&&(maze.can_go(srow, scol,'U')) &&
                      CreatePath(maze,srow-1,scol,erow,ecol,L))
                       {L.addLast(new Point(srow-1,scol));notdone=false;}
              else 
                       {while(!v.peekLast().equals(new Point(srow,scol))) v.removeLast();}
             
              if (notdone &&(scol<C)&&(!v.contains(new Point(srow,scol+1)))&&(maze.can_go(srow, scol,'R'))
                      && CreatePath(maze,srow,scol+1,erow,ecol,L))
                            {L.addLast(new Point(srow,scol+1));notdone=false;}
              else
                       {while(!v.peekLast().equals(new Point(srow,scol))) v.removeLast();}
                  
              
              if (notdone &&(srow<R)&&(!v.contains(new Point(srow+1,scol)))&&(maze.can_go(srow, scol, 'D'))&&
                       CreatePath(maze,srow+1,scol,erow,ecol,L))             
                        {L.addLast(new Point(srow+1,scol));notdone=false;} 
              else
                       {while(!v.peekLast().equals(new Point(srow,scol)))v.removeLast();}
                 
                  
              if (notdone&&(scol>1)&&(!v.contains(new Point(srow,scol-1)))&&(maze.can_go(srow, scol, 'L'))&&
                       CreatePath(maze,srow,scol-1,erow,ecol,L))
                        {L.addLast(new Point (srow, scol-1)); notdone =false;} 
              else
                       {while(!v.peekLast().equals(new Point(srow,scol))) v.removeLast();}        
        }
        else
            notdone=false; 
      
        return !notdone;
    }

    public static void main(String[] args)
    {new DepthFirst();}
}