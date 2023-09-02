import java.util.ArrayList;

public class moves extends grid {
    
    public int len;
    public moves(int len){
        super(len);
        this.len = len;
    }

    public void Up(){
        snakeBlock currentHead = super.data.get(0);
        snakeBlock newHead = new snakeBlock(); 
        newHead = newHead.copy(super.data.get(data.size()-1));
        int xc = currentHead.getX();
        int yc = currentHead.getY();
        if(yc == 0){
            yc = len-1;
        }
        else{
            yc--;
        }
        
        if(xc == xO && yc == yO){
            newHead.set(xc, yc);
            super.data.add(0,newHead);
        }
        else{
            newHead.set(xc, yc);
            super.data.remove(super.data.size()-1);
            super.data.add(0,newHead);
        }
    }
    public void Down(){
        snakeBlock currentHead = super.data.get(0);
        snakeBlock newHead = new snakeBlock(); 
        newHead = newHead.copy(super.data.get(data.size()-1));
        int xc = currentHead.getX();
        int yc = currentHead.getY();
        if(yc == len-1){
            yc = 0;
        }
        else{
            yc++;
        }
        if(xc == xO && yc == yO){
            newHead.set(xc, yc);
            super.data.add(0,newHead);
        }
        else{
            newHead.set(xc, yc);
            super.data.remove(super.data.size()-1);
            super.data.add(0,newHead);
        }
    }
    public void Left(){
        snakeBlock currentHead = super.data.get(0);
        snakeBlock newHead = new snakeBlock(); 
        newHead = newHead.copy(super.data.get(data.size()-1));
        int xc = currentHead.getX();
        int yc = currentHead.getY();
        if(xc == 0){
            xc = len-1;
        }
        else{
            xc--;
        }
        if(xc == xO && yc == yO){
            newHead.set(xc, yc);
            super.data.add(0,newHead);
        }
        else{
            newHead.set(xc, yc);
            super.data.remove(super.data.size()-1);
            super.data.add(0,newHead);
        }
    }
    public void Right(){
        snakeBlock currentHead = super.data.get(0);
        snakeBlock newHead = new snakeBlock(); 
        newHead = newHead.copy(super.data.get(data.size()-1));
        int xc = currentHead.getX();
        int yc = currentHead.getY();
        if(xc == len-1){
            xc = 0;
        }
        else{
            xc++;
        }
        if(xc == xO && yc == yO){
            newHead.set(xc, yc);
            super.data.add(0,newHead);
        }
        else{
            newHead.set(xc, yc);
            super.data.remove(super.data.size()-1);
            super.data.add(0,newHead);
        }
    }

    public String moving(String m){
        if(m.equals("w")){
            this.Up();
        }
        else if(m.equals("s")){
            this.Down();
        }
        else if(m.equals("a")){
            this.Left();
        }
        else if(m.equals("d")){
            this.Right();
        }
        return super.data.get(0).getX()+" "+super.data.get(0).getY();
    }

    public void append(){

    }



}
