package com.uicdb.app.robot1.game;
import android.graphics.*;
import com.uicdb.app.robot1.items.*;
import java.util.*;
import android.renderscript.*;

public class ChessGame
{
	public static Chess.TYPE TYPE;
	public static final int offest=100;
	long groupid=0;
	ArrayList<Chess> blackTeam=new ArrayList<>();
	ArrayList<Chess> whiteTeam=new ArrayList<>();
	boolean isFirstRun=true;
	List<Chess> chesses=new ArrayList<Chess>();
	Chess 车1,车2,马1,马2,象1,象2,士1,士2,将,卒1,卒2,卒3,卒4,卒5;
	Chess 炮黑1,炮黑2,炮红1,炮红2;
	Chess 車1,車2,馬1,馬2,相1,相2,仕1,仕2,帥,兵1,兵2,兵3,兵4,兵5;
	public static  Paint line_paint=new Paint();
	static{
			line_paint.setColor(Color.BLACK);
			line_paint.setTypeface(Typeface.DEFAULT_BOLD);
			line_paint.setStrokeWidth(2);
			line_paint.setTextSize(60);
	}
	public ChessGame(long groupid){
		if(isFirstRun){
			isFirstRun=false;
		}
		this.groupid=groupid;
		chesses.add(车1=createBlackChess(0,0,TYPE.车,1));
		chesses.add(车2=createBlackChess(800,0,TYPE.车,2));
		chesses.add(马1=createBlackChess(100,0,TYPE.马,1));
		chesses.add(马2=createBlackChess(700,0,TYPE.马,2));
		chesses.add(象1=createBlackChess(200,0,TYPE.象,1));
		chesses.add(象2=createBlackChess(600,0,TYPE.象,2));
		chesses.add(士1=createBlackChess(300,0,TYPE.士,1));
		chesses.add(士2=createBlackChess(500,0,TYPE.士,2));
		chesses.add(将=createBlackChess(400,0,TYPE.将));
		chesses.add(炮黑1=createBlackChess(100,200,TYPE.炮,1));
		chesses.add(炮黑2=createBlackChess(700,200,TYPE.炮,2));
		chesses.add(卒1=createBlackChess(0,300,TYPE.卒,1));
		chesses.add(卒2=createBlackChess(200,300,TYPE.卒,2));
		chesses.add(卒3=createBlackChess(400,300,TYPE.卒,3));
		chesses.add(卒4=createBlackChess(600,300,TYPE.卒,4));
		chesses.add(卒5=createBlackChess(800,300,TYPE.卒,5));
		chesses.add(兵1=createRedChess(0,600,TYPE.兵,1));
		chesses.add(兵2=createRedChess(200,600,TYPE.兵,2));
		chesses.add(兵3=createRedChess(400,600,TYPE.兵,3));
		chesses.add(兵4=createRedChess(600,600,TYPE.兵,4));
		chesses.add(兵5=createRedChess(800,600,TYPE.兵,5));
		chesses.add(炮红1=createRedChess(100,700,TYPE.炮,1));
		chesses.add(炮红1=createRedChess(700,700,TYPE.炮,2));
		chesses.add(車1=createRedChess(0,900,TYPE.車,1));
		chesses.add(車2=createRedChess(800,900,TYPE.車,2));
		chesses.add(馬1=createRedChess(100,900,TYPE.馬,1));
		chesses.add(馬2=createRedChess(700,900,TYPE.馬,2));
		chesses.add(相1=createRedChess(200,900,TYPE.相,1));
		chesses.add(相2=createRedChess(600,900,TYPE.相,2));
		chesses.add(仕1=createRedChess(300,900,TYPE.仕,1));
		chesses.add(仕2=createRedChess(500,900,TYPE.仕,2));
		chesses.add(帥=createRedChess(400,900,TYPE.帥));
	}
	public Bitmap updataMap(){
		Bitmap map=createTempMap();
		Canvas canvas=new Canvas(map);
		for(Chess chess:chesses){
			drawChessItem(canvas,line_paint,chess);
		}
		canvas.save(Canvas.ALL_SAVE_FLAG);
		return map;
	}
	public static  Bitmap createTempMap(){
		Bitmap map=Bitmap.createBitmap(800+2*offest,900+2*offest,Bitmap.Config.ARGB_8888,true);
		Canvas canvas=new Canvas(map);
		canvas.drawColor(Color.YELLOW-Color.red(80)-Color.blue(80));
		for(int i=0;i<1000;i+=100){
			canvas.drawLine(0+offest,i+offest,800+offest,i+offest,line_paint);
		}
		for(int i=0;i<900;i+=100){
			canvas.drawLine(i+offest,0+offest,i+offest,400+offest,line_paint);
			canvas.drawLine(i+offest,500+offest,i+offest,900+offest,line_paint);
		}
		canvas.drawLine(0+offest,0+offest,0+offest,0+offest+900,line_paint);
		canvas.drawLine(0+offest+800,0+offest,0+offest+800,0+offest+900,line_paint);
		canvas.drawLine(300+offest,0+offest,500+offest,200+offest,line_paint);
		canvas.drawLine(300+offest,200+offest,500+offest,0+offest,line_paint);
		canvas.drawLine(300+offest,700+offest,500+offest,900+offest,line_paint);
		canvas.drawLine(300+offest,900+offest,500+offest,700+offest,line_paint);
		canvas.drawText("楚河                          汉界",85+offest,475+offest,line_paint);
		//测试
		//drawChessItem(canvas,line_paint,createWhiteChess(0,0,Chess.TYPE.兵));
		canvas.save(Canvas.ALL_SAVE_FLAG);
		return map;
	}
	private static Chess createBlackChess(int x,int y,Chess.TYPE type,int index){
		return new Chess(new Vector2(x,y),type,createChessItem(true,type.name(),index));
	}
	private static Chess createBlackChess(int x,int y,Chess.TYPE type){
		return new Chess(new Vector2(x,y),type,createChessItem(true,type.name()));
	}
	private static Chess createRedChess(int x,int y,Chess.TYPE type,int index){
		return new Chess(new Vector2(x,y),type,createChessItem(false,type.name(),index));
	}
	private static Chess createRedChess(int x,int y,Chess.TYPE type){
		return new Chess(new Vector2(x,y),type,createChessItem(false,type.name()));
	}
	private static void drawChessItem(Canvas canvas,Paint paint,Chess chess){
		canvas.drawBitmap(chess.thisMap,chess.position.x-50+offest,chess.position.y-50+offest,paint);
	}
	private static Bitmap createChessItem(boolean isBlack,String text,int index){
		Bitmap bitmap=Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888,true);
		Canvas canvas=new Canvas(bitmap);
		Paint circle_paint=new Paint();
		circle_paint.setColor(isBlack?Color.BLACK:Color.RED);
		canvas.drawCircle(50,50,45,circle_paint);
		circle_paint.setColor(isBlack?Color.WHITE:Color.CYAN);
		circle_paint.setTextSize(50);
		canvas.drawText(text,25,70,circle_paint);
		circle_paint.setTextSize(35);
		canvas.drawText(""+index,60,25,circle_paint);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		return bitmap;
	}
	private static Bitmap createChessItem(boolean isBlack,String text){
		Bitmap bitmap=Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888,true);
		Canvas canvas=new Canvas(bitmap);
		Paint circle_paint=new Paint();
		circle_paint.setColor(isBlack?Color.BLACK:Color.RED);
		canvas.drawCircle(50,50,45,circle_paint);
		circle_paint.setColor(isBlack?Color.WHITE:Color.CYAN);
		circle_paint.setTextSize(50);
		canvas.drawText(text,25,70,circle_paint);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		return bitmap;
	}
	
	private static Random ran=new Random();
	private static  int randomInt(int min,int max){
		return ran.nextInt(max)+min;
	}
}
