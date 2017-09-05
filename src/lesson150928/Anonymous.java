package lesson150928;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 18:34
 */
public class Anonymous {

    static class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked button");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 400));
        frame.add(panel);
        JButton button = new JButton("Click");
        panel.add(button);
        frame.pack();
        button.addActionListener(new MyActionListener());
//        panel.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println(e);
//            }
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println(e);
//            }
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println(e);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                System.out.println(e);
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//                System.out.println(e);
//            }
//        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
            }
        });
    }

}
