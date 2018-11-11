package bot.tutorial.symulacja.pve.classes;

import javax.swing.JTextField;

public class Fight {
	
	public void walka(int liczbaSymulacji, int walkiPodRzad, Enemy e1, Enemy e2,
			JTextField srUb, JTextField srUnik, JTextField srEnergia,
			JTextField srWygrane, JTextField srRemisy, JTextField srPrzegrane) {
		
		int hpGracza = e1.getHp();
		int hpMoba = e2.getHp();
		
		Results wyniki = new Results();
		
		for (int k = 0; k < liczbaSymulacji; k++)
		{
			for(int j = 0; j < walkiPodRzad; j++)	//TODO trzeba wyciągnąć ze środka wyniki walk
			{
				for(int i = 0; i < 24; i++)
				{
					Round.Runda(e1, e2, wyniki);
				}
				if(e1.getHp()>0 && e2.getHp()>0) wyniki.setRemisy(wyniki.getRemisy()+1);
				e2.setHp(hpMoba);
			}
			e1.setHp(hpGracza);
		}

		wyniki.setUb(wyniki.getUb()/liczbaSymulacji);
		wyniki.setUniki(wyniki.getUniki()/liczbaSymulacji);
		wyniki.setWygrane(100*wyniki.getWygrane()/liczbaSymulacji);
		wyniki.setRemisy(100*wyniki.getRemisy()/liczbaSymulacji);
		wyniki.setPrzegrane(100*wyniki.getPrzegrane()/liczbaSymulacji);
		
		wyniki.show(srUb, srUnik, srEnergia, srWygrane, srRemisy, srPrzegrane, e1, e2, liczbaSymulacji);
	}
}
