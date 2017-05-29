package ut1;

public class Node
{
	private char data;
	private Node leftChild;
	private Node rightChild;
	
	public Node(char data)
	{
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	public Node()
	{
		
	}

	public char getData() 
	{
		return data;
	}

	public void setData(char data)
	{
		this.data = data;
	}

	public Node getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(Node leftChild)
	{
		this.leftChild = leftChild;
	}

	public Node getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(Node rightChild)
	{
		this.rightChild = rightChild;
	}
	
	
}