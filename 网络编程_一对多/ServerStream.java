package 网络编程_一对多;

import java.net.*;
import java.io.*;

/**
 * 服务器端线程类
 * @author SkyEgine
 *
 */
public class ServerStream implements Runnable {
	private Socket socket;
	private int number;
	
	public ServerStream(Socket socket, int number) {
		super();
		this.socket = socket;
		this.number = number;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//读取客户端传过来的数据
			//将客户端接收的数据以某种格式传回客户端
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true); //设置自动刷新缓存区
			while(true) {
				String line = br.readLine();
				System.out.println("客户端"+number+" sends: ");
				pw.println(line.toUpperCase());
				if(line.equals("over")) {
					System.out.println("客户端"+number+"已经断开连接");
					break;
				}
			}
			pw.close();
			br.close();
			socket.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
