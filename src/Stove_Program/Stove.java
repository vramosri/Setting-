package Stove_Program;
import java.util.ArrayList;

public class Stove
{
	ArrayList<Burner> burners = new ArrayList<Burner>();
	boolean hot;
	private Stove(int numBurners)
	{
		for (int i = 1; i <= numBurners; i++)
			burners.add(new Burner());
		hot = false;
	}
	
	private void displayStove()
	{
		System.out.println("Stove -------------------");
		for (int i = 0; i < burners.size(); i++)
		{
			Burner burner = burners.get(i);
			burner.toString();
			if (burner.getTemp() == Burner.Temperature.HOT)
				hot = true;
		}
		if (hot == true)
			System.out.println("RED LIGHT - HOT BURNER ALERT");
		System.out.println();
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
	
	private static void timeSim(Stove model, int checkBackIn)
	{
		for (int i = 0; i <= checkBackIn; i++)
		{
			for (int j = 0; j < model.burners.size(); j++)
			{
				model.burners.get(j).updateTemperature();
			}
		}
		for (int k = 0; k < model.burners.size(); k++)
		{
			model.burners.get(k).displayMethod();
		}
	}
	
	private static void firstSetting(Stove model)
	{
		for (int i = 0; i < 3; i++)
			model.burners.get(0).increaseSetting();
		for (int j = 0; j < 2; j++)
			model.burners.get(1).increaseSetting();
		model.burners.get(2).increaseSetting();
	}
}