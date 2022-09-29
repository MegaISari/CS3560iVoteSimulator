public class Student {

	private int id;
	protected String ans;
	
	public Student(int id){
		this.setId(id);
	}

    //getter and setter the unique ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public boolean rightOrWrong(){
		int randomNum = (int) (Math.random() * 2);
		return randomNum == 0;
	}

    //choosing a single answer
	public void singleAnsRan(int num){
		this.ans = "" + (char) ((int) (Math.random() * num) + 65);	
	}

    //choosing multiple answers
	public void multipleAnsRan(int num){
		String choice = "";
		for (int i = 0; i < num; i++){
			if (rightOrWrong()){
				choice += (char)(i + 65);
			}
		}
		ans = choice;
	}
}