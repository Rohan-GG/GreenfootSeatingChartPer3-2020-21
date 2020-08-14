import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Desktop;
import java.net.URI;

/**
 * The KaushikPendiyala class represents me and my seating location in the 
 * AP CSA classroom along with my animation and lesson
 * 
 * @author Mr. Kaehms and Kaushik Pendiyala
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 * @version 4.0 August 7, 2020
 */
public class KaushikPendiyala extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the KilgoreTrout class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public KaushikPendiyala(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public KaushikPendiyala() {
        firstName="Kaushik";
        lastName="Pendiyala";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the KaushikPendiyala actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to play video games");
                NumberOfSiblings("I have one sister who is 10 years old");
              
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
                provideLesson();
                sitDown();
            }
        
    } 
    
    /**
     * Prints the first and last name to the console, which in this case
     * is Kaushik Pendiyala
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     * 
     * This method opens a youtube link to the lesson in a new brower
     */
    public void provideLesson(){
        while (! sitting) {
            
        String q=Greenfoot.ask("Are you ready to start (yes/no)");
        if (q.contains("yes")){
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://www.youtube.com/watch?v=FwiyK9Z5SMI");
            desktop.browse(oURL);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
        
    }
    public void answerQuestion(){
        // may not need
    }
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     * 
     * This sets the position of the kaushikpendiyala.standing image every 
     * second. I randomized the movement and rotated the image every act.
     */
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(2^i,0+i);
            turn(30);
            Greenfoot.delay(3);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9-i,2^i);
            turn(30);
            Greenfoot.delay(3);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(2^i,5-i/2);
            turn(30);
            Greenfoot.delay(3);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            turn(60);
            Greenfoot.delay(3);
        }   
           Greenfoot.delay(20);
           returnToSeat();
    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     * myHobby prints out what I like to do, which is playing video games
     */
     public void myHobby(String s) {
         System.out.println(s);
}
    /**
     * NumberOfSiblings prints out the number of sibling that I have, which is
     * one
     */
    public void NumberOfSiblings(String s) {
         System.out.println(s);
}

}