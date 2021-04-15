import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Start Game");



        panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Warring Nation's");
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args) {

        new GUI();


    }
}
