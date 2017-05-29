package ut1;
public class Tree implements Comparable<Tree>
{
    private Node root;
    private int frequency = 0;
    private String path = "error";

    public Tree()
    {
	    root = null; 
    }

    public int compareTo(Tree object)
    {
    	if(frequency - object.frequency > 0)
    	{
    		return 1;
    	}
       
    	else if(frequency - object.frequency < 0)
    	{
    		return -1;
    	}
       
    	else
    	{
    		return 0;
    	}
    }

    public String getCode(char letter)
    {
    	inOrder(root, letter, "");
    	return path;  
    }


    private void inOrder(Node localRoot, char letter, String path)
    { 
    	if(localRoot != null)
    	{
    		if(localRoot.getData() == letter)
    		{
    			this.path = path;
    		}
    		
    		else
    		{
    			inOrder(localRoot.getLeftChild(), letter, path + "0"); 
    			inOrder(localRoot.getRightChild(), letter, path + "1"); 
    		}
    	}
    	
    	return;
    }

	public Node getRoot()
	{
		return root;
	}

	public void setRoot(Node root) 
	{
		this.root = root;
	}

	public int getFrequency() 
	{
		return frequency;
	}

	public void setFrequency(int frequency)
	{
		this.frequency = frequency;
	}

	public String getPath() 
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
    
    
}