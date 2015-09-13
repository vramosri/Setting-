package Stove_Program
import java.util.ArrayList

public class Stove
{
	ArrayList burners = new ArrayList();
	boolean hot;
	private Stove(int numBurners)
	{
		for (int i = 1; i <= numBurners; i++)
			burners.add(new Burner());
		hot = false;
	}
	
	private String displayStove()
	{
		System.println("Stove -------------------");
		for (int i = 0; i < burners.size(); i++)
		{
			Burner burner = burners.get(i);
			burner.toString();
			if (burner.getTemperature() == HOT)
				hot = true;
		}
		if (hot == true)
			System.out.println("RED LIGHT - HOT BURNER ALERT");
		System.println();
	}
	public static void main(String[] args)
	{
		Stove modelX = new Stove(4);
		modelX.displayStove();
		firstSetting(modelX);
		timeSim(modelX, 6);
		//secondSetting();
		//thirdSetting();
	}
	
	private void timeSim(Stove model, int checkBackIn)
	{
		for (int i = 0; i <= checkBackIn; i++)
		{
			for (int i = 0; i < model.burners.size(); i++)
			{
				model.burners.get(i).updateTemperature();
			}
		}
	}
	
	private void firstSetting(Stove model)
	{
		for (int i = 0; i < 3; i++)
			model.burners.get(0).increaseSetting();
		for (int i = 0; i < 2; i++)
			model.burners.get(1).increaseSetting();
		model.burners.get(2).increaseSetting();
	}
}