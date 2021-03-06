
/**
 * The ClockDisplay12 class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 *  * editted by angelina joy 
 * @version 2011.07.31
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;  
    private String meridian; //for am pm
    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay12 objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12); //changed to 12
        minutes = new NumberDisplay(60);
        meridian = "am"; 
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay12 objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12(int hour, int minute, String ampm)
    {
        hours = new NumberDisplay(12); //changed to 12
        minutes = new NumberDisplay(60);
        setTime(hour, minute, ampm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
        {
        minutes.increment();
        
        if(minutes.getValue() == 0) { 
            // it just rolled over!
            hours.increment();
             
        if(hours.getValue()==12) 
        { 
            meridian = "pm";
        }
        else 
        {
            meridian = "am";
        }
    }
    if (hours.getValue() == 0)
    {
        hours.setValue(1);
    }
     
        updateDisplay();
    }
    

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String ampm)
    {
        if (hour == 0)
        {
            hour = 12;
        }
        
        hours.setValue(hour);
        minutes.setValue(minute);
        meridian = ampm;
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
        if (hours.getValue()==0)
        displayString = "12"+ ":" + minutes.getDisplayValue() + meridian; //formats that hour that is 00, turns to 12
        else
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + meridian; //if not 0  
    }
}
