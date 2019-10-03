package com.heimnor.capabilities;

public class CharacterRP implements ICharacterRP
{

	private String name = "";
	
	@Override
	public String getRoleplayName()
	{
		return this.name;
	}

	@Override
	public void setRoleplayName(String name)
	{

		this.name = name;
		
	}

}
