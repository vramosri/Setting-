package Stove_Program;

public class Burner {
	public Setting setting; 
	public enum Setting {
		 HOT("HOT SURFACE! DON'T TOUCH"), WARM("CAREFUL"), COLD("coooool");
		 
		}
	
	public Burner(Setting setting)
	{
		super(); 
		this.setting = setting; 
	}
}
