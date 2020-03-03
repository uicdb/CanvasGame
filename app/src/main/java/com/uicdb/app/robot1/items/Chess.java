package com.uicdb.app.robot1.items;

import android.graphics.*;

public class Chess implements Cloneable
{
	public Vector2 position;
	public TYPE type;
	public Bitmap thisMap;
	private boolean exist=true;
	onExistChangeListener listener;
	public Chess(Vector2 position, TYPE type, Bitmap thisMap)
	{
		this.position = position;
		this.type = type;
		this.thisMap = thisMap;
	}
	public Chess(Vector2 position, TYPE type, Bitmap thisMap,onExistChangeListener listener)
	{
		this.position = position;
		this.type = type;
		this.thisMap = thisMap;
		this.listener=listener;
	}

	public void setListener(onExistChangeListener listener)
	{
		this.listener = listener;
	}
	public void setExist(boolean exist)
	{
		this.exist = exist;
		if(listener!=null)listener.onChange(exist,this);
	}
	public boolean isExist()
	{
		return exist;
	}

	@Override
	protected Object clone() 
	{
		return new Chess(position,type,thisMap);
	}
	
	public abstract interface onExistChangeListener{
		public void onChange(boolean isExist,Chess chess);
	}
	public enum TYPE{
		车,马,象,士,将,卒,
		炮,
		車,馬,相,仕,帥,兵
		}
}

	
