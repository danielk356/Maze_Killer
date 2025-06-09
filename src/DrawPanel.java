import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Rectangle;


public class DrawPanel extends JPanel implements KeyListener, MouseListener
{
    private Maze mazes;
    private Player player;
    private ArrayList<int[][]> mazeList;
    private BriefRespite briefRespite;
    private FinalTrial finalTrial;
    private int mazeNum;
    private int count1;
    private int count2;
    private int count3;
    private int count4;
    private boolean start;
    private boolean mazeSection;
    private Rectangle startButton;
    private Rectangle playAgainButton;
    private Rectangle okButton;

    public DrawPanel()
    {
        setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setBackground(Color.BLACK);
        mazes = new Maze();
        player = new Player();
        briefRespite = new BriefRespite();
        finalTrial = new FinalTrial();
        mazeList = mazes.getMazes();
        mazeNum = 0;
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        start = false;
        mazeSection = true;
        startButton = new Rectangle(430, 325, 320, 60);
        playAgainButton = new Rectangle(410, 498, 335, 80);
        okButton = new Rectangle(500, 600, 80, 80);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = 20;
        int y = 20;
        g.setColor(Color.BLACK);

        g.drawRect(1030, 130, 100, 500);
        g.setColor(Color.GRAY);
        g.fillRect(1030, 130, 90, 500);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("MAZE 1: ", 1035, 150);

        if (!mazes.isMaze1Win())
        {
            g.drawImage(mazes.getMaze1StarEmpty(), 1055, 160, 40, 40, null);
        }
        else
        {
            g.drawImage(mazes.getMaze1StarFill(), 1055, 160, 40, 40, null);
        }

        g.drawString("MAZE 2: ", 1035, 250);

        if (!mazes.isMaze2Win())
        {
            g.drawImage(mazes.getMaze2StarEmpty(), 1055, 260, 40, 40, null);
        }
        else
        {
            g.drawImage(mazes.getMaze2StarFill(), 1055, 260, 40, 40, null);
        }

        g.drawString("MAZE 3: ", 1035, 350);

        if (!mazes.isMaze3Win())
        {
            g.drawImage(mazes.getMaze3StarEmpty(), 1055, 360, 40, 40, null);
        }
        else
        {
            g.drawImage(mazes.getMaze3StarFill(), 1055, 360, 40, 40, null);
        }

        if (!start)
        {
            g.drawImage(mazes.getMazePath(), 0, 0, 1150, 820, null);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Courier New", Font.BOLD, 70));
            g.drawString("MAZE", 410, 120);
            g.setColor(Color.RED);
            g.drawString("CRAFT", 580, 120);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("Start Game", 440, 370);
            g.drawRect((int)startButton.getX(), (int)startButton.getY(), (int)startButton.getWidth(), (int)startButton.getHeight());
        }

        if (!mazes.isMaze1Win() && start)
        {
            for (int r = 0; r < 15; r++)
            {
                for (int c = 0; c < 20; c++)
                {
                    g.drawRect(x, y, 40, 40);

                    if (!playerSight(r, c))
                    {
                        g.fillRect(x, y, 40, 40);
                    }

                    if (playerSight(r, c) && mazeList.get(mazeNum)[r][c] == 1)
                    {
                        g.drawImage(mazes.getMazeWall(), x, y, 40, 40, null);
                    }

                    else if (playerSight(r, c) && mazeList.get(mazeNum)[r][c] == 0)
                    {
                        g.drawImage(mazes.getMazePath(), x, y, 40, 40, null);
                    }

                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }

                    if (mazeList.get(mazeNum)[r][c] == 2)
                    {
                        g.drawImage(mazes.getMazeWinBlock(), x, y, 40, 40, null);
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

        if ((mazes.isMaze1Win() && !mazes.isMaze2Win()) && start)
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

                    if (!playerSight(r, c))
                    {
                        g.fillRect(x, y, 40, 40);
                    }

                    if (playerSight(r, c) && mazeList.get(mazeNum)[r][c] == 1)
                    {
                        g.drawImage(mazes.getMazeWall(), x, y, 40, 40, null);
                    }

                    else if (playerSight(r, c) && mazeList.get(mazeNum)[r][c] == 0)
                    {
                        g.drawImage(mazes.getMazePath(), x, y, 40, 40, null);
                    }

                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }

                    if (mazeList.get(mazeNum)[r][c] == 2)
                    {
                        g.drawImage(mazes.getMazeWinBlock(), x, y, 40, 40, null);
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

        if ((mazes.isMaze1Win() && mazes.isMaze2Win()) && (!mazes.isMaze3Win() && start))
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

                    if (!playerSight(r, c))
                    {
                        g.fillRect(x, y, 40, 40);
                    }

                    if (playerSight(r, c) && mazeList.get(mazeNum)[r][c] == 1)
                    {
                        g.drawImage(mazes.getMazeWall(), x, y, 40, 40, null);
                    }

                    else if (playerSight(r, c) && mazeList.get(mazeNum)[r][c] == 0)
                    {
                        g.drawImage(mazes.getMazePath(), x, y, 40, 40, null);
                    }

                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }

                    if (mazeList.get(mazeNum)[r][c] == 2)
                    {
                        g.drawImage(mazes.getMazeWinBlock(), x, y, 40, 40, null);
                        if (player.getXCoordinate() == c && player.getYCoordinate() == r)
                        {
                            mazes.setMaze3Win(true);
                            briefRespite.setBriefRespiteTrigger(true);
                        }
                    }
                    x += 50;
                }
                x = 20;
                y += 50;
            }
        }

        if (briefRespite.isBriefRespiteTrigger())
        {
            if (count3 == 0)
            {
                player.setXCoordinate(0);
                player.setYCoordinate(0);
                mazeSection = false;
                count3++;
            }

            for (int r = 0; r < 15; r++)
            {
                for (int c = 0; c < 20; c++)
                {
                    g.drawRect(x, y, 40, 40);

                    if (briefRespite.getBriefRespiteRoom()[r][c] == 0)
                    {
                        g.drawImage(briefRespite.getRoomFloorImage(), x, y, 40, 40, null);
                    }

                    if (briefRespite.getBriefRespiteRoom()[r][c] == 2)
                    {
                        g.drawImage(mazes.getMazeWinBlock(), x, y, 40, 40, null);
                    }

                    if (briefRespite.getBriefRespiteRoom()[r][c] == 3)
                    {
                        g.drawImage(briefRespite.getVillagerImage(), x, y, 40, 40, null);
                    }

                    if (r == player.getYCoordinate() && c == player.getXCoordinate())
                    {
                        g.drawImage(player.getImage(), x, y, 40, 40, null);
                    }

                    if (briefRespite.getBriefRespiteRoom()[player.getYCoordinate()][player.getXCoordinate()] == 3)
                    {
                        briefRespite.setTalkingToVillager(true);
                    }

                    if (briefRespite.isTalkingToVillager())
                    {
                        g.drawRect(280, 500, 500, 80);
                        g.setColor(Color.GRAY);
                        g.fillRect(280, 500, 520, 80);

                        g.setColor(Color.BLACK);
                        g.setFont(new Font("Courier New", Font.BOLD, 23));
                        g.drawString("Villager: Your final trial awaits you", 280, 540);

                        g.setColor(Color.GRAY);
                        g.drawRect((int)okButton.getX(), (int)okButton.getY(), (int)okButton.getWidth(), (int)okButton.getHeight());
                        g.fillRect((int)okButton.getX(), (int)okButton.getY(), (int)okButton.getWidth(), (int)okButton.getHeight());

                        g.setColor(Color.BLACK);
                        g.drawString("Ok", 525, 640);

                    }

                    x += 50;
                }
                x = 20;
                y += 50;
            }
        }

        if (finalTrial.isFinalTrialTrigger())
        {
            if (count4 == 0)
            {
                player.setXCoordinate(0);
                player.setYCoordinate(0);
                count4++;
            }
            for (int r = 0; r < 15; r++)
            {
                for (int c = 0; c < 20; c++)
                {
                    g.drawRect(x, y, 40, 40);

                    if (finalTrial.getFinalTrialRoom()[r][c] == 0)
                    {
                        g.drawImage(mazes.getMazePath(), x, y, 40, 40, null);
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
        if ((mazes.isMaze1Win() && finalTrial.isFinalTrialWin()) && (mazes.isMaze2Win() && mazes.isMaze3Win()))
        {
            BufferedImage winBackground = ImageReader.readImage("images/WinBackground.png");
            g.drawImage(winBackground, 0, 0, 1150, 820, null);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Courier New", Font.BOLD, 70));
            g.drawString("MAZE", 410, 120);
            g.setColor(Color.RED);
            g.drawString("CRAFT", 580, 120);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Courier New", Font.BOLD, 100));
            g.drawString("YOU WIN", 370, 380);
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("Play Again?", 415, 550);
            g.drawRect((int)playAgainButton.getX(), (int)playAgainButton.getY(), (int)playAgainButton.getWidth(), (int)playAgainButton.getHeight());
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
        if (start)
        {
            if (e.getKeyCode() == KeyEvent.VK_A)
            {
                if (mazeSection)
                {
                    if (player.getXCoordinate() != 0 && mazeList.get(mazeNum)[player.getYCoordinate()][player.getXCoordinate() - 1] != 1)
                    {
                        player.setXCoordinate(player.getXCoordinate() - 1);
                    }
                }
                if (briefRespite.isBriefRespiteTrigger() && !briefRespite.isTalkingToVillager())
                {
                    if (player.getXCoordinate() != 0 && briefRespite.getBriefRespiteRoom()[player.getYCoordinate()][player.getXCoordinate() - 1] != 1)
                    {
                        player.setXCoordinate(player.getXCoordinate() - 1);
                    }
                }
                if (finalTrial.isFinalTrialTrigger())
                {
                    if (player.getXCoordinate() != 0 && finalTrial.getFinalTrialRoom()[player.getYCoordinate()][player.getXCoordinate() - 1] != 1)
                    {
                        player.setXCoordinate(player.getXCoordinate() - 1);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_D)
            {
                if (mazeSection)
                {
                    if (player.getXCoordinate() != mazeList.get(mazeNum)[0].length - 1 && mazeList.get(mazeNum)[player.getYCoordinate()][player.getXCoordinate() + 1] != 1)
                    {
                        player.setXCoordinate(player.getXCoordinate() + 1);
                    }
                }
                if (briefRespite.isBriefRespiteTrigger() && !briefRespite.isTalkingToVillager())
                {
                    if (player.getXCoordinate() != briefRespite.getBriefRespiteRoom()[0].length - 1 && briefRespite.getBriefRespiteRoom()[player.getYCoordinate()][player.getXCoordinate() + 1] != 1)
                    {
                        player.setXCoordinate(player.getXCoordinate() + 1);
                    }
                }
                if (finalTrial.isFinalTrialTrigger())
                {
                    if (player.getXCoordinate() != finalTrial.getFinalTrialRoom()[0].length - 1 && finalTrial.getFinalTrialRoom()[player.getYCoordinate()][player.getXCoordinate() + 1] != 1)
                    {
                        player.setXCoordinate(player.getXCoordinate() + 1);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_W)
            {
                if (mazeSection)
                {
                    if (player.getYCoordinate() != 0 && mazeList.get(mazeNum)[player.getYCoordinate() - 1][player.getXCoordinate()] != 1)
                    {
                        player.setYCoordinate(player.getYCoordinate() - 1);
                    }
                }
                if (briefRespite.isBriefRespiteTrigger() && !briefRespite.isTalkingToVillager())
                {
                    if (player.getYCoordinate() != 0 && briefRespite.getBriefRespiteRoom()[player.getYCoordinate() - 1][player.getXCoordinate()] != 1)
                    {
                        player.setYCoordinate(player.getYCoordinate() - 1);
                    }
                }
                if (finalTrial.isFinalTrialTrigger())
                {
                    if (player.getYCoordinate() != 0 && finalTrial.getFinalTrialRoom()[player.getYCoordinate() - 1][player.getXCoordinate()] != 1)
                    {
                        player.setYCoordinate(player.getYCoordinate() - 1);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S)
            {
                if (mazeSection)
                {
                    if (player.getYCoordinate() != mazeList.get(mazeNum).length - 1 && mazeList.get(mazeNum)[player.getYCoordinate() + 1][player.getXCoordinate()] != 1)
                    {
                        player.setYCoordinate(player.getYCoordinate() + 1);
                    }
                }
                if (briefRespite.isBriefRespiteTrigger() && !briefRespite.isTalkingToVillager())
                {
                    if (player.getYCoordinate() != briefRespite.getBriefRespiteRoom().length - 1 && briefRespite.getBriefRespiteRoom()[player.getYCoordinate() + 1][player.getXCoordinate()] != 1)
                    {
                        player.setYCoordinate(player.getYCoordinate() + 1);
                    }
                }
                if (finalTrial.isFinalTrialTrigger())
                {
                    if (player.getYCoordinate() != finalTrial.getFinalTrialRoom().length - 1 && finalTrial.getFinalTrialRoom()[player.getYCoordinate() + 1][player.getXCoordinate()] != 1)
                    {
                        player.setYCoordinate(player.getYCoordinate() + 1);
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Point clicked = e.getPoint();

        if (e.getButton() == 1)
        {
            if (startButton.contains(clicked))
            {
                start = true;
            }
            else if (playAgainButton.contains(clicked))
            {
                start = false;
                mazes.setMaze1Win(false);
                mazes.setMaze2Win(false);
                mazes.setMaze3Win(false);
                mazeSection = true;
                finalTrial.setFinalTrialWin(false);
                player.setXCoordinate(0);
                player.setYCoordinate(0);
                count1 = 0;
                count2 = 0;
                count3 = 0;
                count4 = 0;
                mazeNum = 0;
            }
            else if (okButton.contains(clicked))
            {

                briefRespite.setBriefRespiteTrigger(false);
                finalTrial.setFinalTrialTrigger(true);
            }
        }
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
}


