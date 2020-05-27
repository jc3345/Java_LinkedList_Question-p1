/**
* @author      Jiachao Chen <jc3345@cornell.edu>
* Binary tree Level Order

 */

    //DFS
    List<List<Integer>> res; 
    public List<List<Integer>> levelOrder(TreeNode root) {
        res  = new ArrayList<>();
        if(root == null) return res;
        
        dfs(root, 0);
        
        return res;
    }
    
    
    private void dfs(TreeNode root, int level){
        if(root == null) return ;
        if(res.size()<= level){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }




    //BFS
    public List<List> levelOrder(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    if(root==null){
        return res;
    }
    
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    
    queue.add(root);
    
    while(queue.size()!=0){
        
        int size = queue.size();
        List<Integer> levels = new ArrayList<Integer>();
        
        for(int i = 0; i< size; i++){
            TreeNode temp = queue.poll();
            levels.add(temp.val);
            
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
            
            size--;
        }

        res.add(layer_vals);
    }
    
    return res;
    
}
