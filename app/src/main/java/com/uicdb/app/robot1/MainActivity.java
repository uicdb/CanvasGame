package com.uicdb.app.robot1;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.*;
import java.util.*;
import com.uicdb.app.robot1.game.*;

public class MainActivity extends Activity 
{
	ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		img=new ImageView(this);
		init();
		setContentView(img);
	}
	private void init(){
		ChessGame game=new ChessGame(1215434652554l);
		img.setImageBitmap(game.updataMap());
	}
	
}
