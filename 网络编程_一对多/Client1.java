package 网络编程_一对多;

/**
 * 客户端1
 */
import java.io.IOException;
import java.net.*;
public class Client1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",9876);
		new Thread(new ClientInputStream(socket));
		new Thread(new ClientOutputStream(socket));
	}

}
