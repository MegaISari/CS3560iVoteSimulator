import java.util.Hashtable;

public class Voting implements VotingService {

	Hashtable<Integer, String> table = new Hashtable<Integer, String>();

    private int totalSubmission = 0;

    //Unique ID for students 
	private int[] IDs;

	public Voting(int[] IDs) {
		this.IDs = IDs;
	}

    //the students' submitted answer 
	public void chosenAnswer(Hashtable<Integer, String> studentAnswers) {
		this.table = studentAnswers;
	}

    //showing the question 
	public void qsShowed(Question question) {
		System.out.println(question.getQs());
	}

    //showing the correct answers
    public void correctAnsShowed(Question question, int numberOfStudents) {
		int correct = 0;
		int wrong = 0;
        System.out.println("Total number of students pick the correct vs wrong answer: ");
		for (int i = 0; i < numberOfStudents; i++) 
        { 
			if (question.getAns().equals(table.get(IDs[i]))) {
				correct++;
			} else {
				wrong++;
			}
		}
		System.out.println("Correct: " + correct);
		System.out.println("Wrong: " + wrong);
        System.out.println("\nThe correct answer is B");
	}

    //showing how many try the students submitted their answers 
    public void submittedAnsShowed(int ID) {
		if (totalSubmission == 1){
			System.out.println("ID(" + ID + ") (Re)-Submitted: " + totalSubmission + " try.");
		} else {
			System.out.println("ID(" + ID + ") (Re)-Submitted: "  + totalSubmission + " tries.");
		}
	}

    //the total number of submission 
	public void totalNumSubmitted(int number) {
		this.totalSubmission = number;
	}

    //Counting and showing the total answer for each letter chosen 
    public void totalAns(int answers) {
		
		int A = 0 ,B = 0 ,C = 0 , D = 0;

		for (int i = 0; i < IDs.length; i++) {
			for (int j = 0; j < table.get(IDs[i]).length(); j++){
				if (table.get(IDs[i]).charAt(j) == 'A') {
					A++;
				}
				if (table.get(IDs[i]).charAt(j) == 'B') {
					B++;
				}
				if (table.get(IDs[i]).charAt(j) == 'C') {
					C++;
				}
				if (table.get(IDs[i]).charAt(j) == 'D') {
					D++;
				}
			}
		}
		
		if (answers == 3){
			System.out.println("\nTotal chosen answers for each choices:");
			System.out.println("A: " + A + " | B: " + B + " | C: " + C + "\n");
		} 
		
		if (answers == 4){
			System.out.println("\nTotal chosen answers for each choices: ");
			System.out.println("A: " + A + " | B: " + B + " | C: " + C + " | D: " + D + "\n" );
		} 
	}

}