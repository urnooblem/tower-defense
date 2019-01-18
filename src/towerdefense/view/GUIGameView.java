package towerdefense.view;

import towerdefense.document.*;
import towerdefense.document.towers.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GUIGameView extends GameView {
    private Map currentMap;
    private CurrentPlayer currentPlayer;
    //Przyciski z wieżami
    private JButton button1, button2, button3, button4;
    private JButton button5, button6, button7, button8;
    //Obrazki reprezentujące wieże
    private Image i1, i2, i3, i4, i5, i6, i7, i8;
    private JPanel mainPanel;
    private JLabel towersLabel;
    private JPanel infoPanel;
    private JLabel moneyLabel;
    private JLabel playerNameLabel;
    private JLabel gameGoalLabel;
    private MapPanel mapPanel;

    public GUIGameView(Document document) {
        super(document, "GUI");
        currentPlayer = document.getCurrentPlayer();
        currentMap = document.getCurrentMap();
    }

    private void createUIComponents() {
        mapPanel = new MapPanel();
    }

    @Override
    protected void displayBoughtTowers() {
        try {
            i1 = ImageIO.read(new File("data/towersPNG/archer.png"));
            button1.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button1.setIcon(new ImageIcon(i1));
            i2 = ImageIO.read(new File("data/towersPNG/earth.png"));
            button2.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button2.setIcon(new ImageIcon(i2));
            i3 = ImageIO.read(new File("data/towersPNG/electric.png"));
            button3.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button3.setIcon(new ImageIcon(i3));
            i4 = ImageIO.read(new File("data/towersPNG/fire.png"));
            button4.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button4.setIcon(new ImageIcon(i4));
            i5 = ImageIO.read(new File("data/towersPNG/force.png"));
            button5.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button5.setIcon(new ImageIcon(i5));
            i6 = ImageIO.read(new File("data/towersPNG/ice.png"));
            button6.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button6.setIcon(new ImageIcon(i6));
            i7 = ImageIO.read(new File("data/towersPNG/nuclear.png"));
            button7.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button7.setIcon(new ImageIcon(i7));
            i8 = ImageIO.read(new File("data/towersPNG/water.png"));
            button8.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));
            button8.setIcon(new ImageIcon(i8));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void displayDetails() {
        System.out.println(currentPlayer.getNickname());
        playerNameLabel.setText("Hello, " + currentPlayer.getNickname() + "!");
        moneyLabel.setText("Your money: " + currentPlayer.getMoney());
        gameGoalLabel.setText(convertToMultiline("Your goal is to defend \n your territory against enemies." +
                "\nSelect tower with function keys\n and place it on map,\n along enemies' path of attack," +
                "\n using arrows.\n Enter accepts your choice.\nSurvive all waves of enemies attacks\n to win map."));
    }

    @Override
    protected void displayMap() {

//        mapPanel
    }

    @Override
    protected void displayWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window.setSize(1050, 600);
                window.setContentPane(mainPanel);
                window.setVisible(true);
            }
        });
    }

    @Override
    protected void handleInput() {

    }

    public class MapPanel extends JPanel {
        private int x = 0, y = 0;
        private int fieldWidth = 6, fieldHeight = 5;

        public MapPanel(){
       //     setSize(new Dimension(12*fieldWidth*10,6*fieldHeight*10));
       //     setBackground(Color.BLACK);
        }

        @Override
        public void paintComponent(Graphics g) {
            Iterator<Field> iterator = currentMap.iterator();
            Field currentField;
            while(iterator.hasNext()) {
                currentField = iterator.next();
                setBackground(getAWTColor(currentField.getColor()));
            }


        }


    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    private Color getAWTColor(towerdefense.document.Color color) {
        switch (color) {
            case BLACK:
                return Color.BLACK;
            case BLUE:
                return Color.BLUE;
            case CYAN:
                return Color.CYAN;
            case GREEN:
                return Color.GREEN;
            case MAGENTA:
                return Color.MAGENTA;
            case RED:
                return Color.RED;
            case YELLOW:
                return Color.YELLOW;
            case WHITE:
            default:
                return Color.WHITE;
        }
    }
}
