import java.util.*;
public class graph01{
    public static class edge{
        int v;
        int w;
        edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    static int N=7;
    static ArrayList<edge>[]graph= new ArrayList[N];
    public static void addEdge(int u,int v,int w){
        graph[u].add(new edge(v,w));
        graph[v].add(new edge(u,w));
    }
    public static void display(){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+" >>");
            for(edge e:graph[i]){
                System.out.print("("+e.v+" "+e.w+") ");
            }
            System.out.println();
        }
    }
    public static int findVtx(int u,int v){
        int idx=-1;
        for(int i=0;i<graph[u].size();i++){
            edge e=graph[u].get(i);
            if(e.v==v){
                idx=i;
                break;
            }
        }
        return idx;
    }
    public static void removeEdge(int u,int v){
        int idx1=findVtx(u, v);
        int idx2=findVtx(v, u);

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }
    public static void removeVtx(int u){
        while(graph[u].size()!=0){
            int v=graph[u].get(graph[u].size()-1).v;
            removeEdge(u, v);
        }
    }
    public static boolean hasPath(int src,int dest,boolean[]vis){
        if(src==dest) return true;
        vis[src]=true;
        boolean res=false;
        for(edge e:graph[src]){
            if(!vis[e.v]){
                vis[e.v]=true;
                res|=hasPath(e.v,dest,vis);
            }
        }
        return res;
    }
    public static int hasAllPath(int src,int dest,int wsf,boolean[] vis,String path){
        
    }
    public static void bfsOfGraph(){
        boolean []visited=new boolean[N];
        LinkedList<Integer>que=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        que.addLast(0);
        visited[0]=true;
        while(!que.isEmpty()){
            int vtx= que.removeFirst();
            System.out.print(vtx+" ");
            ans.add(vtx);
            for(edge e:graph[vtx]){
                if(!visited[e.v]){
                    que.addLast(e.v);
                    visited[e.v]=true;
                }
            }
        }
        System.out.println();
    }
    public static void dfsOfGraph(){

    }

    public static void main(String []args){
        for(int i=0;i<N;i++)
            graph[i]=new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 40);
        addEdge(3, 0, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
        // System.out.println(">>>>>>Before>>>>>>");
        // display();
        // removeVtx(4);
        // System.out.println(">>>>>>After>>>>>>");
        // display();
        // bfsOfGraph();
        System.out.println(hasPath(0,6,new boolean[N]));
        // display();

    }
    
}