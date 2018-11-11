package bot.tutorial.symulacja.pve.classes;

import java.util.Random;

public class Enemy implements Fighting, Loadable {
	
	public Enemy() {
		super();
	}
	
	private int level;
	private int hp;
	private double dmg;
	private double sumaSzybkosci;
	private double obrona;
	private int stalaUniku;
	private double trafienie;
	private int szansaTk;
	private double zdolnoscUniku;
	private boolean miasto;
	
	public double getSumaSzybkosci() {
		return sumaSzybkosci;
	}

	public void setSumaSzybkosci(double sumaSzybkosci) {
		this.sumaSzybkosci = sumaSzybkosci;
	}
	
	public int getSzansaTk() {
		return szansaTk;
	}

	public void setSzansaTk(int szansaTk) {
		this.szansaTk = szansaTk;
	}

	public double getStalaUniku() {
		return stalaUniku;
	}

	public void setStalaUniku(int stalaUniku) {
		this.stalaUniku = stalaUniku;
	}
	
	public double getTrafienie() {
		return trafienie;
	}

	public void setTrafienie(double trafienie) {
		this.trafienie = trafienie;
	}

	public double getZdolnoscUniku() {
		return zdolnoscUniku;
	}

	public void setZdolnoscUniku(double zdolnoscUniku) {
		this.zdolnoscUniku = zdolnoscUniku;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getDmg() {
		return dmg;
	}

	public void setDmg(double dmg) {
		this.dmg = dmg;
	}

	public double getObrona() {
		return obrona;
	}

	public void setObrona(double obrona) {
		this.obrona = obrona;
	}

	public double getExp()
	{
		return 0;
	}

	public double attack() {
		//this.getDmg()+Random.ge
		Random losuj = new Random();
		
		return (this.getDmg()+1+losuj.nextInt(this.getLevel()*5))
		*Tk.mnoznik(this.getSzansaTk());
	}

	public void load(Enemy e) {
		// TODO Auto-generated method stub
		
	}

	public void load(Enemy e, int lvl) {
		// TODO Auto-generated method stub
		
	}

	public boolean getMiasto() {
		return miasto;
	}

	public void setMiasto(boolean miasto) {
		this.miasto = miasto;
	} 
	
}
