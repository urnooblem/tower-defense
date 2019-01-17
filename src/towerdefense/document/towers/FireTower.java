package towerdefense.document.towers;

import com.googlecode.lanterna.TextColor;

import towerdefense.document.Color;
import towerdefense.document.Tower;

public class FireTower extends Tower {

	public FireTower() {
		super(12, 100,7, 1.1);
		super.setName("Fire");
	}

	@Override
	public void setIcon() {
		super.setIcon("data/towers/FireTower.txt");
	}

}
