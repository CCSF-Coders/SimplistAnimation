// SimplistAnimationTest Demo
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.*;
import java.awt.event.*;

public class SimplistAnimationTest extends JFrame implements Runnable, KeyListener
{
    static int SCREENWIDTH  = 640;     // width of our window, x-axis
    static int SCREENHEIGHT = 480;     // height of our window, y-axix
    Thread gameloop;                   // the tread our gameloop happens in
    BufferedImage backbuffer;          // a buffered image
    Graphics2D g2d;                    // our G2D class where all our drawing methods live
    Point pos = new Point(300,200);    // just a point. It's not doing anything yet
    int frameCount = 0;                // a simple variable to be used a counter
    Spaceship ss ;                     // Contains all calculations for moving the spaceship 
                                       // around the window
    Image spaceship;                   // spaceship icon
 
    /* ********************* main() ********************** */
    public static void main(String[] args)
    {
        new SimplistAnimationTest();
    }
    
    /* **************** SimplistAnimationTest() ************** */
    public SimplistAnimationTest()
    {
        // these four things are needed on every new frame
        super("Simplist Animation Test");        // give it a name
        setSize(SCREENWIDTH, SCREENHEIGHT);      // give it a size
        setVisible(true);                        // Can we see it?
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // what to do when close.
        // create the back buffer for smooth graphics
        backbuffer = new BufferedImage(SCREENWIDTH, SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        g2d = backbuffer.createGraphics();
        spaceship = Toolkit.getDefaultToolkit().getImage("spaceShip1.png");
        addKeyListener(this);
        // create a new tread and call it gameloop, then start it.
        gameloop = new Thread(this);
        ss = new Spaceship();//*******
        gameloop.start();
        
    }
    
    // when the start() method of the Thread Class gets called,
    // it calls the run() method.
    /* ********************* run() ********************** */
    public void run()
    {
        // here we are getting current thread and tell saying 
        // what to do depending on what thread we're in.
        // since currenly we only have one thread (gameloop),
        // then that is all we need to worry about.

        // if we are in the gameloop thread, try to sleep for
        // 17 miliseconds, then call the gameUpdate() method below
        Thread t = Thread.currentThread();
        while (t==gameloop)
        {
           
            gameUpdate();
           

            try{
                Thread.sleep(17);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
                  
            
         }
    }
    /* ********************* gameUpdate() ********************** */
    public void gameUpdate()
    {
        // this is where the magic happens. Here is where calculate 
        // new positions for everything on the screen. This will get 
        // called several times a second and you do all your fun stuff
        // here. 

        // in this simple example, we are merely printing a black 
        // background the size of the window, and writing the position
        // of a point (that doesn't change) and the value of our frameCount
        // counter which clicks up one every time this gameUpdate() method
        // is called.
        // Clear the background
        g2d.setColor(Color.BLACK);
        g2d.fill(new Rectangle(0,0, SCREENWIDTH,SCREENHEIGHT));
        g2d.setColor(Color.WHITE);
        g2d.drawString("Position: " + pos.x +","+pos.y, 10, 50);
        g2d.drawString("Frame Count: " + frameCount, 10, 70);
        // printing a spacechip icon on different positions
        g2d.drawImage(spaceship,ss.getSpaceX(),ss.getSpaceY(),this);
        
        frameCount++;
    
        ss.update(); // update the coordinates of the spaceship 
        repaint();

        // we never call paint() directly, we call repaint() and it will 
        // call paint for us.
     }
      
   
    /* ********************** paint() *********************** */
    public void paint(Graphics g)
    {
        // draw the back buffer to the screen
       g.drawImage(backbuffer, 0, 0, this);

    }

     /* ********************** keyPressed() ********************** */
    	public void keyPressed(KeyEvent e) 
      {

		   switch (e.getKeyCode())
         {
		      case KeyEvent.VK_UP:
               ss.moveUp();
			      break;

		      case KeyEvent.VK_DOWN:
               ss.moveDown();
			      break;

		      case KeyEvent.VK_RIGHT:
			      ss.moveRight();
			      break;

		      case KeyEvent.VK_LEFT:
			      ss.moveLeft();
			      break;

		   }

	}


 /* ********************** keyReleased() *********************** */
   public void keyReleased(KeyEvent e) 
   {
		switch (e.getKeyCode()) 
      {
		   case KeyEvent.VK_UP:
            ss.stop();
			   break;

		   case KeyEvent.VK_DOWN:
            ss.stop();
			   break;

		   case KeyEvent.VK_LEFT:
			   ss.stop();
			   break;

		   case KeyEvent.VK_RIGHT:
			   ss.stop();
			   break;

		}

	}

	/* ********************** keyTyped() *********************** */
   public void keyTyped(KeyEvent e) 
   {

	}

    
}
