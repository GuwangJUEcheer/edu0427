package Demo;

public class NodeDemo {
	// Tree的Node
	private Integer data;

	private NodeDemo left = null;

	private NodeDemo right = null;

	public NodeDemo(Integer root) {
		this.data = root;
	}

	public void insert(Integer data) {
		if(data<this.data) {
			if(this.left==null) {
				this.left=new NodeDemo(data);
			
	
		}else {
			//这里使用递归调用
			//空的话直接放节点，如果已经有的话就进行比较
			this.left.insert(data);
		}
	}else if(data>this.data) {
		if(this.right==null) {
			this.right=new NodeDemo(data);
		}else {
			this.right.insert(data);
		}
	}else {
		this.data=data;
	}
	
}

/*三种遍历方式：前中后
 * 中序：左中右的形式。从最左开始，到中，右到最右
 */
public void inorder() {
	//左
	if(this.left!=null) {
		this.left.inorder();
	}
	//中
	System.out.println(this.data);
	//右
	if(this.right!=null) {
		this.right.inorder();
	}
}
	public static void main(String[] args){
	NodeDemo node=new NodeDemo(5);
	node.insert(10);
	node.insert(15);
	node.insert(11);
	node.insert(12);
	node.insert(3);
	node.insert(8);
	node.inorder();
	}

}


