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
			burner.displayMethod();
			if (burner.getTemp() == Burner.Temperature.HOT)
				hot = true;
		}
		if (hot == true)
			System.out.println("RED LIGHT - HOT BURNER ALERT");
		hot = false;
		System.out.println();
	}
	public static void main(String[] args)
	{
		Stove modelX = new Stove(4);// create a new stove called modelX with 4 burners
		modelX.displayStove();		// display initial state of the stove
		firstSetting(modelX);		// adjust settings the first time
		timeSim(modelX, 6);			// run simulation for 6 minutes/loops
		modelX.displayStove();		// display state of the stove after 6 minutes/loops
		secondSetting(modelX);      // adjust the settings for the second time
		timeSim(modelX,4); 			// run simulation for 4 minutes 
		modelX.displayStove(); 		// Will display stove after 4 minutes 
		thirdSetting(modelX);		// adjust the settings for the third time 
		timeSim(modelX,2);			// run simulation for 2 minutes 
		modelX.displayStove(); 		// display the state of the stove after 2 minutes 
	}
	
	private static void timeSim(Stove model, int checkBackIn)
	{								// update temperature for all burners every minute until simulation time is up
		for (int i = 0; i <= checkBackIn; i++)
		{
			for (int j = 0; j < model.burners.size(); j++)
			{
				model.burners.get(j).updateTemperature();
			}
		}

	}
	
	private static void firstSetting(Stove model)
	{
		for (int i = 0; i < 3; i++)					// loop three times
		{
			model.burners.get(0).increaseSetting(); // for burner #0 (first burner), increase setting per loop
		}											// so it goes from OFF>LOW, LOW>MED, MED>HIGH
		for (int j = 0; j < 2; j++)					// loop twice
		{
			model.burners.get(1).increaseSetting(); // for burner #1 (second burner), increase setting per loop
		}											// so it goes from OFF>LOW, LOW>MED
		model.burners.get(2).increaseSetting();		// for burner #2 (third burner), increase setting once, so it's OFF>LOW
	}
	
	private static void secondSetting(Stove model)
	{
		for (int i = 0; i < 2; i++)					// loop twice
		{
			model.burners.get(0).decreaseSetting();	// for burner #0 (first burner), decrease setting per loop
		}											// so it goes from HIGH>MED, MED>LOW
		for (int j = 0; j < 1; j++)					// loop once
		{
			model.burners.get(1).increaseSetting(); // for burner #1 (second burner), increase setting per loop
		}											// so it goes from MED>HIGH
		model.burners.get(2).decreaseSetting();		// for burner #2 (third burner), decrease setting once, so it's LOW>OFF
	}
	
	private static void thirdSetting(Stove model)
	{
		for (int i = 0; i < 1; i++)					// loop once
		{
			model.burners.get(0).decreaseSetting();	// for burner #0 (first burner), decrease setting per loop
		}											// so it goes from LOW>OFF
		for (int j = 0; j < 1; j++)					// loop once
		{
			model.burners.get(1).decreaseSetting();	// for burner #1 (second burner), decrease setting per loop
		}											// so it goes from HIGH>MED
		model.burners.get(2).decreaseSetting();		// for burner #2 (third burner), decrease setting once
	}												// but it's already OFF, so it stays OFF
	
	
	
}