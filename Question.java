public class Question {
	
	private String qs;
	private String ans;
	
    //To ask questions and tell the right answers
	public Question(String qs, String ans){
		this.setQs(qs);
		this.setAns(ans);
	}

    //getter and setter for answer
    public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

    //getter and setter questions
	public String getQs() {
		return qs;
	}

	public void setQs(String qs) {
		this.qs = qs;
	}
}