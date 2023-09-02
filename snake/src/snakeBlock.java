import java.util.ArrayList;


public class snakeBlock {
    int x = 0;
    int y = 0;
    String direction;
    ArrayList<String>  dir = new ArrayList<>();
    boolean head = false;
    public snakeBlock(){}
    public snakeBlock(boolean h){
        head = h;
    }


    public void addDir(int x, int y,String dirr){
        dir.add(x+" "+y+" "+dirr);
    }



    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void incX(){
        this.x++;
    }
    public void decY(){
        this.y--;
    }
    public void decX(){
        this.x--;
    }
    public void incY(){
        this.y++;
    }
     public void set(int x , int y){
          this.x = x;
          this.y = y;
     }

     public boolean equals(snakeBlock other){
        return other.getX() == this.x && other.getY() == this.y;
     }
     public snakeBlock copy(snakeBlock c){
        return new snakeBlock();
     }

}
