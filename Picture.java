/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kšlling and David J. Barnes (and Jacob Martin)
 * @version 2016.02.29
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private boolean drawn;
    Person man = new Person();
    boolean drawManBool = false;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        wall = new Square();
        window = new Square();
        roof = new Triangle();  
        sun = new Circle();
        drawn = false;
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(120);
            wall.makeVisible();
            
            window.changeColor("black");
            window.moveHorizontal(-120);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();
    
            roof.changeSize(60, 180);
            roof.moveHorizontal(20);
            roof.moveVertical(-60);
            roof.makeVisible();
    
            sun.changeColor("yellow");
            sun.moveHorizontal(100);
            sun.moveVertical(-40);
            sun.changeSize(80);
            sun.makeVisible();
            drawn = true;
        }
    }
    
   \\Moves the sun down at a imputed speed
    public void sunset(int speed)
    {
        if(speed != 1)
        {
          sun.slowMoveVertical((270/speed), speed); 
        }
        else
        {
        sun.slowMoveVertical(250, 1);
       }
    }
    
    \\Moves the sun up at a imputed speed
    public void sunrise(int speed)
    {
        if(speed != 1)
        {
            sun.slowMoveVertical((-270/speed), speed);
        }
        else
        {
        sun.slowMoveVertical(-250, 1);
       }
    }
    
    \\Changes the color of the sun at a variable interval
    public void rainbow(int speed)
    {
        int quick;
        if(speed != 1)
        {
           quick = 500/speed; 
        }
        else
        {
            quick = 500;
        }
        sun.changeColor("green");
        try
        {
         Thread.sleep(quick);
        }
        catch (Exception e)
        {
        }
        sun.changeColor("red");
        try
        {
         Thread.sleep(quick);
        }
        catch (Exception e)
        {
        }
        sun.changeColor("blue");
        try
        {
         Thread.sleep(quick);
        }
        catch (Exception e)
        {
        }
        sun.changeColor("magenta");
        try
        {
         Thread.sleep(quick);
        }
        catch (Exception e)
        {
        }
        sun.changeColor("tardis");
        try
        {
         Thread.sleep(quick);
        }
        catch (Exception e)
        {
        }
        sun.changeColor("yellow");
    }
    
    public void drawMan()
    {
        man.changeSize(80, 50);
        man.moveHorizontal(-20);
        man.moveVertical(15);
        man.makeVisible();
        drawManBool = true;
    }
    
    public void manHome(int speed)
    {
        if(speed != 1)
        {
            man.slowMoveHorizontal((-300/speed),speed);
        }
        else
        {
            man.slowMoveHorizontal(-270, 1);
        }
    }
    
    public void manWork(int speed)
    {
        if(speed != 1)
        {
            man.slowMoveHorizontal((300/speed),speed);
        }
        else
        {
            man.slowMoveHorizontal(270, 1);
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        wall.changeColor("black");
        window.changeColor("white");
        roof.changeColor("black");
        sun.changeColor("black");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        wall.changeColor("red");
        window.changeColor("black");
        roof.changeColor("green");
        sun.changeColor("yellow");
    }
    
    public void animation(int times)
    {
       for(int counter = 0; counter< times; counter++)
       {
        if(drawManBool == false)
       {
           drawMan();
        }
       manWork(1);
       rainbow(1);
       sunset(1);
       manHome(1);
       sunrise(1);
      }
    }
    
    public void fastAnimation(int speed, int times)
    {
        for(int counter = 0; counter < times; counter++)
        {
          if(drawManBool == false)
          {
              drawMan();
          }
          manWork(speed);
          rainbow(speed);
          sunset(speed);
          manHome(speed);
          sunrise(speed);
        }
    }
}
