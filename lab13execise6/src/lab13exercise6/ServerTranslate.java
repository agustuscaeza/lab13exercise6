package lab13exercise6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslate {

	public static void main(String[] args) throws IOException {
		
		// Binding serversocket to a port
		
		ServerSocket serverSocket = new ServerSocket(4234);
		System.out.println("Waiting a request from client side to bind with the server port");
		System.out.print("\n");
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			

			// Read stream data from the client
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String input = bufferReader.readLine();
			String LTT = bufferReader.readLine();
			int translateTo= Integer.parseInt(LTT);
			String toTranslate="";
			if(translateTo==1)
			{
				toTranslate="Bahasa Malaysia, " + "Arabic, " + "Korean";	
			}
			System.out.println("input = " + input);
			
			// get the value for the total words using method Translator
		    String TranslateWords = Translate.Translator(translateTo);
			// Create stream to write data on the network
			PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

			printWriter.println(TranslateWords);
			printWriter.flush();
			System.out.println("Translated word sent to client");
			System.out.print("\n"+input+" in "+toTranslate +" is "+"( "+TranslateWords+" )");
			

			// Close the socket
			clientSocket.close();
			
			printWriter.close();
			bufferReader.close();
			
		
		
	}

}