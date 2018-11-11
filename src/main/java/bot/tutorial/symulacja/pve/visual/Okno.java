package bot.tutorial.symulacja.pve.visual;

import bot.tutorial.symulacja.pve.classes.*;
import bot.tutorial.symulacja.pve.visual.save_load.Load;
import bot.tutorial.symulacja.pve.visual.save_load.Save;

import javax.swing.*;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame 
{
	private JButton btnStart;
	
	private Enemy p = new Player();
	private Enemy m = new Monster();
	
	private JTextField textAtakMoba;
	private JTextField textObronaMoba;
	private JTextField textTrafienieUnikMoba;
	private JTextField textHpMoba;
	private JTextField textSzybkoscMoba;
	private JTextField textMinDmgMoba;
	private JTextField textMinAtakGracza;
	private JTextField textSzansaTrafieniaGracza;
	private JTextField textMaxKryt10;
	private JTextField textMinKryt10;
	private JTextField textMaxDmgMoba;
	private JTextField textMaxAtakGracza;
	private JTextField textSzansaUnikuGracza;
	private JTextField textMaxKryt15;
	private JTextField textMinKryt15;
	private JTextField textMaxKryt20;
	private JTextField textMinKryt20;
	private JTextField textMaxKryt30;
	private JTextField textMinKryt30;
	private JTextField textMaxKryt40;
	private JTextField textMinKryt40;
	private JTextField textMaxKryt50;
	private JTextField textMinKryt50;
	private JTextField textSzansaTk;
	private JTextField textStalaUniku;
	private JTextField textSrUb;
	private JTextField textSrUnik;
	private JTextField textSrEnergia;
	private JSpinner spinnerLevelMoba;
	private JTextField textTrafienieGracza;
	private JTextField textZdolnoscUnikuGracza;
	private JSpinner spinnerLevel;
	private JSpinner spinnerUnik;
	private JSpinner spinnerUb;
	private JSpinner spinnerSzybkosc;
	private JSpinner spinnerSzybkoscBroni;
	private JSpinner spinnerHp;
	private JSpinner spinnerBron;
	private JSpinner spinnerSila;
	private JSpinner spinnerZrecznosc;
	private JSpinner spinnerInteligencja;
	private JSpinner spinnerWampiryzm;
	private JSpinner spinnerZlodziejstwo;
	private JSpinner spinnerUnikZEq;
	private JSpinner spinnerKaraDoUniku;
	private JTextField textObronaGracza;
	private JSpinner spinnerWytrzymalosc;
	private JSpinner spinnerObronaZEq;
	private JSpinner spinnerSilaWoli;
	private JSpinner spinnerLiczbaSymulacji;
	private JSpinner spinnerWalkiPodRzad;
	private JRadioButton rdbtnElakka;
	private JRadioButton rdbtnSith;
	private JTextField textWygrane;
	private JTextField textRemisy;
	private JTextField textPrzegrane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textDmgGracza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Okno frame = new Okno();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Okno()
	{
		createControls();
		createEvents();

		load();
		setMob();
		
	}
	
	//tworzy obiekty klasy wizualnej
	private void createControls() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 594);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart = new JButton("S Y M U L U J");
		btnStart.setBounds(149, 500, 572, 45);
		contentPane.add(btnStart);
		
		spinnerLevel = new JSpinner();
		spinnerLevel.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerLevel.setName("");
		spinnerLevel.setBounds(111, 26, 78, 20);
		contentPane.add(spinnerLevel);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setBounds(111, 11, 46, 14);
		contentPane.add(lblLevel);
		
		spinnerHp = new JSpinner();
		spinnerHp.setModel(new SpinnerNumberModel(4, 4, null, 1));
		spinnerHp.setName("");
		spinnerHp.setBounds(199, 26, 78, 20);
		contentPane.add(spinnerHp);
		
		JLabel labelHp = new JLabel("HP");
		labelHp.setBounds(199, 11, 46, 14);
		contentPane.add(labelHp);
		
		spinnerSila = new JSpinner();
		spinnerSila.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerSila.setName("");
		spinnerSila.setBounds(111, 72, 78, 20);
		contentPane.add(spinnerSila);
		
		JLabel lblSila = new JLabel("Siła");
		lblSila.setBounds(111, 57, 78, 14);
		contentPane.add(lblSila);
		
		spinnerBron = new JSpinner();
		spinnerBron.setName("");
		spinnerBron.setBounds(23, 72, 78, 20);
		contentPane.add(spinnerBron);
		
		JLabel labelBron = new JLabel("Broń");
		labelBron.setBounds(23, 57, 78, 14);
		contentPane.add(labelBron);
		
		spinnerZrecznosc = new JSpinner();
		spinnerZrecznosc.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerZrecznosc.setName("");
		spinnerZrecznosc.setBounds(199, 72, 78, 20);
		contentPane.add(spinnerZrecznosc);
		
		JLabel lblZrecznosc = new JLabel("Zręczność");
		lblZrecznosc.setBounds(199, 57, 78, 14);
		contentPane.add(lblZrecznosc);
		
		spinnerInteligencja = new JSpinner();
		spinnerInteligencja.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerInteligencja.setName("");
		spinnerInteligencja.setBounds(287, 72, 78, 20);
		contentPane.add(spinnerInteligencja);
		
		JLabel lblInteligencja = new JLabel("Inteligencja");
		lblInteligencja.setBounds(287, 57, 78, 14);
		contentPane.add(lblInteligencja);
		
		spinnerObronaZEq = new JSpinner();
		spinnerObronaZEq.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerObronaZEq.setName("");
		spinnerObronaZEq.setBounds(23, 109, 78, 20);
		contentPane.add(spinnerObronaZEq);
		
		JLabel lblObronaZEq = new JLabel("Obrona z eq");
		lblObronaZEq.setBounds(23, 94, 78, 14);
		contentPane.add(lblObronaZEq);
		
		spinnerWytrzymalosc = new JSpinner();
		spinnerWytrzymalosc.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerWytrzymalosc.setName("");
		spinnerWytrzymalosc.setBounds(111, 109, 78, 20);
		contentPane.add(spinnerWytrzymalosc);
		
		JLabel lblWytrzymalosc = new JLabel("Wytrzymałość");
		lblWytrzymalosc.setBounds(111, 94, 78, 14);
		contentPane.add(lblWytrzymalosc);
		
		spinnerSilaWoli = new JSpinner();
		spinnerSilaWoli.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerSilaWoli.setName("");
		spinnerSilaWoli.setBounds(199, 109, 78, 20);
		contentPane.add(spinnerSilaWoli);
		
		JLabel lblSilaWoli = new JLabel("Siła woli");
		lblSilaWoli.setBounds(199, 94, 78, 14);
		contentPane.add(lblSilaWoli);
		
		spinnerSzybkosc = new JSpinner();
		spinnerSzybkosc.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerSzybkosc.setName("");
		spinnerSzybkosc.setBounds(287, 109, 78, 20);
		contentPane.add(spinnerSzybkosc);
		
		JLabel lblSzybkosc = new JLabel("Szybkość");
		lblSzybkosc.setBounds(287, 94, 78, 14);
		contentPane.add(lblSzybkosc);
		
		spinnerUb = new JSpinner();
		spinnerUb.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerUb.setName("");
		spinnerUb.setBounds(111, 148, 78, 20);
		contentPane.add(spinnerUb);
		
		JLabel lblUb = new JLabel("Um. bojowa");
		lblUb.setBounds(111, 133, 78, 14);
		contentPane.add(lblUb);
		
		spinnerSzybkoscBroni = new JSpinner();
		spinnerSzybkoscBroni.setName("");
		spinnerSzybkoscBroni.setBounds(23, 148, 78, 20);
		contentPane.add(spinnerSzybkoscBroni);
		
		JLabel lblSzybkoscBroni = new JLabel("Szybkość broni");
		lblSzybkoscBroni.setBounds(23, 133, 78, 14);
		contentPane.add(lblSzybkoscBroni);
		
		spinnerUnik = new JSpinner();
		spinnerUnik.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerUnik.setName("");
		spinnerUnik.setBounds(199, 148, 78, 20);
		contentPane.add(spinnerUnik);
		
		JLabel lblUnik = new JLabel("Unik");
		lblUnik.setBounds(199, 133, 78, 14);
		contentPane.add(lblUnik);
		
		spinnerKaraDoUniku = new JSpinner();
		spinnerKaraDoUniku.setModel(new SpinnerNumberModel(0.0, null, 100.0, 1.0));
		spinnerKaraDoUniku.setName("");
		spinnerKaraDoUniku.setBounds(287, 148, 78, 20);
		contentPane.add(spinnerKaraDoUniku);
		
		JLabel lblKaraDoUniku = new JLabel("Kara do uniku");
		lblKaraDoUniku.setBounds(287, 133, 78, 14);
		contentPane.add(lblKaraDoUniku);
		
		spinnerUnikZEq = new JSpinner();
		spinnerUnikZEq.setName("");
		spinnerUnikZEq.setBounds(23, 185, 78, 20);
		contentPane.add(spinnerUnikZEq);
		
		JLabel lblUnikZEq = new JLabel("Unik z eq");
		lblUnikZEq.setBounds(23, 170, 78, 14);
		contentPane.add(lblUnikZEq);
		
		spinnerWampiryzm = new JSpinner();
		spinnerWampiryzm.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerWampiryzm.setAutoscrolls(true);
		spinnerWampiryzm.setName("");
		spinnerWampiryzm.setBounds(111, 185, 78, 20);
		contentPane.add(spinnerWampiryzm);
		
		JLabel lblWampiryzm = new JLabel("Wampiryzm");
		lblWampiryzm.setBounds(111, 170, 78, 14);
		contentPane.add(lblWampiryzm);
		
		spinnerZlodziejstwo = new JSpinner();
		spinnerZlodziejstwo.setModel(new SpinnerNumberModel(0, null, null, 1));
		spinnerZlodziejstwo.setName("");
		spinnerZlodziejstwo.setBounds(199, 185, 78, 20);
		contentPane.add(spinnerZlodziejstwo);
		
		JLabel lblZlodziejstwo = new JLabel("Złodziejstwo");
		lblZlodziejstwo.setBounds(199, 170, 78, 14);
		contentPane.add(lblZlodziejstwo);
		
		spinnerLevelMoba = new JSpinner();
		spinnerLevelMoba.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spinnerLevelMoba.setName("");
		spinnerLevelMoba.setBounds(23, 301, 78, 20);
		contentPane.add(spinnerLevelMoba);
		
		JLabel lblLevelMoba = new JLabel("Level moba");
		lblLevelMoba.setBounds(23, 286, 78, 14);
		contentPane.add(lblLevelMoba);
		
		textAtakMoba = new JTextField();
		textAtakMoba.setEditable(false);
		textAtakMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textAtakMoba.setText("0");
		textAtakMoba.setBounds(111, 301, 78, 20);
		contentPane.add(textAtakMoba);
		textAtakMoba.setColumns(10);
		
		JLabel lblAtakMoba = new JLabel("Atak moba");
		lblAtakMoba.setBounds(111, 286, 78, 14);
		contentPane.add(lblAtakMoba);
		
		textObronaMoba = new JTextField();
		textObronaMoba.setEditable(false);
		textObronaMoba.setText("0");
		textObronaMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textObronaMoba.setColumns(10);
		textObronaMoba.setBounds(111, 341, 78, 20);
		contentPane.add(textObronaMoba);
		
		JLabel lblObronaMoba = new JLabel("Obrona moba");
		lblObronaMoba.setBounds(111, 326, 78, 14);
		contentPane.add(lblObronaMoba);
		
		textTrafienieUnikMoba = new JTextField();
		textTrafienieUnikMoba.setEditable(false);
		textTrafienieUnikMoba.setText("0");
		textTrafienieUnikMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textTrafienieUnikMoba.setColumns(10);
		textTrafienieUnikMoba.setBounds(111, 382, 78, 20);
		contentPane.add(textTrafienieUnikMoba);
		
		JLabel lblTrafienieUnikMoba = new JLabel("Trafienie/unik");
		lblTrafienieUnikMoba.setBounds(111, 367, 78, 14);
		contentPane.add(lblTrafienieUnikMoba);
		
		textHpMoba = new JTextField();
		textHpMoba.setEditable(false);
		textHpMoba.setText("0");
		textHpMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textHpMoba.setColumns(10);
		textHpMoba.setBounds(111, 463, 78, 20);
		contentPane.add(textHpMoba);
		
		JLabel lblHpMoba = new JLabel("HP moba");
		lblHpMoba.setBounds(111, 448, 78, 14);
		contentPane.add(lblHpMoba);
		
		textSzybkoscMoba = new JTextField();
		textSzybkoscMoba.setEditable(false);
		textSzybkoscMoba.setText("0");
		textSzybkoscMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textSzybkoscMoba.setColumns(10);
		textSzybkoscMoba.setBounds(111, 422, 78, 20);
		contentPane.add(textSzybkoscMoba);
		
		JLabel lblSzybkoscMoba = new JLabel("Szybkosc moba");
		lblSzybkoscMoba.setBounds(111, 407, 78, 14);
		contentPane.add(lblSzybkoscMoba);
		
		rdbtnElakka = new JRadioButton("Elakka");
		buttonGroup.add(rdbtnElakka);
		rdbtnElakka.setBounds(21, 328, 80, 23);
		contentPane.add(rdbtnElakka);
		
		rdbtnSith = new JRadioButton("Sith");
		buttonGroup.add(rdbtnSith);
		rdbtnSith.setBounds(21, 354, 80, 23);
		contentPane.add(rdbtnSith);
		
		textMinDmgMoba = new JTextField();
		textMinDmgMoba.setText("0");
		textMinDmgMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinDmgMoba.setEditable(false);
		textMinDmgMoba.setColumns(10);
		textMinDmgMoba.setBounds(287, 301, 78, 20);
		contentPane.add(textMinDmgMoba);
		
		JLabel lblMinDmgMoba = new JLabel("Min dmg moba");
		lblMinDmgMoba.setBounds(287, 286, 78, 14);
		contentPane.add(lblMinDmgMoba);
		
		textMinAtakGracza = new JTextField();
		textMinAtakGracza.setText("0");
		textMinAtakGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinAtakGracza.setEditable(false);
		textMinAtakGracza.setColumns(10);
		textMinAtakGracza.setBounds(287, 341, 78, 20);
		contentPane.add(textMinAtakGracza);
		
		JLabel lblMinAtakGracza = new JLabel("Min atak gracza");
		lblMinAtakGracza.setBounds(287, 326, 78, 14);
		contentPane.add(lblMinAtakGracza);
		
		textSzansaTrafieniaGracza = new JTextField();
		textSzansaTrafieniaGracza.setText("0");
		textSzansaTrafieniaGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textSzansaTrafieniaGracza.setEditable(false);
		textSzansaTrafieniaGracza.setColumns(10);
		textSzansaTrafieniaGracza.setBounds(287, 382, 78, 20);
		contentPane.add(textSzansaTrafieniaGracza);
		
		JLabel lblTrafienieGracza = new JLabel("Szansa trafienia gracza");
		lblTrafienieGracza.setBounds(253, 367, 112, 14);
		contentPane.add(lblTrafienieGracza);
		
		textMaxKryt10 = new JTextField();
		textMaxKryt10.setText("0");
		textMaxKryt10.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxKryt10.setEditable(false);
		textMaxKryt10.setColumns(10);
		textMaxKryt10.setBounds(287, 463, 78, 20);
		contentPane.add(textMaxKryt10);
		
		JLabel lblMax = new JLabel("Max *1.1");
		lblMax.setBounds(287, 448, 78, 14);
		contentPane.add(lblMax);
		
		textMinKryt10 = new JTextField();
		textMinKryt10.setText("0");
		textMinKryt10.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinKryt10.setEditable(false);
		textMinKryt10.setColumns(10);
		textMinKryt10.setBounds(287, 422, 78, 20);
		contentPane.add(textMinKryt10);
		
		JLabel lblMin = new JLabel("Min *1.1");
		lblMin.setBounds(287, 407, 78, 14);
		contentPane.add(lblMin);
		
		textMaxDmgMoba = new JTextField();
		textMaxDmgMoba.setText("0");
		textMaxDmgMoba.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxDmgMoba.setEditable(false);
		textMaxDmgMoba.setColumns(10);
		textMaxDmgMoba.setBounds(392, 301, 78, 20);
		contentPane.add(textMaxDmgMoba);
		
		JLabel lblMaxDmgMoba = new JLabel("Max dmg moba");
		lblMaxDmgMoba.setBounds(392, 286, 78, 14);
		contentPane.add(lblMaxDmgMoba);
		
		textMaxAtakGracza = new JTextField();
		textMaxAtakGracza.setText("0");
		textMaxAtakGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxAtakGracza.setEditable(false);
		textMaxAtakGracza.setColumns(10);
		textMaxAtakGracza.setBounds(392, 341, 78, 20);
		contentPane.add(textMaxAtakGracza);
		
		JLabel lblMaxAtakGracza = new JLabel("Max atak gracza");
		lblMaxAtakGracza.setBounds(391, 326, 79, 14);
		contentPane.add(lblMaxAtakGracza);
		
		textSzansaUnikuGracza = new JTextField();
		textSzansaUnikuGracza.setText("0");
		textSzansaUnikuGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textSzansaUnikuGracza.setEditable(false);
		textSzansaUnikuGracza.setColumns(10);
		textSzansaUnikuGracza.setBounds(392, 382, 78, 20);
		contentPane.add(textSzansaUnikuGracza);
		
		JLabel lblSzansaUnikuGracza = new JLabel("Szansa uniku gracza");
		lblSzansaUnikuGracza.setBounds(373, 367, 97, 14);
		contentPane.add(lblSzansaUnikuGracza);
		
		textMaxKryt15 = new JTextField();
		textMaxKryt15.setText("0");
		textMaxKryt15.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxKryt15.setEditable(false);
		textMaxKryt15.setColumns(10);
		textMaxKryt15.setBounds(392, 463, 78, 20);
		contentPane.add(textMaxKryt15);
		
		JLabel lblMax_1 = new JLabel("Max *1.15");
		lblMax_1.setBounds(392, 448, 78, 14);
		contentPane.add(lblMax_1);
		
		textMinKryt15 = new JTextField();
		textMinKryt15.setText("0");
		textMinKryt15.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinKryt15.setEditable(false);
		textMinKryt15.setColumns(10);
		textMinKryt15.setBounds(392, 422, 78, 20);
		contentPane.add(textMinKryt15);
		
		JLabel lblMin_1 = new JLabel("Min *1.15");
		lblMin_1.setBounds(392, 407, 78, 14);
		contentPane.add(lblMin_1);
		
		textMaxKryt20 = new JTextField();
		textMaxKryt20.setText("0");
		textMaxKryt20.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxKryt20.setEditable(false);
		textMaxKryt20.setColumns(10);
		textMaxKryt20.setBounds(494, 463, 78, 20);
		contentPane.add(textMaxKryt20);
		
		JLabel lblMax_2 = new JLabel("Max *1.2");
		lblMax_2.setBounds(494, 448, 78, 14);
		contentPane.add(lblMax_2);
		
		textMinKryt20 = new JTextField();
		textMinKryt20.setText("0");
		textMinKryt20.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinKryt20.setEditable(false);
		textMinKryt20.setColumns(10);
		textMinKryt20.setBounds(494, 422, 78, 20);
		contentPane.add(textMinKryt20);
		
		JLabel lblMin_2 = new JLabel("Min *1.2");
		lblMin_2.setBounds(494, 407, 78, 14);
		contentPane.add(lblMin_2);
		
		textMaxKryt30 = new JTextField();
		textMaxKryt30.setText("0");
		textMaxKryt30.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxKryt30.setEditable(false);
		textMaxKryt30.setColumns(10);
		textMaxKryt30.setBounds(591, 463, 78, 20);
		contentPane.add(textMaxKryt30);
		
		JLabel lblMax_3 = new JLabel("Max *1.3");
		lblMax_3.setBounds(591, 448, 78, 14);
		contentPane.add(lblMax_3);
		
		textMinKryt30 = new JTextField();
		textMinKryt30.setText("0");
		textMinKryt30.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinKryt30.setEditable(false);
		textMinKryt30.setColumns(10);
		textMinKryt30.setBounds(591, 422, 78, 20);
		contentPane.add(textMinKryt30);
		
		JLabel lblMin_3 = new JLabel("Min *1.3");
		lblMin_3.setBounds(591, 407, 78, 14);
		contentPane.add(lblMin_3);
		
		textMaxKryt40 = new JTextField();
		textMaxKryt40.setText("0");
		textMaxKryt40.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxKryt40.setEditable(false);
		textMaxKryt40.setColumns(10);
		textMaxKryt40.setBounds(689, 463, 78, 20);
		contentPane.add(textMaxKryt40);
		
		JLabel lblMax_4 = new JLabel("Max *1.4");
		lblMax_4.setBounds(689, 448, 78, 14);
		contentPane.add(lblMax_4);
		
		textMinKryt40 = new JTextField();
		textMinKryt40.setText("0");
		textMinKryt40.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinKryt40.setEditable(false);
		textMinKryt40.setColumns(10);
		textMinKryt40.setBounds(689, 422, 78, 20);
		contentPane.add(textMinKryt40);
		
		JLabel lblMin_4 = new JLabel("Min *1.4");
		lblMin_4.setBounds(689, 407, 78, 14);
		contentPane.add(lblMin_4);
		
		textMaxKryt50 = new JTextField();
		textMaxKryt50.setText("0");
		textMaxKryt50.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxKryt50.setEditable(false);
		textMaxKryt50.setColumns(10);
		textMaxKryt50.setBounds(786, 463, 78, 20);
		contentPane.add(textMaxKryt50);
		
		JLabel lblMax_5 = new JLabel("Max *1.5");
		lblMax_5.setBounds(786, 448, 78, 14);
		contentPane.add(lblMax_5);
		
		textMinKryt50 = new JTextField();
		textMinKryt50.setText("0");
		textMinKryt50.setHorizontalAlignment(SwingConstants.RIGHT);
		textMinKryt50.setEditable(false);
		textMinKryt50.setColumns(10);
		textMinKryt50.setBounds(786, 422, 78, 20);
		contentPane.add(textMinKryt50);
		
		JLabel lblMin_5 = new JLabel("Min *1.5");
		lblMin_5.setBounds(786, 407, 78, 14);
		contentPane.add(lblMin_5);
		
		spinnerLiczbaSymulacji = new JSpinner();
		spinnerLiczbaSymulacji.setModel(new SpinnerNumberModel(1, 1, null, 1));
		spinnerLiczbaSymulacji.setName("");
		spinnerLiczbaSymulacji.setBounds(392, 26, 78, 20);
		contentPane.add(spinnerLiczbaSymulacji);
		
		JLabel lblLiczbaSymulacji = new JLabel("Liczba symulacji");
		lblLiczbaSymulacji.setBounds(392, 11, 78, 14);
		contentPane.add(lblLiczbaSymulacji);
		
		spinnerWalkiPodRzad = new JSpinner();
		spinnerWalkiPodRzad.setModel(new SpinnerNumberModel(1, 1, null, 1));
		spinnerWalkiPodRzad.setName("");
		spinnerWalkiPodRzad.setBounds(392, 63, 78, 20);
		contentPane.add(spinnerWalkiPodRzad);
		
		JLabel lblWalkiPodRzd = new JLabel("Walki pod rząd");
		lblWalkiPodRzd.setBounds(392, 48, 78, 14);
		contentPane.add(lblWalkiPodRzd);
		
		JLabel lblStaaUniku = new JLabel("Stała uniku");
		lblStaaUniku.setBounds(519, 367, 53, 14);
		contentPane.add(lblStaaUniku);


		textStalaUniku = new JTextField();
		textStalaUniku.setText("0");
		textStalaUniku.setHorizontalAlignment(SwingConstants.RIGHT);
		textStalaUniku.setEditable(false);
		textStalaUniku.setColumns(10);
		textStalaUniku.setBounds(494, 382, 78, 20);
		contentPane.add(textStalaUniku);
		
		JLabel lblSzansaNaTk = new JLabel("Szansa na TK");
		lblSzansaNaTk.setBounds(591, 367, 78, 14);
		contentPane.add(lblSzansaNaTk);
		
		textSzansaTk = new JTextField();
		textSzansaTk.setText("0");
		textSzansaTk.setHorizontalAlignment(SwingConstants.RIGHT);
		textSzansaTk.setEditable(false);
		textSzansaTk.setColumns(10);
		textSzansaTk.setBounds(591, 382, 78, 20);
		contentPane.add(textSzansaTk);
		
		textSrUb = new JTextField();
		textSrUb.setText("0");
		textSrUb.setHorizontalAlignment(SwingConstants.RIGHT);
		textSrUb.setEditable(false);
		textSrUb.setColumns(10);
		textSrUb.setBounds(706, 120, 78, 20);
		contentPane.add(textSrUb);
		
		JLabel lblredniaUb = new JLabel("Średnia UB");
		lblredniaUb.setBounds(706, 105, 78, 14);
		contentPane.add(lblredniaUb);
		
		textSrUnik = new JTextField();
		textSrUnik.setText("0");
		textSrUnik.setHorizontalAlignment(SwingConstants.RIGHT);
		textSrUnik.setEditable(false);
		textSrUnik.setColumns(10);
		textSrUnik.setBounds(706, 160, 78, 20);
		contentPane.add(textSrUnik);
		
		JLabel lblredniUnik = new JLabel("Średni unik");
		lblredniUnik.setBounds(705, 145, 79, 14);
		contentPane.add(lblredniUnik);
		
		textSrEnergia = new JTextField();
		textSrEnergia.setText("0");
		textSrEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
		textSrEnergia.setEditable(false);
		textSrEnergia.setColumns(10);
		textSrEnergia.setBounds(706, 201, 78, 20);
		contentPane.add(textSrEnergia);
		
		JLabel lblredniKosztPoziomu = new JLabel("Średni koszt poziomu");
		lblredniKosztPoziomu.setBounds(684, 186, 100, 14);
		contentPane.add(lblredniKosztPoziomu);
		
		JLabel lblTrafienie = new JLabel("Trafienie gracza");
		lblTrafienie.setBounds(23, 216, 78, 14);
		contentPane.add(lblTrafienie);
		
		textTrafienieGracza = new JTextField();
		textTrafienieGracza.setText("0");
		textTrafienieGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textTrafienieGracza.setEditable(false);
		textTrafienieGracza.setColumns(10);
		textTrafienieGracza.setBounds(23, 231, 78, 20);
		contentPane.add(textTrafienieGracza);
		
		JLabel lblZdolnoUnikuGracza = new JLabel("Zdolność uniku");
		lblZdolnoUnikuGracza.setBounds(111, 216, 78, 14);
		contentPane.add(lblZdolnoUnikuGracza);
		
		textZdolnoscUnikuGracza = new JTextField();
		textZdolnoscUnikuGracza.setText("0");
		textZdolnoscUnikuGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textZdolnoscUnikuGracza.setEditable(false);
		textZdolnoscUnikuGracza.setColumns(10);
		textZdolnoscUnikuGracza.setBounds(111, 231, 78, 20);
		contentPane.add(textZdolnoscUnikuGracza);
		
		textDmgGracza = new JTextField();
		textDmgGracza.setText("0");
		textDmgGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textDmgGracza.setEditable(false);
		textDmgGracza.setColumns(10);
		textDmgGracza.setBounds(199, 231, 78, 20);
		contentPane.add(textDmgGracza);
		
		JLabel lblDmgGracza = new JLabel("Dmg gracza");
		lblDmgGracza.setBounds(199, 216, 78, 14);
		contentPane.add(lblDmgGracza);
		
		JLabel lblObronaGracza = new JLabel("Obrona gracza");
		lblObronaGracza.setBounds(287, 216, 78, 14);
		contentPane.add(lblObronaGracza);
		
		textObronaGracza = new JTextField();
		textObronaGracza.setText("0");
		textObronaGracza.setHorizontalAlignment(SwingConstants.RIGHT);
		textObronaGracza.setEditable(false);
		textObronaGracza.setColumns(10);
		textObronaGracza.setBounds(287, 231, 78, 20);
		contentPane.add(textObronaGracza);
		
		textWygrane = new JTextField();
		textWygrane.setText("0");
		textWygrane.setHorizontalAlignment(SwingConstants.RIGHT);
		textWygrane.setEditable(false);
		textWygrane.setColumns(10);
		textWygrane.setBounds(799, 120, 78, 20);
		contentPane.add(textWygrane);
		
		JLabel lblwygranych = new JLabel("%Wygranych");
		lblwygranych.setBounds(799, 105, 78, 14);
		contentPane.add(lblwygranych);
		
		textRemisy = new JTextField();
		textRemisy.setText("0");
		textRemisy.setHorizontalAlignment(SwingConstants.RIGHT);
		textRemisy.setEditable(false);
		textRemisy.setColumns(10);
		textRemisy.setBounds(799, 160, 78, 20);
		contentPane.add(textRemisy);
		
		JLabel lblremisw = new JLabel("%Remisów");
		lblremisw.setBounds(809, 145, 68, 14);
		contentPane.add(lblremisw);
		
		textPrzegrane = new JTextField();
		textPrzegrane.setText("0");
		textPrzegrane.setHorizontalAlignment(SwingConstants.RIGHT);
		textPrzegrane.setEditable(false);
		textPrzegrane.setColumns(10);
		textPrzegrane.setBounds(799, 201, 78, 20);
		contentPane.add(textPrzegrane);
		
		JLabel lblprzegranych = new JLabel("%Przegranych");
		lblprzegranych.setBounds(799, 186, 78, 14);
		contentPane.add(lblprzegranych);
	}
	
	//tworzy zdarzenia
	private void createEvents() 
	{
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Fight fight = new Fight();
				fight.walka((Integer)spinnerLiczbaSymulacji.getValue(), (Integer)spinnerWalkiPodRzad.getValue(),
						p, m, textSrUb, textSrUnik, textSrEnergia, textWygrane, 
						textRemisy, textPrzegrane);
			}
		});

		spinnerLevelMoba.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				setMob();
				update();
				save();
			}
		});
		
		rdbtnElakka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setMob();
				update();
				save();
			}
		});
		
		rdbtnSith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setMob();
				update();
				save();
			}
		});

		spinnerLevel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				update();
				save();
			}
		});
		
		spinnerHp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
			
		});
		
		spinnerBron.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerSila.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerZrecznosc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerInteligencja.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerWytrzymalosc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerUnik.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				update();
				save();
			}
		});
		
		spinnerUb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerSzybkosc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerObronaZEq.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerSzybkoscBroni.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerUnikZEq.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				update();
				save();
			}
		});
		
		spinnerKaraDoUniku.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});
		
		spinnerZlodziejstwo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

			update();
			save();
		}
	});

		spinnerLiczbaSymulacji.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});

		spinnerWalkiPodRzad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				update();
				save();
			}
		});

	}

	private void setMob()
	{

		if(rdbtnElakka.isSelected()) m.setMiasto(true);
		if(rdbtnSith.isSelected()) m.setMiasto(false);

		m.load(m, (Integer)spinnerLevelMoba.getValue());

		textAtakMoba.setText(m.getDmg()+"");
		textObronaMoba.setText(m.getObrona()+"");
		textTrafienieUnikMoba.setText(m.getTrafienie()+"");
		textHpMoba.setText(m.getHp()+"");
		textSzybkoscMoba.setText(m.getSumaSzybkosci()+"");
	}

	private void save()
	{
		Save.zapisz(spinnerLevel, spinnerHp, spinnerBron, spinnerSila, spinnerZrecznosc, spinnerInteligencja,
				spinnerObronaZEq, spinnerWytrzymalosc, spinnerSilaWoli, spinnerSzybkosc, spinnerSzybkoscBroni,
				spinnerUb, spinnerUnik, spinnerKaraDoUniku, spinnerUnikZEq, spinnerWampiryzm,
				spinnerZlodziejstwo, spinnerLevelMoba,
				m.getMiasto(), spinnerLiczbaSymulacji, spinnerWalkiPodRzad);
	}

	private void update()
	{
		p.setLevel((Integer)spinnerLevel.getValue());
		p.setHp((Integer)spinnerHp.getValue());

		DerivativePlayer.przeliczDmg(p, spinnerBron, spinnerZrecznosc,
				textDmgGracza, textMinAtakGracza, textMaxAtakGracza);
		DerivativePlayer.przeliczObrone(p, spinnerWytrzymalosc, spinnerObronaZEq, textObronaGracza);
		DerivativePlayer.przeliczSumeSzybkosci(p, spinnerSzybkosc, spinnerSzybkoscBroni);
		DerivativePlayer.przeliczTrafienie(p, spinnerUb, spinnerSila, spinnerZrecznosc, spinnerInteligencja,
				spinnerWampiryzm, textTrafienieGracza);
		DerivativePlayer.przeliczZdolnoscUniku(p, spinnerUnik, spinnerSzybkosc, spinnerSzybkoscBroni, spinnerUnikZEq,
				spinnerKaraDoUniku, spinnerZlodziejstwo, textZdolnoscUnikuGracza);
		DerivativePlayer.przeliczStalaUniku(p, spinnerUnik, textStalaUniku);
		DerivativePlayer.przeliczSzanseTk(p, spinnerUb, textSzansaTk);
		DerivativePlayer.przeliczKryty(p, textMinKryt10, textMaxKryt10, textMinKryt15, textMaxKryt15,
				textMinKryt20, textMaxKryt20, textMinKryt30, textMaxKryt30,
				textMinKryt40, textMaxKryt40, textMinKryt50, textMaxKryt50);

		DerivativeMonster.przeliczDmg(m, textMinDmgMoba, textMaxDmgMoba);

		DerivativeCommon.szansaUniku(p, m, textSzansaUnikuGracza);
		DerivativeCommon.szansaTrafienia(p, m, textSzansaTrafieniaGracza);
	}

	private void load()
	{
		Load.wczytaj(spinnerLevel, spinnerHp, spinnerBron, spinnerSila, spinnerZrecznosc, spinnerInteligencja,
				spinnerObronaZEq, spinnerWytrzymalosc, spinnerSilaWoli, spinnerSzybkosc, spinnerSzybkoscBroni,
				spinnerUb, spinnerUnik, spinnerKaraDoUniku, spinnerUnikZEq, spinnerWampiryzm,
				spinnerZlodziejstwo, spinnerLevelMoba, rdbtnElakka, rdbtnSith, spinnerLiczbaSymulacji, spinnerWalkiPodRzad);
	}
}
