import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class snakeSim  {
    static String m;
    static boolean canPlay = true;
    static boolean pp = true;
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean start = true;
        ArrayList<snakeBlock> allData = new ArrayList<>();


        System.out.print("len: ");
        int len = input.nextInt();
        String junk = input.nextLine();

        snakeBlock head = new snakeBlock();
        head.set(rand.nextInt(len), rand.nextInt(len));

        allData.add(head);
        moves move = new moves(len);
        move.update(allData);
        move.insert();
       //move.print();
        

        int yO = rand.nextInt(len);
        int xO = rand.nextInt(len);
        while (move.insertObz(xO, yO) == false) {
            yO = rand.nextInt(len);
            xO = rand.nextInt(len);
        }
        move.resert();
        move.insertObz(xO, yO);
        move.print();
        System.out.print(": ");
        m = input.nextLine().toLowerCase().strip();
        String prev = "";
        String set = "";

        while (true) {
            if(canPlay){
                if (start) {
                    start = false;
                    set = move.moving(m);
                } else {
                    // System.out.print(": ");
                    if (m.equals("w")) {
                        while (true) {
                            System.out.print(": ");
                            prev = m;
                            m = input.nextLine().toLowerCase().strip();
                            if (m.equals("s") == false && ("wsad").contains(m) == true && m.equals("") == false) {
                                break;
                            }
                        }
                    } else if (m.equals("s")) {
                        while (true) {
                            System.out.print(": ");
                            prev = m;
                            m = input.nextLine().toLowerCase().strip();
                            if (m.equals("w") == false && ("wsad").contains(m) == true && m.equals("") == false) {
                                break;
                            }
                        }
                    } else if (m.equals("a")) {
                        while (true) {
                            System.out.print(": ");
                            prev = m;
                            m = input.nextLine().toLowerCase().strip();
                            if (m.equals("d") == false && ("wsad").contains(m) == true && m.equals("") == false) {
                                break;
                            }
                        }
                    } else if (m.equals("d")) {
                        while (true) {
                            System.out.print(": ");
                            prev = m;
                            m = input.nextLine().toLowerCase().strip();
                            if (m.equals("a") == false && ("wsad").contains(m) == true && m.equals("") == false) {
                                break;
                            }
                        }
                    }
                    if (("wsad").contains(m) == false) {
                        m = prev;
                        continue;
                    }
                    if (("wsad").contains(m) == false) {
                        m = prev;
                        continue;
                    }
                    if (m != "q")
                        set = move.moving(m);
    

                }
                int xt = Integer.parseInt((set.split(" "))[0]);
                int yt = Integer.parseInt((set.split(" "))[1]);
                if (xO == xt && yt == yO) {
                    yO = rand.nextInt(len);
                    xO = rand.nextInt(len);
                    while (move.insertObz(xO, yO) == false) {
                        yO = rand.nextInt(len);
                        xO = rand.nextInt(len);
                    }
                }
                move.resert();
                move.insert();
                move.insertObz(xO, yO);
                move.upDate();
            }
            else{
                System.out.print("want to again: ");
                String ask = input.nextLine().toLowerCase().strip();
                if(ask.equals("") || ask.startsWith("y")){
                    head = new snakeBlock();
                    head.set(rand.nextInt(len), rand.nextInt(len));
                    allData = new ArrayList<>();
                    allData.add(head);
                    move.resert();
                    move.update(allData);
                    move.insert();
                    move.upDate();
                    

                    canPlay = true;
                }
                else{
                    System.out.println("thanks for playing");
                    System.exit(0);
                }
            }


        } 

    }

}
