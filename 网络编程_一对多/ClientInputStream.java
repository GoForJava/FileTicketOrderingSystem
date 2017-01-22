package 网络编程_一对多;

//输入流线程
import java.net.*;
import java.io.*;
public class ClientInputStream implements Runnable {
	private Socket socket = null;
	
	public ClientInputStream(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String line = br.readLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
