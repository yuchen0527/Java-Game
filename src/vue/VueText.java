package vue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Mvc.Observer;
import Mvc.View;

/**
 * This class is part of the visualization
 */

public class VueText implements Observer, Runnable {
    public static String QUITTER = "Quit";
    public static String COMMUTER = "C";
    public static String PROMPT = ">";
    public Scanner br;
    public Thread t;
    private View v;
    
    public VueText(View v)  {     
    	this.v=v;
    	this.br=new Scanner(System.in);
    	t = new Thread(this);
    	
    }
    public void run() {
    	int saisie;
    	saisie = this.lireChaine();
    	this.v.setWhich(saisie);
    	}
    
    
    private int lireChaine() {
    	
    	int resultat;
    	System.out.print(VueText.PROMPT);
		resultat = br.nextInt();
		v.setChange();
    	return resultat;   
    	}
    
    
   	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}
   
  }