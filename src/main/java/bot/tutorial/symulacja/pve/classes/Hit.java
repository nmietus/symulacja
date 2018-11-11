package bot.tutorial.symulacja.pve.classes;

import java.util.Random;

public class Hit {
	public static boolean Trafienie(double traf, double unik) {
		boolean wynik = false;
		
		int szansa = (int)((Math.log10(traf+200)-Math.log10(unik+200))*500+50);
		if(szansa<3) szansa = 3;
		if(szansa>97) szansa = 97;

		Random losuj = new Random();
		
		if(szansa<losuj.nextInt(100)+1) wynik = false;
		else wynik = true;
		
		return wynik;
	}
}
