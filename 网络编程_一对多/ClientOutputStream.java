package 网络编程_一对多;

//客户端输入流线程
import java.io.*;
import java.net.*;
public class ClientOutputStream implements Runnable {
	private Socket socket = null;
	
	public ClientOutputStream(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
		while(true) {
				String line = br.readLine();
				pw.println(line); 
				if(line.equals("over")) {
					break;
				}
			}
				pw.close();
				br.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
