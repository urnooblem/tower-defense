package towerdefense.document.towers;

import com.googlecode.lanterna.TextColor;

import towerdefense.document.Tower;

public class ElectricityTower extends Tower {

	public ElectricityTower() {
		super("CANNON", TextColor.ANSI.YELLOW, 7, 12);
	}

	@Override
	public void setIcon() {
		super.setIcon("assets/towerdefense.document.towers/ElectricityTower.txt");
	}

}