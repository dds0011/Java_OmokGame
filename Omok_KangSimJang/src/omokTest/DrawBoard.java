package omokTest;
import java.awt.Color;

import java.awt.Graphics;



import javax.swing.JPanel;





//@SuppressWarnings("serial")

public class DrawBoard extends JPanel{

	private MapSize size;

	private Map map;

	private final int STONE_SIZE=20; //�� ������

	public DrawBoard(MapSize m,Map map) {

		// TODO Auto-generated constructor stub

		setBackground(new Color(206,167,61)); //���� ����

		size=m;

		setLayout(null);
		
		this.map=map;
		
		setVisible(true);
	    setSize(600,561);
		

	}

	@Override

	public void paintComponent(Graphics arg0) {

		// TODO Auto-generated method stub

		super.paintComponent(arg0);

		arg0.setColor(Color.BLACK); //�׷��� ���� ������

		board(arg0); //���带 �׸�

		drawStone(arg0); //�迭�� ������ ���� ���� �׸�

	}

	public void board(Graphics arg0) {

		for(int i=1;i<=size.getSIZE();i++){

			//���� �� �׸���

			arg0.drawLine(size.getCELL(), i*size.getCELL(), size.getCELL()*size.getSIZE(), i*size.getCELL()); //������ x : 30, ������ y : i�� (�ٹ�ȣ)*30, ���� x : 600,���� y : i�� (�ٹ�ȣ)*30

			//������ �׸���

			arg0.drawLine(i*size.getCELL(), size.getCELL(), i*size.getCELL() , size.getCELL()*size.getSIZE()); //������ x : i�� (�ٹ�ȣ)*30, ������ y : 30, ���� x : i�� (�ٹ�ȣ)*30, ���� y : 600

		}

	}

	public void drawStone(Graphics arg0) {

		for(int y=0;y<size.getSIZE();y++){

			for(int x=0;x<size.getSIZE();x++){

				//�迭�� ������ ���ϰ�� �浹, ���ϰ�� �鵹�� �׸�

				if(map.getXY(y, x)==map.getBlack())

					drawBlack(arg0,x,y);
				

				else if(map.getXY(y, x)==map.getWhite())
                 
					drawWhite(arg0, x, y);
				

			}

		}

	}

	

	public void drawBlack(Graphics arg0,int x,int y){

		//�׷��� ���� ������ �ٲ�

		arg0.setColor(Color.BLACK);

		arg0.fillOval((x+1)*size.getCELL()-10, (y)*size.getCELL()+15, STONE_SIZE, STONE_SIZE);



	}

	public void drawWhite(Graphics arg0,int x,int y){

		//�׷��� ���� ȭ��Ʈ�� �ٲ�

		arg0.setColor(Color.WHITE);

		arg0.fillOval(x*size.getCELL()+16, y*size.getCELL()+15, STONE_SIZE, STONE_SIZE);

		

	}

}