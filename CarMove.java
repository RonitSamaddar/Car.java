/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SAMADDAR
 */
public class CarMove extends Applet implements KeyListener,MouseListener, MouseMotionListener
{
    int w=1000;
    int h=1000;
    int w1=2;
    int h1=2;
    int start=0;
    int mode=1;
    int path1[];
    int path0[];
    int fwxc=2;
    int fwyc=3;
    int posx=0;
    int posy=0;
    int dir=0;
    int input_mode=0;
    int mright=0;
    int mleft=0;
    int flag=0;
    @Override
    public void init()
    {
        this.setSize(new Dimension(w,h));
        setBackground(Color.black);
        addMouseListener(this);
	addMouseMotionListener(this);
         addKeyListener(this);
		requestFocus();
        path1=new int[10000];
        path0=new int[10000];
    }

    
    
    @Override
    public void paint(Graphics g)
    {
        flag=0;
        w=getWidth();
        h=getHeight();
        
        int originX=(getX()+getWidth())/2;
        int originY=(getY()+getHeight())/2;
        if(start==0)
        {
            g.setColor(Color.red);
            g.drawRect(originX-15*10, originY-5*10, 350, 100);
            g.setColor(Color.yellow);
            g.fillRect(originX-15*10+1, originY-5*10+1, 348, 98);
            Font f=new Font("Times New Roman",4,104);
            g.setFont(f);
            g.setColor(Color.white);
            g.drawString("START", originX-15*10, originY-5*10+83);
        }
        else if(start==1)
        {
         
            
            
       
        Color oc=new Color(0,0,200);
        g.setColor(oc);
        g.drawLine(originX,0 , originX, h);
        g.drawLine(0,originY,w, originY);
        g.setColor(new Color(100,100,100));
        for(int x=originX+w1;x<w;x=x+w1)
            g.drawLine(x,0,x,h);
        for(int x=originX-w1;x>0;x=x-w1)
            g.drawLine(x,0,x,h);
        for(int y=originY+h1;y<h;y=y+h1)
            g.drawLine(0,y,w,y);
        for(int y=originY-h1;y>0;y=y-h1)
            g.drawLine(0,y,w,y);
        
        g.setColor(Color.red);
        g.drawRect(0, h-30, 100, 30);
        g.setColor(Color.yellow);
        g.fillRect(0+1, h-30+1, 98, 28);
        g.setColor(Color.BLACK);
        Font f=new Font("Times New Roman",4,24);
        g.setFont(f);
        g.drawString("Zoom In", 0+2, h-2);
        g.setColor(Color.red);
        g.drawRect(w-100, h-30, 100, 30);
        g.setColor(Color.yellow);
        g.fillRect(w-100+1, h-30+1, 98, 28);
         g.setColor(Color.BLACK);
        g.drawString("Zoom Out", w-100+2, h-2);
        
         g.setColor(Color.red);
        g.drawRect(w-100, 0, 100, 30);
        g.setColor(Color.yellow);
        g.fillRect(w-100+1, 0+1, 98, 28);
        g.setColor(Color.BLACK);
        
        g.drawString("CLOSE", w-100+2, 30-2);
        
        g.setColor(Color.red);
        g.drawRect(originX-299, 0, 198, 30);
        g.setColor(Color.orange);
        g.fillRect(originX-299+1, 0+1, 196, 28);
        g.setColor(Color.BLACK);
        
        g.drawString("LEFT", originX-300+2, 30-2);
        if(input_mode==1){
        g.setColor(Color.red);
        g.drawRect(originX-99, 0, 198, 30);
        g.setColor(Color.red);
        g.fillRect(originX-99+1, 0+1, 196, 28);
        g.setColor(Color.BLACK);
        
        g.drawString("STOP", originX-99+2, 30-2);
        }
        g.setColor(Color.red);
        g.drawRect(originX+101, 0, 198, 30);
        g.setColor(Color.orange);
        g.fillRect(originX+101+1, 0+1, 196, 28);
        g.setColor(Color.BLACK);
        
        g.drawString("RIGHT", originX+101+2, 30-2);        Color g1=Color.red;
        if(mode==1)
        {
        drawLineDDA(-9999,0,-2000,0,g,mode,g1);
        drawLineDDA(-2000,0,-1000,20,g,mode,g1);
        drawLineDDA(-1000,20,-800,20,g,mode,g1);
        drawLineDDA(-800,20,-600,10,g,mode,g1);
        drawLineDDA(-600,10,-400,0,g,mode,g1);
        drawLineDDA(-400,0,-250,10,g,mode,g1);
        drawLineDDA(-250,10,-200,0,g,mode,g1);
        drawLineDDA(-200,0,-160,20,g,mode,g1);
        drawLineDDA(-160,20,-120,0,g,mode,g1);
        drawLineDDA(-120,0,0,30,g,mode,g1);
        
        drawLineDDA(0,30,100,0,g,mode,g1);
        drawLineDDA(100,0,140,-20,g,mode,g1);
        drawLineDDA(140,-20,200,-10,g,mode,g1);
        drawLineDDA(200,-10,240,-10,g,mode,g1);
        drawLineDDA(240,-10,400,0,g,mode,g1);
        drawLineDDA(400,0,500,10,g,mode,g1);
        drawLineDDA(500,10,800,-10,g,mode,g1);
        drawLineDDA(800,-10,1000,-10,g,mode,g1);
        drawLineDDA(1000,-10,2000,0,g,mode,g1);
        drawLineDDA(2000,0,9999,0,g,mode,g1);
        mode =0;}
        else{
            for(int x=-9999;x<=9999;x++)
            {
              drawPoint(x,ypath(x),g,g1);    
            }
            
        }
        
        g1=Color.yellow;
        posy=ymax(fwxc+posx);
        if(dir==0)
        drawCarLeft(fwxc+posx,fwyc+posy,g,g1);
        else
            drawCarRight(fwxc+posx,fwyc+posy,g,g1);
        mode=0;
        
        
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(CarMove.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ypath(fwxc+posx-2)<ypath(fwxc+posx+2) && ypath(fwxc+10+posx-2)<ypath(fwxc+10+posx+1+2) )
            {posx=posx-3;
            
            flag=1;}
            
            if(ypath(fwxc+posx-2)>ypath(fwxc+posx+2) && ypath(fwxc+10+posx-2)>ypath(fwxc+10+posx+2))
            { posx=posx+3;
            
            flag=1;}
            
            if(mleft==1)
            {
                posx=posx-5;
                flag=1;
            }
            else if(mright==1)
            {
                posx=posx+5;
                flag=1;
            }
            if(flag==1)
                repaint();
            
        
        
    }
        else
        {
            g.setColor(Color.red);
            g.drawRect(originX-20*10, originY-5*10, 450, 100);
            g.setColor(Color.yellow);
            g.fillRect(originX-20*10+1, originY-5*10+1, 448, 98);
            Font f=new Font("Times New Roman",4,104);
            g.setFont(f);
            g.setColor(Color.white);
            g.drawString("THANKS", originX-20*10, originY-5*10+83);
        }
    }

    
        public void drawPoint(int x1,int y1,Graphics g,Color gx)
   {
       
       w=getWidth();
        h=getHeight();
        
        int originX=(getX()+getWidth())/2;
        int originY=(getY()+getHeight())/2;
        g.setColor(gx);
        
            x1=originX+x1*w1;
       
            y1=originY-(y1+1)*w1;
        
        g.fillRect(x1+1,y1+1,w1,h1);
        
   }
   
   
   
   public void drawLineDDA(double x11,double y11,int x2,int y2,Graphics g,int cond,Color gx)
   {
       double dx=x2-x11;
       double dy=y2-y11;
       double x1=x11;
       double y1=y11;
       double steps=Math.max(Math.abs(dx),Math.abs(dy));
       double xc=dx/steps;
       double yc=dy/steps;
       
       drawPoint((int)x1,(int)y1,g,gx);
       while(steps>0)
       {
           double xx=x1+xc;
           double yy=y1+yc;
           int xp=(int)Math.round(x1+xc);
           int yp=(int)Math.round(y1+yc);
           drawPoint(xp,yp,g,gx);
           if(cond==1)
           {
               System.out.println("Hello");
           if(xp==0)
               System.out.println("HELLO ("+x11+","+y11+") "+xp+" "+yp+" ("+x2+","+y2+")");
           if(xp>=0)
               path1[xp]=yp;
           else
               path0[-1*xp-1]=yp;
           }
           x1=xx;
           y1=yy;
           steps--;
       }
   }
   
   public void drawRect(int x1,int y1,int x2,int y2,Graphics g,Color gx)
   {
       drawLineDDA(x1,y1,x1,y2,g,0,gx);
       drawLineDDA(x1,y2,x2,y2,g,0,gx);
       drawLineDDA(x2,y2,x2,y1,g,0,gx);
       drawLineDDA(x2,y1,x1,y1,g,0,gx);
       
   }
   public void drawSemiCircle(double xc,double yc, double r,Graphics g,Color gx)
   {
       double x0=0;
       double y0=r;
       double p=5/4.0-r;
       
       drawPoint((int)Math.round(xc+x0),(int)Math.round(yc-y0),g,gx);
       drawPoint((int)Math.round(xc-x0),(int)Math.round(yc-y0),g,gx);
       
       drawPoint((int)Math.round(xc+y0),(int)Math.round(yc-x0),g,gx);
       drawPoint((int)Math.round(xc-y0),(int)Math.round(yc-x0),g,gx);
       while(x0<=y0)
       {
           x0=x0+1;
           if(p<0)
           {
               p=p+2*x0+1;
           }
           else
           {
               y0=y0-1;
               p=p+2*x0+1-2*y0;
           }
         
       drawPoint((int)Math.round(xc+x0),(int)Math.round(yc-y0),g,gx);
       drawPoint((int)Math.round(xc-x0),(int)Math.round(yc-y0),g,gx);
       
       drawPoint((int)Math.round(xc+y0),(int)Math.round(yc-x0),g,gx);
       drawPoint((int)Math.round(xc-y0),(int)Math.round(yc-x0),g,gx);
       }
       
   }
   
   public void drawCarLeft(int fwxc,int fwyc,Graphics g,Color gx)
   {
       
       drawRect(fwxc-4,fwyc,fwxc+10+4,fwyc+5,g,gx);
       drawRect(fwxc,fwyc+5,fwxc+10+4,fwyc+9,g,gx);
       drawRect(fwxc-4,fwyc+3,fwxc-2,fwyc+5,g,gx);
       drawLineDDA(fwxc+12,fwyc+1,fwxc+12,fwyc+4,g,mode,Color.red);
       Color gy=Color.white;
       drawSemiCircle(fwxc,fwyc,2,g,gy);
       drawSemiCircle(fwxc+10,fwyc,2,g,gy);
   }
   public void drawCarRight(int fwxc,int fwyc,Graphics g,Color gx)
   {
       
       drawRect(fwxc-4,fwyc,fwxc+10+4,fwyc+5,g,gx);
       drawRect(fwxc-4,fwyc+5,fwxc+10,fwyc+9,g,gx);
       drawRect(fwxc+12,fwyc+3,fwxc+14,fwyc+5,g,gx);
       drawLineDDA(fwxc-2,fwyc+1,fwxc-2,fwyc+4,g,mode,Color.red);
       Color gy=Color.white;
       drawSemiCircle(fwxc,fwyc,2,g,gy);
       drawSemiCircle(fwxc+10,fwyc,2,g,gy);
   }
   public int ypath(int x)
   {
       if(x<0)
           return path0[-1*x-1];
       else
           return path1[x];
   }
   public int ymax(int xc)
   {
       int max=-999;
       int x=xc;
       int y=ypath(x);
       max=(int)Math.max(max, y);
       x=xc+10;
       y=ypath(x);
       max=(int)Math.max(max, y);
       x=xc-4;
       y=ypath(x);
       max=(int)Math.max(max, y-2);
       x=xc+14;
       y=ypath(x);
       max=(int)Math.max(max, y-2);
       return max;
       
       
   }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
		int key=e.getKeyCode();
                
		switch(key) 
		{
			case KeyEvent.VK_UP:
				
                                
				break;
			case KeyEvent.VK_DOWN:
				
				break;
			case KeyEvent.VK_LEFT:
				posx=posx-5;
                                posy=ymax(posx+fwxc);
                                dir=0;
				break;
			case KeyEvent.VK_RIGHT:
				posx=posx+5;
                                posy=ymax(posx+fwxc);
                                dir=1;
				break;
		}
		repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent m) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            int originX=(getX()+getWidth())/2;
            int originY=(getY()+getHeight())/2;
            
            int x = (int) m.getX();
            int y = (int) m.getY();
            if(start==0)
            {
                if (x>originX-15*10 && x<originX-15*10+350 && y>originY-5*10 &&y<originY-5*10+100)
                {start=1;
                
                }
            }
            else if(start==1)
            {
            if(x>=w-100 && x<=w && y>=0 &&y<=30)
            {start=2;
            
            }
            else if(x>=0 && x<=0+100 && y>=h-30 &y<=h)
            {h1=h1*2;
                w1=w1*2;
            }
            else if(x>=w-100 && x<=w && y>=h-30 &y<=h)
            {   if(h1>2)
                {
                h1=h1/2;
                w1=w1/2;
                
                }
            mode=0;
            }
            if(input_mode==1)
            {
                if(x>=originX-99 && x<=originX+99 && y>=0 && y<=30)
                {
                    mleft=0;
                    mright=0;
                    input_mode=0;
                }
                
            }
            else if(input_mode==0)
            {
                if(x>originX-300 && x<originX-100 && y>=0 && y<=30)
                {
                    mleft=1;
                    mright=0;
                    input_mode=1;
                }
                else if(x>originX+100 && x<originX+300 && y>=0 && y<=30)
                {
                    mleft=0;
                    mright=1;
                    input_mode=1;
                }
            }
            
            
           
               
                    
            
            
            
            repaint();
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
