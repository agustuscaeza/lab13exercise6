package lab13exercise6;



import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientTranslate {

	public static void main(String[] args) {
		
		String text = "What's up?";
		System.out.println("\n Text to convert : "+text);
		
		System.out.println("convert to language : Bahasa Malaysia, Arabic, Korean ");
		System.out.print("\nEnter the number 1 to translate the text : ");
		
		//Reading user input
		Scanner scanner = new Scanner(System.in);
		
		// Read from user input
		int translateTo = scanner.nextInt();
		
		
		try {
			
		// Connect to the server at localhost port 2345
		Socket socket = new Socket(InetAddress.getLocalHost(), 4234);

		// Update the status of the connection
		System.out.println(socket.isConnected());

		// Write text for server
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
		
		// Sending text
		printWriter.println(text);
		printWriter.println(translateTo);
		System.out.println("text send to server");
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
	
		// Close
		bufferedReader.close();
		socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}