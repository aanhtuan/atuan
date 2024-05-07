package XML;
	import java.io.File; 
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;

	public class BtXML {
		public static void listDirectory(File dir, FileWriter output) throws IOException { output.write("<" + dir.getName() + ">\n"); for (File file : dir.listFiles()) { if (file.isDirectory()) { listDirectory(file, output); } else { output.write("<file>" + file.getName() + "</file>\n"); } } output.write("</" + dir.getName() + ">\n"); }

	public static void main(String[] args) {
	    try {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter directory path: ");
	        String path = scanner.nextLine();
	        File dir = new File(path);

	        if (dir.exists() && dir.isDirectory()) {
	            FileWriter outputFile = new FileWriter("output.xml");
	            listDirectory(dir, outputFile);
	            outputFile.close();
	            System.out.println("XML file generated successfully.");
	        } else {
	            System.out.println("Invalid directory path.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	}



