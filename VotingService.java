import java.util.Hashtable;

public interface VotingService {
	
    public void chosenAnswer(Hashtable<Integer, String> table);
    public void totalAns(int answers);
    public void totalNumSubmitted(int number);
    public void qsShowed(Question question);
    public void correctAnsShowed(Question question, int numberOfStudents);
    public void submittedAnsShowed(int ID);
}
