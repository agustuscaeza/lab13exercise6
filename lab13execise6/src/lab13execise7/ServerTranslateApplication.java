package lab13execise7;



import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ServerTranslateApplication {

	
	public static void main(String[] args) throws IOException {
		
		// Bind server socket to a port
		
		ServerSocket serverSocket = new ServerSocket(4228);

		// Launch the server frame
		ServerTranslateFrame serverFrame = new ServerTranslateFrame();
		serverFrame.setVisible(true);

		// Counter to keep track the number of requested connection
		int totalRequest = 0;

		// Server needs to be alive forever
	

			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);


			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();


			// Read stream data from the client
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String input = bufferReader.readLine();
			String targetLanguage =bufferReader.readLine();
			System.out.println("input = " + input);
			
			String translatedWord = Translate.translate(input,targetLanguage);
			
			// get the value for the total words using method wordsCount()
			int totalWords = wordsCount(input);
			

			// Create stream to write data on the network
			PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

			printWriter.println(translatedWord);
			printWriter.flush();
			System.out.println("translated word sent to client");
			

			// Close the socket
			clientSocket.close();
			
			printWriter.close();
			bufferReader.close();
			
			// Update the request status
			serverFrame.updateRequestStatus(
					"Translated Word in arabic for " + targetLanguage +" is " + translatedWord);
			serverFrame.updateRequestStatus(input);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
			

	
		
		
	}
	
	private static int wordsCount(String text) {
        // Custom word count implementation based on your requirements
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

}