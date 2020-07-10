package Demo;

public class NodeDemo {
	// Tree��Node
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
			//����ʹ�õݹ����
			//�յĻ�ֱ�ӷŽڵ㣬����Ѿ��еĻ��ͽ��бȽ�
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

/*���ֱ�����ʽ��ǰ�к�
 * ���������ҵ���ʽ��������ʼ�����У��ҵ�����
 */
public void inorder() {
	//��
	if(this.left!=null) {
		this.left.inorder();
	}
	//��
	System.out.println(this.data);
	//��
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


