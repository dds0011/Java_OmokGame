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
			
			System.out.println("사용할 ID를 입력해주십시오 : ");
			ChatClient.UserID = tmpbuf.readLine();
			
			sendWriter.println(ChatClient.UserID);
			sendWriter.flush();//버퍼에 데이터가 쌓이면 다출력 (엔터)
			
			while(true)
			{
				sendString = tmpbuf.readLine(); 

				if(sendString.equals("exit")) //exit를 치면 서버를 나감
				{
					break;
				}
				
				sendWriter.println(sendString);
				sendWriter.flush(); //버퍼에 데이터가 쌓이면 다출력(엔터)
			}
			
			sendWriter.close(); //닫아줌
			tmpbuf.close();//닫아줌
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
