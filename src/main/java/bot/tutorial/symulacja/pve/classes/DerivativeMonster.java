package bot.tutorial.symulacja.pve.classes;

import javax.swing.JTextField;

public class DerivativeMonster {
	public static void przeliczDmg(Enemy e, JTextField minDmg, JTextField maxDmg) {
		double minDmgMob = e.getDmg()+1;
		double maxDmgMob = e.getDmg()+e.getLevel()*5;
		
		minDmg.setText(minDmgMob+"");
		maxDmg.setText(maxDmgMob+"");
	}
}
