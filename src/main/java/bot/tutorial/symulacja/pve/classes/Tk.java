package bot.tutorial.symulacja.pve.classes;

import java.util.Random;

public class Tk {
	public static double mnoznik(int d)
	{
		double wynik = 1;
		Random losuj = new Random();
		
		if(d<losuj.nextInt(100)+1) 					//losowanie czy kryt w ogóle będzie
		{
			wynik = 1;
		}
		else
		{
			if(5<losuj.nextInt(100)+1)						//losowanie na odparowanie kryta
			{
				int losowanie_na_mnoznik_TK = losuj.nextInt(100);	//losowanie na siłę kryta

				if(losowanie_na_mnoznik_TK<25) wynik = 1.1;
				if(losowanie_na_mnoznik_TK>=25 && losowanie_na_mnoznik_TK<50) wynik = 1.15;
				if(losowanie_na_mnoznik_TK>=50 && losowanie_na_mnoznik_TK<70) wynik = 1.2;
				if(losowanie_na_mnoznik_TK>=70 && losowanie_na_mnoznik_TK<85) wynik = 1.3;
				if(losowanie_na_mnoznik_TK>=85 && losowanie_na_mnoznik_TK<93) wynik = 1.4;
				if(losowanie_na_mnoznik_TK>=93 && losowanie_na_mnoznik_TK<99) wynik = 1.5;
				if(losowanie_na_mnoznik_TK>=99) wynik = 9999;
				
//				if(losowanie_na_mnoznik_TK<25) wynik = 1.1;
//				if(losowanie_na_mnoznik_TK>=25 && losowanie_na_mnoznik_TK<45) wynik = 1.15;
//				if(losowanie_na_mnoznik_TK>=45 && losowanie_na_mnoznik_TK<65) wynik = 1.2;
//				if(losowanie_na_mnoznik_TK>=65 && losowanie_na_mnoznik_TK<80) wynik = 1.3;
//				if(losowanie_na_mnoznik_TK>=80 && losowanie_na_mnoznik_TK<88) wynik = 1.4;
//				if(losowanie_na_mnoznik_TK>=88 && losowanie_na_mnoznik_TK<94) wynik = 1.5;
//				if(losowanie_na_mnoznik_TK>=94 && losowanie_na_mnoznik_TK<99) wynik = 1.6;
//				if(losowanie_na_mnoznik_TK>=99) wynik = 9999;
			
			}else{
		        wynik = 0;
            }
		}
		return wynik;
	}
}