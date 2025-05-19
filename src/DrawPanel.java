import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class DrawPanel extends JPanel implements KeyListener
{
    private Maze mazes;
    private Player player;

    public DrawPanel()
    {
        setFocusable(true);
        this.addKeyListener(this);
        this.setBackground(Color.GRAY);
        mazes = new Maze();
        player = new Player();
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = 20;
        int y = 20;
        g.setColor(Color.BLACK);

        for (int r = 0; r < 15; r++)
        {
            for (int c = 0; c < 20; c++) {
                g.drawRect(x, y, 40, 40);
                if (mazes.getMaze1()[r][c] == 1)
                {
                    g.fillRect(x, y, 40, 40);
                }
                if (mazes.getMaze1()[r][c] == 2) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                }
                if (r == player.getYCoordinate() && c == player.getXCoordinate())
                {
                    g.drawImage(player.getImage(), x, y, 40, 40, null);
                }

                x += 50;
            }
            x = 20;
            y += 50;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            if (player.getXCoordinate() != 0 && mazes.getMaze1()[player.getYCoordinate()][player.getXCoordinate() - 1] != 1)
            {
                player.setXCoordinate(player.getXCoordinate() - 1);

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            if (player.getXCoordinate() != mazes.getMaze1()[0].length - 1 && mazes.getMaze1()[player.getYCoordinate()][player.getXCoordinate() + 1] != 1)
            {
                player.setXCoordinate(player.getXCoordinate() + 1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            if (player.getYCoordinate() != 0 && mazes.getMaze1()[player.getYCoordinate() - 1][player.getXCoordinate()] != 1)
            {
                player.setYCoordinate(player.getYCoordinate() - 1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            if (player.getYCoordinate() != mazes.getMaze1().length - 1 && mazes.getMaze1()[player.getYCoordinate() + 1][player.getXCoordinate()] != 1)
            {
                player.setYCoordinate(player.getYCoordinate() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


