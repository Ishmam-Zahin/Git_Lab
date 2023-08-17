import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	static String line;
	static String[] names;
	static String newStudentName;

	public static void readFile(){
		try{
			BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			line = fileIn.readLine();
			names = line.split(", ");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void writeFile(){
		try{
			BufferedWriter fileOut = new BufferedWriter(new FileWriter("students.txt", false));
			fileOut.write(line+", "+newStudentName);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

//		Check arguments
		if(args.length!=1){
			//terminate
			System.out.println("Invalid Arguments!");
			return;
		}
		else{
			readFile();

			if(args[0].equals("a")) {
				System.out.println("Loading data ...");

					for(String name : names) { System.out.println(name); }

				System.out.println("Data Loaded.");
			}
			else if(args[0].equals("r"))
			{
				System.out.println("Loading data ...");

					Random random = new Random();
					int randomNum = random.nextInt(names.length);
					System.out.println(names[randomNum]);

				System.out.println("Data Loaded.");
			}
			else if(args[0].contains("+")){
				System.out.println("Loading data ...");

					String t = args[0].substring(1);
					Date d = new Date();
					String df = "dd/mm/yyyy-hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(df);
					String fd= dateFormat.format(d);

				System.out.println("Data Loaded.");
			}
			else if(args[0].contains("?"))
			{
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String r = s.readLine();
					String i[] = r.split(",");
					boolean done = false;
					String t = args[0].substring(1);
					for(int idx = 0; idx<i.length && !done; idx++) {
						if(i[idx].equals(t)) {
							System.out.println("We found it!");
							done=true;
						}
					}
				} catch (Exception e){}
				System.out.println("Data Loaded.");
			}
			else if(args[0].contains("c"))
			{
				System.out.println("Loading data ...");
				try {
					BufferedReader s = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt")));
					String D = s.readLine();
					char a[] = D.toCharArray();
					boolean in_word = false;
					int count=0;
					for(char c:a) {
						if(c ==' ')
						{
							if (!in_word) {	count++; in_word =true;	}
							else { in_word=false;}
						}
					}
					System.out.println(count +" word(s) found " + a.length);
				} catch (Exception e){}
				System.out.println("Data Loaded.");
			}
		}
	}
}