import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements KeyListener
{
    private Maze mazes;
    private Player player;
    private boolean mazeWin;
    private ArrayList<int[][]> mazeList;
    private int mazeNum;
    private int count1;
    private int count2;

    public DrawPanel()
    {
        setFocusable(true);
        this.addKeyListener(this);
        this.setBackground(Color.GRAY);
        mazes = new Maze();
        player = new Player();
        mazeWin = false;
        mazeList = mazes.getMazes();
        mazeNum = 0;
        count1 = 0;
        count2 = 0;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = 20;
        int y = 20;
        g.setColor(Color.BLACK);

        if (!mazes.isMaze1Win()) {
            for (int r = 0; r < 15; r++)
            {
                for (int c = 0; c < 20; c++)
                {
                    g.drawRect(x, y, 40, 40);

                    if (!playerSight(r, c) || mazeList.get(mazeNum)[r][c] == 1)
                    {
                        g.fillRect(x, y, 40, 40);
                    }
                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }
                    if (mazeList.get(mazeNum)[r][c] == 2)
                    {
                        g.setColor(Color.YELLOW);
                        g.fillRect(x, y, 40, 40);
                        g.setColor(Color.BLACK);
                        if (player.getXCoordinate() == c && player.getYCoordinate() == r)
                        {
                            mazes.setMaze1Win(true);
                        }
                    }
                    x += 50;
                }
                x = 20;
                y += 50;
            }
        }

        if (mazes.isMaze1Win() && !mazes.isMaze2Win())
        {
            if (count1 == 0)
            {
                mazeNum++;
                player.setXCoordinate(0);
                player.setYCoordinate(0);
                count1++;
            }

            for (int r = 0; r < 15; r++)
            {
                for (int c = 0; c < 20; c++)
                {
                    g.drawRect(x, y, 40, 40);

                    if (!playerSight(r, c) || mazeList.get(mazeNum)[r][c] == 1)
                    {
                        g.fillRect(x, y, 40, 40);
                    }
                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }
                    if (mazeList.get(mazeNum)[r][c] == 2)
                    {
                        g.setColor(Color.YELLOW);
                        g.fillRect(x, y, 40, 40);
                        g.setColor(Color.BLACK);
                        if (player.getXCoordinate() == c && player.getYCoordinate() == r)
                        {
                            mazes.setMaze2Win(true);
                        }
                    }
                    x += 50;
                }
                x = 20;
                y += 50;
            }
        }

        if ((mazes.isMaze1Win() && mazes.isMaze2Win()) && !mazes.isMaze3Win())
        {
            if (count2 == 0)
            {
                mazeNum++;
                player.setXCoordinate(0);
                player.setYCoordinate(0);
                count2++;
            }

            for (int r = 0; r < 15; r++)
            {
                for (int c = 0; c < 20; c++)
                {
                    g.drawRect(x, y, 40, 40);

                    if (!playerSight(r, c) || mazeList.get(mazeNum)[r][c] == 1)
                    {
                        g.fillRect(x, y, 40, 40);
                    }
                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }
                    if (mazeList.get(mazeNum)[r][c] == 2)
                    {
                        g.setColor(Color.YELLOW);
                        g.fillRect(x, y, 40, 40);
                        g.setColor(Color.BLACK);
                        if (player.getXCoordinate() == c && player.getYCoordinate() == r)
                        {
                            mazes.setMaze3Win(true);
                        }
                    }
                    x += 50;
                }
                x = 20;
                y += 50;
            }
        }
    }

    private boolean playerSight(int r, int c)
    {
        String currentPoint = r + "," + c;

        ArrayList<String> playerSights = new ArrayList<>();
        playerSights.add((player.getYCoordinate() - 1) + "," + (player.getXCoordinate() - 1));
        playerSights.add((player.getYCoordinate() - 1) + "," + (player.getXCoordinate()));
        playerSights.add((player.getYCoordinate() - 1) + "," + (player.getXCoordinate() + 1));
        playerSights.add((player.getYCoordinate()) + "," + (player.getXCoordinate() - 1));
        playerSights.add((player.getYCoordinate()) + "," + (player.getXCoordinate() + 1));
        playerSights.add((player.getYCoordinate() + 1) + "," + (player.getXCoordinate() - 1));
        playerSights.add((player.getYCoordinate() + 1) + "," + (player.getXCoordinate()));
        playerSights.add((player.getYCoordinate() + 1) + "," + (player.getXCoordinate() + 1));

        playerSights.add((player.getYCoordinate() - 2) + "," + (player.getXCoordinate() - 2));
        playerSights.add((player.getYCoordinate() - 2) + "," + (player.getXCoordinate()));
        playerSights.add((player.getYCoordinate() - 2) + "," + (player.getXCoordinate() + 2));
        playerSights.add((player.getYCoordinate()) + "," + (player.getXCoordinate() - 2));
        playerSights.add((player.getYCoordinate()) + "," + (player.getXCoordinate() + 2));
        playerSights.add((player.getYCoordinate() + 2) + "," + (player.getXCoordinate() - 2));
        playerSights.add((player.getYCoordinate() + 2) + "," + (player.getXCoordinate()));
        playerSights.add((player.getYCoordinate() + 2) + "," + (player.getXCoordinate() + 2));

        playerSights.add((player.getYCoordinate() - 1) + "," + (player.getXCoordinate() - 2));
        playerSights.add((player.getYCoordinate() - 2) + "," + (player.getXCoordinate() + 1));
        playerSights.add((player.getYCoordinate() - 1) + "," + (player.getXCoordinate() + 2));
        playerSights.add((player.getYCoordinate() + 2) + "," + (player.getXCoordinate() + 1));
        playerSights.add((player.getYCoordinate() - 2) + "," + (player.getXCoordinate() - 1));
        playerSights.add((player.getYCoordinate() + 1) + "," + (player.getXCoordinate() - 2));
        playerSights.add((player.getYCoordinate() + 2) + "," + (player.getXCoordinate() - 1));
        playerSights.add((player.getYCoordinate() + 1) + "," + (player.getXCoordinate() + 2));

        for (int i = 0; i < playerSights.size(); i++) {
            if (currentPoint.equals(playerSights.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            if (player.getXCoordinate() != 0 && mazeList.get(mazeNum)[player.getYCoordinate()][player.getXCoordinate() - 1] != 1)
            {
                player.setXCoordinate(player.getXCoordinate() - 1);

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            if (player.getXCoordinate() != mazeList.get(mazeNum)[0].length - 1 && mazeList.get(mazeNum)[player.getYCoordinate()][player.getXCoordinate() + 1] != 1)
            {
                player.setXCoordinate(player.getXCoordinate() + 1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            if (player.getYCoordinate() != 0 && mazeList.get(mazeNum)[player.getYCoordinate() - 1][player.getXCoordinate()] != 1)
            {
                player.setYCoordinate(player.getYCoordinate() - 1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            if (player.getYCoordinate() != mazeList.get(mazeNum).length - 1 && mazeList.get(mazeNum)[player.getYCoordinate() + 1][player.getXCoordinate()] != 1)
            {
                player.setYCoordinate(player.getYCoordinate() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


