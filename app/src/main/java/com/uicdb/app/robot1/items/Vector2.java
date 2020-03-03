package com.uicdb.app.robot1.items;

public class Vector2{
	public int x,y;
	public Vector2(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Vector2(){
		this(0,0);
	}
	public void setX(int x)
	{

		this.x = x;                 
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()	
	{
		return y;
	}
	public void setPosition(int x,int y){
		this.x = x;

		this.y = y;
	}
}
