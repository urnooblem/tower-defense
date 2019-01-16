package towerdefense.document.towers;

import com.googlecode.lanterna.TextColor;

import towerdefense.document.Color;
import towerdefense.document.Tower;

public class ForceTower extends Tower {

	public ForceTower() {
		super(12, 100,7, 1.1, Color.WHITE);
	}

	@Override
	public void setIcon() {
		super.setIcon("assets/towerdefense.document.towers/ForceTower.txt");
	}
}
