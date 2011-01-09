package de.martin_ueding.mathematik.mkvm;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Mehrfach-Verkleinerungs-Kopier-Maschine kopiert ihr Bild mehrmals verkleinert in sich selbst
 * hinein. Dabei wird das Bild immer genauer und ist selbstähnlich.
 *
 * In der aktuellen Konfiguration ensteht das Sierpinski-Dreieck.
 *
 * Copyright: Martin Ueding
 */

public class Mvkm {
	
	public static void main(String[] args) {
		
		int stufe;
		int lastStufe = 9;
		int neuBreite;
		
		double[] punkteX = {0,0.5,0};
		double[] punkteY = {0,0.25,0.5};
		
		int fak = (int)(1/ 0.5);
		
		int i, j;
		
		int runde;
		
		boolean[][] aktuell, neu;
		
		aktuell = new boolean[1][1];
		aktuell[0][0] = true;
		
		for (stufe = 0; stufe < lastStufe; stufe++) {	// Solange wir noch tiefer sollen:
			System.out.println("Stufe " + (stufe +1));
			
			neuBreite = (int) Math.pow(2, stufe) * fak;	// Neue Größe ist hier doppelt so groß
			
			neu = new boolean[neuBreite][neuBreite];	// Ein neues Feld
			
			for (runde = 0; runde < 3; runde++) {
				for (i = 0; i < aktuell.length; i++) {
					for (j = 0; j < aktuell[0].length; j++) {
						/* Kopiere das alte Bild in das neue hinein, dabei wird es verkleinert */
						neu[(int) (i+punkteX[runde]*neuBreite)][(int) (j+punkteY[runde]*neuBreite)] = aktuell[i][j]; 
					}
				}
			}
			aktuell = neu;	
		}
		
		/* Erzeuge ein Fenster und gebe das Fraktal aus */
		JPanel feld = new FrakPanel(aktuell);
		JFrame f = new JFrame("MVKM");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(aktuell[0].length+30, aktuell.length+50);
		f.setLocation(0,0);
		f.getContentPane().add(feld);
		f.setVisible(true);
	}
}
