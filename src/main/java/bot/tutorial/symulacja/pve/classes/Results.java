package bot.tutorial.symulacja.pve.classes;

import java.text.DecimalFormat;

import javax.swing.JTextField;

public class Results {
	
	private double wygrane;
	private double przegrane;
	private double remisy;
	
	private int exp;
	
	private double ub;
	private double uniki;
	
	public Results() {
		super();
		wygrane = 0;
		przegrane = 0;
		remisy = 0;
		exp = 0;
		ub = 0;
		uniki = 0;
	}

	public double getWygrane() {
		return wygrane;
	}

	public void setWygrane(double wygrane) {
		this.wygrane = wygrane;
	}

	public double getPrzegrane() {
		return przegrane;
	}

	public void setPrzegrane(double przegrane) {
		this.przegrane = przegrane;
	}

	public double getRemisy() {
		return remisy;
	}

	public void setRemisy(double remisy) {
		this.remisy = remisy;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public double getUb() {
		return ub;
	}

	public void setUb(double ub) {
		this.ub = ub;
	}

	public double getUniki() {
		return uniki;
	}

	public void setUniki(double uniki) {
		this.uniki = uniki;
	}
	
	public void addUnik(int unikniecia, Enemy e1) {
		double wynik = 0;
//		double stala_uniku=0;
//
		wynik = 0.1*unikniecia/e1.getStalaUniku();
		
		setUniki(this.getUniki()+wynik);
	}
	
	public void show(JTextField srUb, JTextField srUnik, JTextField srEnergia,
			JTextField srWygrane, JTextField srRemisy, JTextField srPrzegrane,
					 Enemy e1, Enemy e2, int ile)
	{
		DecimalFormat srUm = new DecimalFormat("###.######");
		DecimalFormat srWyniki = new DecimalFormat("###.##");
		
		srUb.setText(srUm.format(this.getUb()));
		srUnik.setText(srUm.format(this.getUniki()));
		srWygrane.setText(srWyniki.format(this.getWygrane())+"%");
		srRemisy.setText(srWyniki.format(this.getRemisy())+"%");
		srPrzegrane.setText(srWyniki.format(this.getPrzegrane())+"%");

		srEnergia.setText(srEnergia(e1, e2, ile) + "");
		
		System.out.println("Wygranych walk: "+this.getWygrane()+", przegranych walk: "
				+this.getPrzegrane()+", remisów: "+this.getRemisy()+", "
				+this.getUb()+" UB, "+this.getUniki()+" uników");
	}

	private int srEnergia(Enemy e1, Enemy e2, int ile)	//funkcja licząca średnią energię TODO
	{
		double tempEnergia = 1;
		double tempMn = 1;
		if((double)e2.getLevel()/(double)e1.getLevel() > 2) tempMn = 2;			//warunek że max mnożnik z levela to 2
		else tempMn = (double)e2.getLevel() / (double)e1.getLevel();

		System.out.println("Mnożnik z leveli to: " + tempMn);
		System.out.println("Exp potrzebny na zdobycie levela to: " + e1.getExp());
		System.out.println("Exp bazowy z moba to: " + e2.getExp());
		System.out.println("Liczba wygranych to: " + this.getWygrane() + " z " + ile);
		tempEnergia = (e1.getExp() / (tempMn * e2.getExp())) / (this.getWygrane() * 0.01 );
		System.out.println("Energia przed zaokrągleniem to: " + tempEnergia);
		tempEnergia = Math.ceil(tempEnergia);

		return (int)tempEnergia;
	}
}
