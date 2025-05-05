import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements KeyListener, MouseListener {
    private Maze mazes;
    private Player player;

    public DrawPanel() {
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setBackground(Color.GRAY);
        mazes = new Maze();
        player = new Player();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 20;
        int y = 20;
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 15; i++) {
            for (int a = 0; a < 20; a++) {
                g.drawRect(x, y, 40, 40);
                if (mazes.getMaze1()[i][a] == 1) {
                    g.fillRect(x, y, 40, 40);
                }
                x += 50;
            }
            x = 20;
            y += 50;
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}