package Stove_Program;


public class Burner {
	
	public Temperature temp; 	
	public Setting setting; 
	final int TIME_DURATION = 2; 
	int timer = 0; 
	public enum Temperature{HOT("HOT SURFACE! DON'T TOUCH"), WARM("CAREFUL"), COLD("coooool");
		
	
		
	private String word; 
		
	Temperature(String aWord)
	{
		word = aWord; 
	}
	
	public String toString()
	{
		return word; 
	}
	
	};
	

	
	

		 
	public Burner()
	{
		super();
		setting = Setting.OFF;
		temp = Temperature.COLD; 
	}
	
	
	
    public void increaseSetting() 
    {
    	switch(setting)
    	{
    	case OFF: setting = Setting.LOW; break;  
    	case LOW: setting = Setting.MEDIUM; break;
    	case MEDIUM: setting = Setting.HIGH; break;
    	case HIGH: setting = Setting.HIGH; break;
    	
    	}
    	timer += TIME_DURATION;
    }
    
    public void decreaseSetting() 
    {
    	switch(setting)
    	{
    	case OFF: setting = Setting.OFF; break;
    	case LOW: setting = Setting.OFF; break;
    	case MEDIUM: setting = Setting.LOW; break;
    	case HIGH: setting = Setting.MEDIUM; break;
    	
    	}
    	timer += TIME_DURATION;
    }
    
    
    
   
    public void updateTemperature()
	
	{
    	//System.out.println(setting);
    	if (timer == 0)
    	{
    		
    	switch (setting)
    	{
    	case OFF: temp = Temperature.COLD; break;
    	case LOW: temp = Temperature.WARM; break;
    	case MEDIUM: temp = Temperature.WARM; break;
    	case HIGH: temp = Temperature.HOT; break;
    	
    	}
    	
    	}
    	
    	else
    	{
    	timer--;
    	}
    	//System.out.println(setting);
	}
    
    
  
    
    
    public void displayMethod()
    {
    	System.out.println(setting + "-------" + temp); 
    	
    }
	
	public Temperature getTemp() {
		return temp;
	}

    
	
	
}
