import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GridDisplay extends JFrame implements KeyListener {
    private  static int numRows;
    private  static int numCols;
    private  String[][] gridData;

    public GridDisplay(String[][] data) {
        this.numRows = data.length;
        this.numCols = data[0].length;
        this.gridData = data;
        
        
        initializeUI();
        
    }

    private void initializeUI() {
        setTitle("2D Array Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400); // Adjust the window size as needed
        setLocationRelativeTo(null);

        JPanel gridPanel = new JPanel(new GridLayout(numRows, numCols));

        // Create JLabels for each element in the 2D array and add them to the gridPanel
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                String value = gridData[row][col];
                JLabel label = new JLabel(value);
                label.setHorizontalAlignment(JLabel.CENTER);
                //label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add borders to cells
                gridPanel.add(label);
            }
        }

        add(gridPanel);
        //addKeyListener(this);
    }
    public void updateGrid(String[][] newData) {
        // Clear the current gridPanel
        getContentPane().removeAll();
        
        // Update the gridData with the new data
        this.gridData = newData;
        
        // Reinitialize the UI with the new data
        initializeUI();
        
        // Repaint the frame
        revalidate();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String direction = "";
        System.out.println("doing something");
        System.out.println(snakeSim.pp);

        switch (keyCode) {

            case KeyEvent.VK_UP:
                if(!snakeSim.m.equals("s"))
                    snakeSim.m = "w";
                    snakeSim.pp = true;
                break;
            case KeyEvent.VK_DOWN:
                if(!snakeSim.m.equals("w"))
                    snakeSim.m = "s";
                    snakeSim.pp = true;
                break;
            case KeyEvent.VK_LEFT:
                if(!snakeSim.m.equals("d"))
                    snakeSim.m = "a";
                    snakeSim.pp = true;
                break;
            case KeyEvent.VK_RIGHT:
                if(!snakeSim.m.equals("a"))
                    snakeSim.m = "d";
                    snakeSim.pp = true;
                break;
        }
        System.out.println(snakeSim.pp);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    

    public static void main(String[] args) {
        String[][] sampleArray = {
            {"1", "8", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"1","2","3"}
        };
        int len = 3;

        String[][] sampleArray2 = {
            {"1", "8", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"6","5","4"}
        };
        SwingUtilities.invokeLater(() -> {
            GridDisplay gridDisplay = new GridDisplay(sampleArray);
            gridDisplay.setVisible(true);
            
            // Delay for a while to display sampleArray
            try {
                Thread.sleep(2); // Adjust the delay time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Replace the displayed grid with sampleArray2
            gridDisplay.updateGrid(sampleArray2);
        });
    }
}
