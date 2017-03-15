public class ExpressionNode {

	public ExpressionNode left;
	public ExpressionNode right;
	public String data;

	public ExpressionNode(String data, ExpressionNode left, ExpressionNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}