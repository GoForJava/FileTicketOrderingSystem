package 网络编程_一对多;

import java.io.*;
import java.net.*;
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9876); //创建一个服务器端的ServerSocket对象
		int number = 1; //保存客户端的数量
		
		while(true) {
			Socket socket = server.accept(); //调用accept方法返回的是一个Socket对象
			System.out.println("客户端"+number+"已经连接。。。");
			//读取客户端，并且为每一个客户端设置一个单独的进程
			new Thread(new ServerStream(socket,number)).start();
			number++;
			
		}
		
		
	}

}
