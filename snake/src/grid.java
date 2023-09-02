import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class grid {
    String[][] grid;
    ArrayList<snakeBlock> data;
    int xO, yO;
    GridDisplay gridDisplay;

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
        for(int i = 0; i < data.size(); i++){
            snakeBlock temp = data.get(i);
            int x = temp.getX();
            int y = temp.getY();
            grid[y][x] = "0";
        }
    }
    public void resert(){
        for(int i = 0; i < grid.length; i++ ){
            for(int j = 0; j < grid.length; j++)
                grid[i][j] = " ";
        }
    }

    public boolean insertObz(int x, int y){
        if(grid[y][x].equals("0")){
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
           GridDisplay gridDisplay = new GridDisplay(grid);
            gridDisplay.repaint();
            gridDisplay.setVisible(true);
        });
    }

    
}
