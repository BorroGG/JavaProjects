package mainpack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Panel extends JPanel {
	
	private int val = 0;
	
	public Panel() {
		setLayout(null);
		Timer tm = new Timer(150, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				val++;
				if (val == 256) val = 0;
				repaint();
			}
			
		});
		tm.start();
	}
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		for(int i = 0; i < 256; i++){
			gr.setColor(new Color(0,(i*val)%255,0));
			gr.drawRect(250-i/2, 220-i/2, i, i);
		}
	}

}
