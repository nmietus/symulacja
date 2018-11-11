package bot.tutorial.symulacja.pve.classes;

class Bilans {
	
	static int bilans_atakow(Enemy e1, Enemy e2) {
		int numer = 0;
		
		double iloraz = e1.getSumaSzybkosci()/e2.getSumaSzybkosci();
		
		if(iloraz < 0.25) numer = 1;
		else if(iloraz <= 0.33) numer = 2;
		else if(iloraz <= 0.5) numer = 3;
		else if(iloraz <= 1) numer = 4;
		
		else if(iloraz <= 2) numer = 5;
		else if(iloraz <= 3) numer = 6;
		else if(iloraz <= 4) numer = 7;
		else if(iloraz > 4) numer = 8;
		
		return numer;
	}
}
