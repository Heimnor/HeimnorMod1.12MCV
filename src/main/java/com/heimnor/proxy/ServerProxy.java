package com.heimnor.proxy;

import java.io.File;

public class ServerProxy extends CommonProxy {

	@Override
	public void preInit(File configFile) {

		super.preInit(configFile); //Ecrire en dessous du super
	}

	@Override
	public void init() {

		super.init();
	}
}
