import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class grid {
    String[][] grid;
    ArrayList<snakeBlock> data;
    int xO, yO;
    GridDisplay gridDisplay;
    int counter = 1;

    public grid(int len){
        this.grid = new String[len][len];
        for(int i = 0; i < grid.length; i++ ){
            for(int j = 0; j < grid.length; j++)
                grid[i][j] = " ";
        }
        gridDisplay = new GridDisplay(grid);
        
    }
    public void update(ArrayList<snakeBlock> d){
        this.data = d;
    }

    public void insert(){
        int xo =0, yo =0;
        for(int i = 0; i < data.size(); i++){
            snakeBlock temp = data.get(i);
            int x = temp.getX();
            int y = temp.getY();
            if(i == 0){
                grid[y][x] = "O";
                xo = x;
                yo = y;
            }
            else{
                if(x == xo && y == yo){
                    snakeSim.canPlay = false;
                    grid[y][x] = "O";
                }
                else
                    grid[y][x] = "o";
            }
        }
    }
    public void resert(){
        for(int i = 0; i < grid.length; i++ ){
            for(int j = 0; j < grid.length; j++)
                grid[i][j] = " ";
        }
    }

    public boolean insertObz(int x, int y){
        if(grid[y][x].equals("O") || grid[y][x].equals("o")){
            return false;
        }
        grid[y][x] = "*";
        yO = y;
        xO = x;
        return true;
    }

    public void print(){

        for(int i = 0; i < grid.length; i++ ){
            for(int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        SwingUtilities.invokeLater(() -> {
            gridDisplay = new GridDisplay(grid);
            gridDisplay.setVisible(true);
        });
    }

    public void upDate(){
        gridDisplay.updateGrid(grid);
    }

    
}
