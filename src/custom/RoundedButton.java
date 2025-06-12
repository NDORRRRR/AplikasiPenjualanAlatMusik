package custom;

import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.BOLD, 16));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();

        // Smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Shadow
        g2.setColor(new Color(0, 0, 0, 50));
        g2.fillRoundRect(5, 5, width - 10, height - 10, height, height);

        // Gradient background
        GradientPaint gp = new GradientPaint(0, 0, new Color(143, 146, 255), 0, height, new Color(52, 34, 194));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, width - 10, height - 10, height, height);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do nothing: no border
    }
}

