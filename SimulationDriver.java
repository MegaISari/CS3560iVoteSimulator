import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class SimulationDriver {
	
	//generating the random answers
	private static Hashtable<Integer, String> random (ArrayList<Student> studentList, int studentNum, Question qs, int ansNum){
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		
		for (int i = 0; i < studentNum; i++) {
			if (qs.getAns().length() == 1){
				studentList.get(i).singleAnsRan(ansNum);
			} else {
				studentList.get(i).multipleAnsRan(ansNum);
			}
		}
		for (int i = 0; i < studentNum; i++) {
			hash.put(studentList.get(i).getId(), studentList.get(i).ans);
		}
		return hash;
	}

	public static void main(String[] args) {
		
		ArrayList<Student> studentList = new ArrayList<Student>();

		Random rand = new Random();
		//randomly generating how many student at most 
		final int totalStudents = rand.nextInt(10);
		
		int count = 0;

		System.out.println("Number of students submitted their answer: " + totalStudents + "\n");
		
		//randomly generating unique ID for students
		for (int i = 0; i < totalStudents; i++) {
			studentList.add(new Student((int) ((Math.random() * 1000))));
		}
		
		int[] studentID = new int[studentList.size()];
		
		for (int i = 0; i < totalStudents; i++) {
			studentID[i] = studentList.get(i).getId();
		}

		//at most 11 
		Voting iVoteSimulator = new Voting(studentID);
		int ranNum = (int) ((Math.random() * 10) + 1);

		//Display the question and answer, which more than one choice can be chosen including one choice
		Question multipleAnsQs = new Question("*********Choose ONE or MORE answers you think is correct*********\nWhat pet(s) is/are the best ?\n A: Dogs \n B: Cats \n C: Birds \n D: Nothing\n", "");
		System.out.println(multipleAnsQs.getQs());
		for (int i = 0; i < totalStudents; i++) {
			while (true){
				if (ranNum != 0){
					iVoteSimulator.chosenAnswer(random(studentList, totalStudents, multipleAnsQs, 4));
					ranNum--;
					count++;
				} else {
					iVoteSimulator.totalNumSubmitted(count);
					iVoteSimulator.submittedAnsShowed(studentID[i]);
					break;
				}
			}
			count = 0;
			ranNum = (int) ((Math.random() * 10) + 1);
		}		
		iVoteSimulator.totalAns(4);

		//Display the question and answer, which can only submit one answer
		Question singleAnsQs = new Question("*********Choose ONLY one correct answer*********\nWhat is the capital city of Indonesia?\n A: Sydney \n B: Jakarta \n C: Bogor\n", "B");
		System.out.println(singleAnsQs.getQs());
		
		for (int i = 0; i < totalStudents; i++) {
			while (true){
				if (ranNum != 0 ){
					iVoteSimulator.chosenAnswer(random(studentList, totalStudents, singleAnsQs, 3));
					ranNum--;
					count++;
				} else {
					iVoteSimulator.totalNumSubmitted(count);
					iVoteSimulator.submittedAnsShowed(studentID[i]);
					break;
				}
			}
			count = 0;
			ranNum = (int) ((Math.random() * 10) + 1);
		}		
        System.out.println("\n");
		iVoteSimulator.correctAnsShowed(singleAnsQs, totalStudents);
		iVoteSimulator.totalAns(3);
	}
	
}