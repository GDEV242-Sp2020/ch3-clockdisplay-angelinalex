
/**
 * The ClockDisplay12B class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * editted by angelina joy 
 * @version 2011.07.31
 */
public class ClockDisplay12B //ClockDisplay12B shows hours on 12 hr increments but stores as 12 
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay12B objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12B()
    {
        hours = new NumberDisplay(24); //keep the storage to say 24 so it can store the value as 24
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay12B objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12B(int hour, int minute)
    {
        hours = new NumberDisplay(24); // keeps the storage to say 24 
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if (hours.getValue() == 0)  
        {
            displayString = "12"+ ":" + minutes.getDisplayValue();  // loop adds 12 if hour value is 0
        }   
        
        if (hours.getValue() > 12 )   //loop subtracts 12 if hours are more than 12 
        {
           int hoursare = hours.getValue() - 12; 
           displayString = hoursare + ":" + minutes.getDisplayValue();
            
           
        }  
        
        if (hours.getValue() < 13 ) // loop displays value without any edit if the value is less than 13
        { 
        displayString = hours.getDisplayValue() +":" + minutes.getDisplayValue(); 
        } 
        
       
    }
    
    
}
