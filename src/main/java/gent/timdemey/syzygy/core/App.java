package gent.timdemey.syzygy.core;

import gent.timdemey.syzygy.raycast._RaycastingEngine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * Main entrypoint.
 */
public class App implements Runnable {

    private App (){

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }

    @Override
    public void run() {
        JMenuBar bar = new JMenuBar();
        JMenu game = new JMenu("Game");
        game.add(new JMenuItem(new QuitAction()));
        bar.add(game);

        JFrame frame = new JFrame ("3D engine");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setJMenuBar(bar);
        frame.setVisible(true);
        frame.createBufferStrategy(2);

        Canvas canvas = new Canvas();
        frame.add(canvas);
        canvas.requestFocus();
        canvas.createBufferStrategy(2);
        BufferStrategy strategy = canvas.getBufferStrategy();

        canvas.setPreferredSize(new Dimension(200, 200));
        frame.pack();
        frame.setLocation(0, 0);

        Engine engine = new _RaycastingEngine();
        InnerEngine inner = new InnerEngine(canvas, strategy, engine);
        inner.start();
    }

    private static class QuitAction extends AbstractAction {

        private QuitAction() {
            super("Quit");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }
}
