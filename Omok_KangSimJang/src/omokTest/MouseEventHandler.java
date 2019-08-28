package omokTest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter{

	private Map map;
	private MapSize ms;
	private DrawBoard d;
	private MainForm main;
	
	public MouseEventHandler(Map m, MapSize ms, DrawBoard d, MainForm main) {
		map = m;
		this.ms=ms;
		this.d=d;
		this.main=main;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		int x = (int)Math.round(e.getX()/(double)ms.getCELL())-1;
		int y = (int)Math.round(e.getY()/(double)ms.getCELL())-1;
		if(x<0||x>19||y<0||y>19) {
			return;
		}
		if(map.getXY(y, x)==map.getBlack()||map.getXY(y, x)==map.getWhite()) {
			return;
		}
		System.out.println(x+" "+y);
		map.setMap(y,x);
		
		map.changeCheck();
		
		d.repaint();
		if(map.winCheck(x, y)) {
			if(map.getCheck()==true) {
				
				main.showPopUp("백돌이 승리하였습니다.");
			}
			else {
				main.showPopUp("흑돌이 승리하였습니다.");
			}
		}
	 
	  
	}
	
	
	

	

}