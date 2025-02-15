package ScrableClient.Interfaces;

import ScrableClient.DreamUI.components.*;
import ScrableClient.DreamUI.utils.ImageUtils;
import ScrableClient.Game.Game;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameWindow extends DreamFrame {

    private DreamPanel body, content;
    Image icon = ImageUtils.resize((BufferedImage) ImageUtils.getImageFromUrl("https://i.imgur.com/Ir30QMW.png"), 20,
            20);
    Gson gson = new Gson();
    Game currentGame;
    public String currentUserId;
    JTable usersTable = new JTable();

    public GameWindow(Game game, String currentUserId) {
        super("Juego de palabras", ImageUtils
                .resize((BufferedImage) ImageUtils.getImageFromUrl("https://i.imgur.com/Ir30QMW.png"), 20, 20));
        body = new DreamPanel();
        this.currentGame = game;
        this.currentUserId = currentUserId;
        setSize(500, 600);
        setLocationRelativeTo(null);
        add(body, BorderLayout.CENTER);
        body.setBorder(new EmptyBorder(7, 8, 7, 8));

        body.add(content = new DreamPanel(), BorderLayout.NORTH);
        GridLayout grid = new GridLayout(0, 1);
        grid.setVgap(15);
        content.setLayout(grid);

        content.add(new DreamLabel("Game started"));
        usersTable.setModel(new DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "User", "Score"
                }));
        JScrollPane scrollPane = new JScrollPane(usersTable);
        content.add(scrollPane);
    }

    public void onExit() {
        MainWindow win = MainWindow.instance;
        win.disconnect();
        win.setVisible(true);
        setVisible(false);
        dispose();
    }
}
