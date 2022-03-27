import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

	int result = -1;
	int count = 0;
  public int findKthLargestValueInBst(BST tree, int k) {
		// do a reverse inorder traversal of BST and keep count
		count = k;
		reverseInOrder(tree);
		return result;
  }
	
	private void reverseInOrder(BST tree){
		if(tree == null){
			return;
		}
		reverseInOrder(tree.right);
		if(--count == 0){
			result= tree.value;
		}
		reverseInOrder(tree.left);
	}
}
