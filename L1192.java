//TC:O(V+E)
//SC:O(N)

//Tarjan Algorithm
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // construct an undirected graph
        for(int i = 0; i < connections.size(); i++){
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);            
        }

        for(int i = 0; i < n; i++){
            if(disc[i] == -1){
                dfs(i, i, graph, disc, low, res);
            }
        }

        return res;
    }
    
    int time = 0; // time when discover each vertex
    
    private void dfs(int u, int pre, List<Integer>[] graph, int[] disc, int[] low, List<List<Integer>> res){
        disc[u] = low[u] = time++;
        
        for(int j = 0; j < graph[u].size(); j++){
            int v = graph[u].get(j);

            // if parent vertex, ignore
            if(v == pre){
                continue;
            }

            if(disc[v] == -1){ // if not discovered
                dfs(v, u, graph, disc, low, res);
                low[u] = Math.min(low[u], low[v]);
                
                // u - v is critical
                if(low[v] > disc[u]){
                    res.add(Arrays.asList(u, v));
                }
                
            }else{ // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], disc[v]);
            }
            
        }
    }
}