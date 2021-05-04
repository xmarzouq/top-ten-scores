import java.util.LinkedList;
import java.util.Scanner;
public class Test {
	
	private LinkedList<String> scores;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SinglyLinkedList<GameEntry> boardList = new SinglyLinkedList<>();
		Scoreboard sb = new Scoreboard(boardList);
		while(true) {
			System.out.print("Enter the name (Enter \"end\" to exit):  ");
			String name = input.nextLine();
			if("end".equals(name) || "End".equals(name))
				break;
			System.out.print("Enter the score: ");
			String score   = input.nextLine();
			sb.add(new GameEntry(name, Integer.parseInt(score)));
		}
		System.out.println("\t\t->Task list<-");
		System.out.println("1. Display the highest 10 scores\n"
				+ "2. Remove a specific score.\n"
				+ "3. Exit\n");
		System.out.println("\n Enter your choice -->");
		int choice = input.nextInt();
		do {
			switch(choice) {
			case 1: {
				boardList.reverseDisplay(boardList.getHead());
				System.exit(0);
				break;
			} case 2: {
				System.out.print("Enter the position to be deleted-->");
				boardList.remove(input.nextInt());
				boardList.reverseDisplay(boardList.getHead());
				System.exit(0);
				break;
			}
			default: 
				System.exit(0);
			}
		} while(choice !=3);
	}
}