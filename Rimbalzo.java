import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Rimbalzo extends JFrame {
    private JPanel sfondo;
    private JButton bottone;
    private JButton b2;
    private MioPannello pannello;

    class CliccaBottone implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int x = pannello.x + 2;
            int y = pannello.y + 3;
            pannello.x = x;
            pannello.y = y;
            pannello.repaint();
        }
    }

    class Cliccab2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CliccaBottone c = new CliccaBottone();
            Timer t = new Timer(10, c);
            t.start();
        }
    }

    class MioPannello extends JPanel {
        int x = 0;
        int y = 0;
        int r1 = 50;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int ny = 350- Math.abs((y%700)-350);
            int nx = 750- Math.abs((x%1500)-750);
            Ellipse2D.Double d = new Ellipse2D.Double(nx, ny, r1, r1);
            g2.setColor(Color.GREEN);
            g2.fill(d);
            g2.setColor(Color.BLUE);
            g2.draw(d);
        }

    }

    public Rimbalzo() {
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 25);
        super.setSize(900, 800);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setVisible(true);

        this.sfondo = new JPanel();
        setContentPane(this.sfondo);
        this.sfondo.setLayout(null);

        this.pannello = new MioPannello();
        this.pannello.setSize(800, 400);
        this.pannello.setLocation(10, 10);
        this.pannello.setBackground(Color.BLACK);
        this.sfondo.add(this.pannello);

        this.bottone = new JButton("Non cliccare");
        this.bottone.setSize(300, 50);
        this.bottone.setLocation(10, 450);
        this.sfondo.add(this.bottone);
        this.bottone.setFont(f);
        CliccaBottone c = new CliccaBottone();
        this.bottone.addActionListener(c);

        this.b2 = new JButton("Avvia");
        this.b2.setSize(300, 50);
        this.b2.setLocation(400, 450);
        this.sfondo.add(this.b2);
        this.b2.setFont(f);
        Cliccab2 b = new Cliccab2();
        this.b2.addActionListener(b);


    }

    public static void main(String[] args) {
        Rimbalzo r = new Rimbalzo();
    }

}


