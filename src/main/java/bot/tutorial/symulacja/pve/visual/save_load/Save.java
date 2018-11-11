package bot.tutorial.symulacja.pve.visual.save_load;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JSpinner;

public class Save {
	public static void zapisz(JSpinner level, JSpinner hp, JSpinner bron, JSpinner sila, 
			JSpinner zrecznosc, JSpinner inteligencja, JSpinner obronaEq, JSpinner wytrzymalosc, 
			JSpinner silaWoli, JSpinner szybkosc, JSpinner szybkoscEq, JSpinner ub, JSpinner unik, 
			JSpinner karaUnik, JSpinner unikEq, JSpinner wampiryzm, JSpinner zlodziejstwo, JSpinner levelMoba, 
			boolean miasto, JSpinner liczbaSymulacji, JSpinner walkiPodRzad) {
		
		PrintWriter plik = null;
		try {
			plik = new PrintWriter("staty_gracza.txt");
			System.out.println("Nawiązano kontakt z plikiem!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Nie można znalezc pliku do zapisu.");
		}


		assert plik != null;
		plik.print(level.getValue() +"\t");
		plik.print(hp.getValue() +"\t");
		plik.print(bron.getValue() +"\t");
		plik.print(sila.getValue() +"\t");
		plik.print(zrecznosc.getValue() +"\t");
		plik.print(inteligencja.getValue() +"\t");
		plik.print(obronaEq.getValue() +"\t");
		plik.print(wytrzymalosc.getValue() +"\t");
		plik.print(silaWoli.getValue() +"\t");
		plik.print(szybkosc.getValue() +"\t");
		plik.print(szybkoscEq.getValue() +"\t");
		plik.print(ub.getValue() +"\t");
		plik.print(unik.getValue() +"\t");
		plik.print(karaUnik.getValue() +"\t");
		plik.print(unikEq.getValue() +"\t");
		plik.print(wampiryzm.getValue() +"\t");
		plik.print(zlodziejstwo.getValue() +"\t");
		plik.print(levelMoba.getValue() +"\t");
		plik.print((Boolean)miasto+"\t");
		plik.print(liczbaSymulacji.getValue() +"\t");
		plik.print(walkiPodRzad.getValue() +"\t");
		
		plik.close();
	}
}
