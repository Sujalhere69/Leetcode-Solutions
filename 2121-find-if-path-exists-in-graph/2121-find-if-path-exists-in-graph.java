class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean vis[]= new boolean[n];
Queue<Integer> q = new LinkedList<>();
        vis[source]= true;
        q.add(source);
        while(!q.isEmpty()){
            int node = q.poll();
            if(node==destination){
                return true;
            }
            for(int it : adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it]=true;
                }
            }
        }
        return false;
    }
}