/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ksaum
 */
public class MyApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    
    /*<applet code=MyApplet width=500 height=500>*/
    public void init() {
        setBackground(Color.red);
        // TODO start asynchronous download of heavy resources
    }
    //WAP to draw a robot on an applet with blinking eyes.
    public void paint(Graphics g){
        int S_rval,S_gval,S_bval;
       
        g.setColor(Color.white);
        g.fillOval(20,20,150,150);   // For face
        g.setColor(Color.black);
        for(int S_k=1;S_k<=100;S_k++){
              S_rval=(int)Math.floor(Math.random()*256);
              S_gval=(int)Math.floor(Math.random()*256);
              S_bval=(int)Math.floor(Math.random()*256);
              g.setColor(new Color(S_rval,S_gval,S_bval));
              g.fillOval(50,60,15,25);     // Left Eye 
              g.fillOval(120,60,15,25);    // Right Eye
        }
        g.setColor(Color.black);
        int S_x[] = {95,85,106,95};
        int S_y[] = {85,104,104,85};
        g.drawPolygon(S_x, S_y, 4);      // Nose
        g.drawArc(55,95,78,50,0,-180);  // Smile
        g.drawLine(50,126,60,116);   // Smile arc1
        g.drawLine(128,115,139,126);
        g.setColor(Color.black);
        g.fillRect(20,160,150,150);      
         g.setColor(Color.black);
        g.fillRect(20,160,150,150);      
         g.setColor(Color.white);
        g.fillRect(20,310,40,100);      
         g.setColor(Color.white);
        g.fillRect(130,310,40,100);
        g.setColor(Color.white);
        g.fillRect(140,160,40,100);
        g.setColor(Color.white);
        g.fillRect(0,160,40,40);
          }

    // TODO overwrite start(), stop() and destroy() methods
}
