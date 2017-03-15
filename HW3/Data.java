public class Data {
	private int data;
	private char sign;

	public Data(int num){
		this.data = num;
		this.sign = null;
	}

	public Data(char sign){
		this.data = null;
		this.sign = sign;
	}
}