import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Pucca extends Applet {

    public Pucca() {
        setSize(700, 700);
        Thread t = new Thread(new Runnable() {
            private int xDelta = -1;
            private int yDelta = 0;
            private int blinkCount = 0;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                    }

                    xOffset += xDelta;
                    double irisSize = eyeSize.width * irisScale;
                    double range = ((eyeSize.width - irisSize) / 2);
                    if (xOffset <= -range) {
                        xOffset = -(int) range;
                        xDelta *= -1;
                    } else if (xOffset >= range) {
                        xOffset = (int) range;
                        xDelta *= -1;
                    }
                    blinkCount++;
                    if (blink && blinkCount > 10) {
                        blink = false;
                        blinkCount = 0;
                    } else if (blinkCount > 25) {
                        blink = true;
                        blinkCount = 0;
                    }
                    repaint();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private boolean blink = false;

    private int xOffset, yOffset = 0;
    private Dimension eyeSize = new Dimension(125, 125);
    private Point left = new Point(20, 20);
    private Point right = new Point(left.x + 100, left.y);
    private double irisScale = 0.4;
    private double pupilScale = 0.16;

//paint method
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        paintEye(g, new Rectangle(left, eyeSize));
        paintEye(g, new Rectangle(right, eyeSize));

    }

    protected void paintEye(Graphics g, Rectangle bounds) {

        Color white = new Color(255, 255, 255);

        if (blink) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(white);
        }
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height); //left white fill eye

        g.setColor(Color.BLACK);
        g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height); // left big black line eye

        if (!blink) {
            Color blue = new Color(0, 160, 198);

            paintEyePartAt(g, bounds, irisScale, blue);
            paintEyePartAt(g, bounds, pupilScale, Color.BLACK);
        }
    }

    private void paintEyePartAt(Graphics g, Rectangle bounds, double delta, Color color) {

        int width = (int) (bounds.width * delta);
        int height = (int) (bounds.height * delta);

        g.setColor(color);
        g.fillOval(
                xOffset + bounds.x + ((bounds.width - width) / 2),
                yOffset + bounds.y + ((bounds.height - height) / 2),
                width, height); // left blue fill eye
        g.setColor(Color.BLACK);
        g.drawOval(
                xOffset + bounds.x + ((bounds.width - width) / 2),
                yOffset + bounds.y + ((bounds.height - height) / 2),
                width,
                height); // left blue fill eye
    }
}
/*/*int rval,gval,bval;
        String tempDelay=getParameter("delay");
        int finalDelay=Integer.parseInt(tempDelay);
        for(int k=1;k<=100;k++)
            for(int j=30;j<(size().height -25);j+=30){
                for(int i=5;i<(size().width -25);i+=30){
                    rval=(int)Math.floor(Math.random()*256);
                    gval=(int)Math.floor(Math.random()*256);
                    bval=(int)Math.floor(Math.random()*256);
                    g.setColor(new Color(rval,gval,bval));
                    g.fillRect(i,j,25,25);
                    g.setColor(Color.black);
                    g.drawRect(i,j,25,25);
                }
            }
        
        /*g.setColor(Color.BLUE);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("hello world",250,150);
        rval=(int)Math.floor(Math.random()*256);
                    gval=(int)Math.floor(Math.random()*256);
                    bval=(int)Math.floor(Math.random()*256);
        g.setColor(new Color(rval,gval,bval));
        g.fillOval(100, 50, 200, 200);
        g.fillRect(200, 100, 200, 200);
        g.setColor(Color.BLACK);
        g.drawLine(100, 50, 200, 200);*/
        //Color white = new Color(255,255,255);
/*g.setColor(white);
g.fillOval(600, 100, 125, 125); //left white fill eye

g.setColor(Color.BLA­CK);
g.drawOval(600, 100, 125, 125); // left big black line eye

g.setColor(white);
g.fillOval(700, 100, 125, 125); //right white fill eye

g.setColor(Color.BLA­CK);
g.drawOval(700, 100, 125, 125); //right big black line eye

Color blue = new Color(0, 160, 198);
g.setColor(blue);
g.fillOval(635, 130, 51, 51); // left blue fill eye

g.setColor(Color.BLA­CK);
g.drawOval(635, 130, 50, 50); // left black small line eye

g.setColor(blue);
g.fillOval(735, 130, 51, 51); // right blue fill eye

g.setColor(Color.BLA­CK);
g.drawOval(735, 130, 50, 50); // right black small line eye

g.setColor(Color.BLA­CK);
g.fillOval(650, 145, 20, 20); // left black iris 

g.setColor(Color.BLA­CK);
g.fillOval(750, 145, 20, 20); // right black iris
g.setColor(blue);
g.fillRect(200, 100, 200, 200);*/