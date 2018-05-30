import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteToFile {

	ObjectOutputStream output;

	public void openFile() {

		try {
			OutputStream out = Files.newOutputStream(Paths.get("file.ser"));
			output = new ObjectOutputStream(out);
			
			System.out.println("File is opened");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addRecords() {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {

			try {

				Account record = new Account(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());

				output.writeObject(record);

			} catch (NoSuchElementException e) {
				System.out.println("No such input, please try again.");
				sc.nextLine();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}

	}

	public void closeFile() {
		try {
			if (output != null)
				output.close();
			
			System.out.println("File is closed.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
