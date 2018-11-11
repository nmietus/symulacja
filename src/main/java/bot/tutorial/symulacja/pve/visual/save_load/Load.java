package bot.tutorial.symulacja.pve.visual.save_load;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.*;

public class Load {
	public static void wczytaj(JSpinner level, JSpinner hp, JSpinner bron, JSpinner sila,
							   JSpinner zrecznosc, JSpinner inteligencja, JSpinner obronaEq, JSpinner wytrzymalosc,
							   JSpinner silaWoli, JSpinner szybkosc, JSpinner szybkoscEq, JSpinner ub, JSpinner unik,
							   JSpinner karaUnik, JSpinner unikEq, JSpinner wampiryzm, JSpinner zlodziejstwo, JSpinner levelMoba,
							   JRadioButton rdbtnElakka, JRadioButton rdbtnSith, JSpinner liczbaSymulacji, JSpinner walkiPodRzad) {
		
		Scanner skan = null;
		try 
		{
			skan = new Scanner(new File("staty_gracza.txt"));
			
			System.out.println("Wczytano staty!");
		} catch(Exception error) 
		{
			System.out.println("Nie można wczytać pliku");
		}

        assert skan != null;
        skan.useLocale(new Locale("en"));		//żeby interpretował kropki jako przecinki podczas odczytywania z pliku
		//useLocale(new Locale("en"));
		
		level.setValue(skan.nextInt());
		hp.setValue(skan.nextInt());
		bron.setValue(skan.nextInt());
		sila.setValue(skan.nextDouble());
		zrecznosc.setValue(skan.nextDouble());
		inteligencja.setValue(skan.nextDouble());
		obronaEq.setValue(skan.nextInt());
		wytrzymalosc.setValue(skan.nextDouble());
		silaWoli.setValue(skan.nextDouble());
		szybkosc.setValue(skan.nextDouble());
		szybkoscEq.setValue(skan.nextInt());
		ub.setValue(skan.nextDouble());
		unik.setValue(skan.nextDouble());
		karaUnik.setValue(skan.nextDouble());
		unikEq.setValue(skan.nextInt());
		wampiryzm.setValue(skan.nextDouble());
		zlodziejstwo.setValue(skan.nextDouble());
		levelMoba.setValue(skan.nextInt());
		if(skan.nextBoolean()) rdbtnElakka.setSelected(true);
		else rdbtnSith.setSelected(true);
		liczbaSymulacji.setValue(skan.nextInt());
		walkiPodRzad.setValue(skan.nextInt());
		
		skan.close();
	}
}
