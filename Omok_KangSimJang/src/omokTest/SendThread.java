package omokTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread{

	private Socket m_Socket;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			
			String sendString;
			
			System.out.println("����� ID�� �Է����ֽʽÿ� : ");
			ChatClient.UserID = tmpbuf.readLine();
			
			sendWriter.println(ChatClient.UserID);
			sendWriter.flush();//���ۿ� �����Ͱ� ���̸� ����� (����)
			
			while(true)
			{
				sendString = tmpbuf.readLine(); 

				if(sendString.equals("exit")) //exit�� ġ�� ������ ����
				{
					break;
				}
				
				sendWriter.println(sendString);
				sendWriter.flush(); //���ۿ� �����Ͱ� ���̸� �����(����)
			}
			
			sendWriter.close(); //�ݾ���
			tmpbuf.close();//�ݾ���
			m_Socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}	
}
