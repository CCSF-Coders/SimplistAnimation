import java.awt.*;
// This class coontrols the position of the spacechip in the screen
// Variables:
// spaceX and spaceY: are the coordinates of our spaceship in the screen
// moveX and moveY  : control the rates at which x and y position change
//                    (In this example is every 6 pixels)
// Our spaceship image is 80 x 80 pixels

public   class Spaceship
{
   private int spaceX = 280;// initial position of spaceship in the x-axis on the screen
   private int spaceY = 400;// initial position of spaceship in the y-axis
   private int moveX = 0;  
   private int moveY = 0;


   public  void update()
   {
      

      if(moveX < 0) // if left arrow is pressed
      {
         // if spaceship doesnt hit the left edge
         if(spaceX > 0) spaceX += moveX;    
      }

      if(moveX > 0)  // if right arrow is pressed
      {   
        // if spaceship doesnt hit right edge
         if(spaceX < 560) spaceX += moveX;     
      }

      if(moveY < 0)  // if up arrow is pressed
      {
        // if spaceship doesnt hit the upper edge
         if(spaceY > 20) spaceY += moveY;    
      }

      if(moveY > 0)  // if down arrow is pressed
      {   
         // if spaceship doesnt hit the lower edge
         if(spaceY < 400)spaceY += moveY;      
      }

   }

   //Everytime the right or left arrow is pressed, the spaceship will move 6px
   //to the right, left, up or down.
   public void moveRight()
   {
      moveX = 6;
   }

   public   void moveLeft()
   {
      moveX = -6;
   }

   public void moveUp()
   {
      moveY = -6;
   }

   public void moveDown()
   {
      moveY = 6;
   }

   public void stop()
   {
      moveX = 0;
      moveY = 0;
   }

  
   /* -----------------------------------------------------------------
                         Setters and Getters
      ----------------------------------------------------------------- */
   

   /* ********************** setSpaceX() *********************** */
   public void setSpaceX(int spaceX)
   {
      this.spaceX = spaceX;
   }

  /* ********************** setSpaceY() *********************** */
   public void setSpaceY(int spaceY)
   {
      this.spaceY = spaceY;   
   }
   
   /* ********************** getSpaceX() *********************** */
   public int getSpaceX()
   {
      return spaceX;
   }

   /* ********************** getSpaceY() *********************** */
   public   int getSpaceY()
   {
      return spaceY;
   }

}
   

   
