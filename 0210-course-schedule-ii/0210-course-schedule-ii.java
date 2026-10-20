
import java.util.*;
class Solution {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public int[] findOrder(int numCourses,int[][] prerequisites){
        ArrayList<Edge>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            graph[b].add(new Edge(b,a));
        }
        int[] indeg=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
                Edge e=graph[v].get(j);
                indeg[e.dest]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            ans[idx++]=curr;
            for(int j=0;j<graph[curr].size();j++){
                Edge e=graph[curr].get(j);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        if(idx!=numCourses){
            return new int[0];
        }
        return ans;
    }
}
