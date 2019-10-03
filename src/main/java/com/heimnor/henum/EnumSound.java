package com.heimnor.henum;

import com.heimnor.common.Heimnor;

public enum EnumSound {

	CUTTINGVEG("cuttingVegie_sound"),
	CLOCHETTE("clochette_sound");
	
	private String soundName = "";
	
	EnumSound(String soundName){
		this.soundName = Heimnor.MODID +":"+ soundName;
		this.soundName.toString();
	}
	
	public String toString() {
		return this.soundName;
		
	}
}
