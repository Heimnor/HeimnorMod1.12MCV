package com.heimnor.henum;

import com.heimnor.common.Heimnor;

public enum EnumArmorHeimnor
{

	ADAMANTE("armureAdamante_1.png", "armureAdamante_2.png"),
	ORONNELEG("oronne1_1.png", "oronne1_2.png"),
	DUNES("armureShaal_1Layer_1.png", ""),
	SABLES("", "shaalJambieresLayer_2.png"),
	LAMELLAIRE("Lamellaire1.png", "Lamellaire2.png"),
	STEPPES("armureDjarnedinLayer_1.png", ""),
	CUIRBOUILLI("Bouilli1.png", "cuirBouilliLayer_2.png"),
	IMPROVISEE("armureImproviseeLayer_1.png", "armureImproviseeLayer_2.png"),
	MERCENAIRE("armureMercenaireLayer_1.png", "armureMercenaireLayer_2.png"),
	HAJI("Haji1.png", "Haji2.png"),
	TOUNDRA("armureToundraLayer_1.png", "armureToundraLayer_2.png"),
	GUERIN("Guerinne1.png", "Guerinne2.png"),
	PLAQUES("Plaques1.png", "Plaques2.png"),
	CLERICALE("Clericale1.png", "Clericale2.png"),
	SERGENT("Sergent1.png", "Sergent2.png"),
	CLOUTE("Cloute1.png", "Cloute2.png"),
	HUSCARL("Huscarl1.png", "Huscarl2.png"),
	MAILLE("Maille1.png", "Maille2.png"),
	MARAUDEUR("Maraudeur1.png", "Maraudeur2.png");

	private String layer1 = "";
	private String layer2 = "";

	EnumArmorHeimnor(String layer1, String layer2)
	{
		if (!layer1.equals(""))
			this.layer1 = Heimnor.MODID + ":textures/models/armor/" + layer1;
		if (!layer2.equals(""))
			this.layer2 = Heimnor.MODID + ":textures/models/armor/" + layer2;
	}

	public String getLayer1()
	{
		return this.layer1;
	}

	public String getLayer2()
	{
		return this.layer2;
	}
}
