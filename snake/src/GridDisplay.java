import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GridDisplay extends JFrame {
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
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add borders to cells
                gridPanel.add(label);
            }
        }

        add(gridPanel);
    }

    public static void main(String[] args) {
        String[][] sampleArray = {
            {"1", "8", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"1","2","3"}
        };
        int len = 3;
        JPanel gridPanel = new JPanel(new GridLayout(len, len));
        SwingUtilities.invokeLater(() -> {
            GridDisplay gridDisplay = new GridDisplay(sampleArray);
            gridDisplay.setVisible(true);
        });
    }
}
