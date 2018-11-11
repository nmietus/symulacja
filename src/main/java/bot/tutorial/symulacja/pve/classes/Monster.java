package bot.tutorial.symulacja.pve.classes;

import java.io.File;
import java.util.Scanner;

public class Monster extends Enemy implements Loadable {
	
	private boolean miasto;	//wartość true oznacza Elakkę, a false Sith
	private double exp;

	public Monster() {
		super();
		this.miasto = true;
		this.setStalaUniku(1);
		this.setSzansaTk(0);
	}

	public boolean getMiasto() {
		return miasto;
	}

	public void setMiasto(boolean miasto) {
		this.miasto = miasto;
	}

	public double getExp()
	{
		return this.exp;
	}
	
	public void load(Enemy e, int lvl) 
	{
		Scanner skan = null;
		try 
		{
			if(miasto) skan = new Scanner(new File("staty_moba_elakka.txt"));
			else skan = new Scanner(new File("staty_moba_sith.txt")); 
			
			System.out.println("Wczytano staty!");
		} catch(Exception error) {
			System.out.println("Nie można wczytać pliku");
		}
		
		
		while(skan.hasNext()) 
		{
				this.setLevel(skan.nextInt());
				this.setHp(skan.nextInt());
				this.setTrafienie(skan.nextDouble());
				this.setZdolnoscUniku(this.getTrafienie());		//tego nie odczytujemy z pliku tylko przepisujemy z trafienia
				this.setDmg(skan.nextDouble());
				this.setSumaSzybkosci(skan.nextDouble());
				this.setObrona(skan.nextDouble());
				this.exp = (skan.nextDouble()+skan.nextDouble())/2;
				//skan.next();
				
				
				if(lvl==this.getLevel()) {
					
					break;
				} else {
					this.setLevel(0);
					this.setHp(0);
					this.setTrafienie(0);
					this.setZdolnoscUniku(0);
					this.setDmg(0);
					this.setSumaSzybkosci(0);
					this.setObrona(0);
					
				}
		}
		
		System.out.println(this.getLevel()+" "+this.getHp()+" "+this.getTrafienie()+" "+
				this.getDmg()+" "+this.getSumaSzybkosci()+" "+this.getObrona());
		
		skan.close();
	}
}
