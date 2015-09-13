package Stove_Program;


public class Burner {

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
	



	public void setTemp(Temperature temp) {
		this.temp = temp;
	}





	public Temperature temp; 	
	
	
	public Temperature getTemp() {
		return temp;
	}

		 
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
    	case OFF: setting = Setting.LOW;   
    	case LOW: setting = Setting.MEDIUM;
    	case MEDIUM: setting = Setting.HIGH; 
    	case HIGH: setting = Setting.HIGH;
    	
    	}
    }
    
    public void decreaseSetting() 
    {
    	switch(setting)
    	{
    	case OFF: setting = Setting.OFF;   
    	case LOW: setting = Setting.OFF;
    	case MEDIUM: setting = Setting.LOW; 
    	case HIGH: setting = Setting.MEDIUM;
    	
    	}
    }
    
    
    
   
    public void updateTemperature()
	
	{
    	if (timer == 0)
    	{
    		
    	switch (setting)
    	{
    	case OFF: temp = Temperature.COLD;  
    	case LOW: temp = Temperature.WARM;
    	case MEDIUM: temp = Temperature.WARM; 
    	case HIGH: temp = Temperature.HOT; 
    	
    	}
    	
    	}
    	
    	else
    	{
    	timer--;
    	}
	}
    
    
  
    
    
    public void displayMethod()
    {
    	System.out.println(setting.toString() + "-------" + temp.toString()); 
    	
    }
    
    
	
	
}
