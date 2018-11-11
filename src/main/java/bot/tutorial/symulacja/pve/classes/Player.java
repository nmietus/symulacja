package bot.tutorial.symulacja.pve.classes;

import java.util.Random;

public class Player extends Enemy {

	
	public Player() {
		super();
		this.setLevel(1);
		this.setSumaSzybkosci(10000);
		this.setDmg(99);
		this.setHp(10000);
		this.setObrona(10000);
		this.setTrafienie(10000);
		this.setZdolnoscUniku(10000);
		
		this.setSzansaTk(30);
		this.setStalaUniku(20);
	}

	public double attack() {

		Random losuj = new Random();
		
		return (this.getDmg()+1+losuj.nextInt(this.getLevel()*5))
				*Tk.mnoznik(this.getSzansaTk());
	}

	public double getExp()
	{
		double fullExp = 0;

		if(this.getLevel() < 50 ) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2));
		if(this.getLevel() >= 50 && this.getLevel() < 100) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2) * 2);
		if(this.getLevel() >= 100 && this.getLevel() < 150) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2) * 4);
		if(this.getLevel() >= 150 && this.getLevel() < 200) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2) * 5);
		if(this.getLevel() >= 200 && this.getLevel() < 250) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2) * 8);
		if(this.getLevel() >= 250 && this.getLevel() < 300) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2) * 9);
		if(this.getLevel() >= 300) fullExp = (int) (50 * Math.pow((double)this.getLevel(), 2) * 11);

		return fullExp;
	}

	
}
