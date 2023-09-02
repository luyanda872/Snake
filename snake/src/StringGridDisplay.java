import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringGridDisplay extends JFrame {
    private JPanel gridPanel;
    private String[][] data;

    public StringGridDisplay(String[][] initialData) {
        this.data = initialData;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("String Grid Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        gridPanel = new JPanel(new GridLayout(data.length, data[0].length));
        add(gridPanel, BorderLayout.CENTER);

        populateGrid(data);

        JButton repaintButton = new JButton("Repaint Grid");
        repaintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace the data with updated data (for example, modify some values)
                updateData();
                populateGrid(data);
            }
        });

        add(repaintButton, BorderLayout.SOUTH);
    }

    private void populateGrid(String[][] newData) {
        gridPanel.removeAll();
        for (int i = 0; i < newData.length; i++) {
            for (int j = 0; j < newData[0].length; j++) {
                JLabel label = new JLabel(newData[i][j]);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                gridPanel.add(label);
            }
        }
        revalidate();
        repaint();
    }

    private void updateData() {
        // Modify the data as needed for your application
        // For example, change some values in the array
        // Here, we'll just reverse the text in each cell for demonstration
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = reverseString(data[i][j]);
            }
        }
    }

    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String[][] initialData = {
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "I"}
        };

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StringGridDisplay(initialData).setVisible(true);
            }
        });
    }
}
