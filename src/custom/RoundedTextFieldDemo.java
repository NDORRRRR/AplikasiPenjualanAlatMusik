package custom;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RoundedTextFieldDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField Melengkung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        JTextField textField = new JTextField(20);
        textField.setBorder(new RoundedBorder(15)); // sudut radius 15
        frame.setLayout(new FlowLayout());
        frame.add(textField);

        frame.setVisible(true);
    }

    static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+1, this.radius+1);
        }

        public boolean isBorderOpaque() {
            return false;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}
