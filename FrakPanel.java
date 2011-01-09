package de.martin_ueding.mathematik.mkvm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Dieses Panel zeigt das von MVKM übergebene Bild an. Dabei handelt es sich um ein Array
 * von Booleans, das S/W ausgegeben wird.
 *
 * Copyright: Martin Ueding
 */

public class FrakPanel extends JPanel {
	
	private static final long serialVersionUID = 3921900643589938363L;
	
	private boolean[][] frak;	// Hier wird das Bild gespeichert
	
	public FrakPanel (boolean[][] a) {
		frak = a;
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor (new Color(0,0,0));
		g.fillRect(0, 0, getWidth(), getHeight());

		int i, j;
		
		for (i = frak.length-1; i >= 0 ; i--) {
			for (j = 0; j < frak[0].length; j++) {
				/* Setze die Farbe, je nach Wert im Bild */
				if (frak[i][j])
					g.setColor(new Color(255,255,255));
				else
					g.setColor(new Color(0,0,0));
					
				g.drawLine(j, frak.length-i-1, j, frak.length-i-1);	// Setze ein Pixel
			}
		}	
	}
}

