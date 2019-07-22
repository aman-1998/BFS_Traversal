import java.util.*;
import java.lang.*;

class bfs
{	
	int[][] G=new int[20][20];
	int[] visited=new int[20];
	int[] queue=new int[20];
	void BFT(int n,int v)
	{
		int i;
		for(i=1;i<=n;i++)
			visited[i]=0;
		BFS(n,v);
		for(i=1;i<=n;i++)
		{
			if(visited[i]==0)
				BFS(n,i);
		}
	}
	void BFS(int n,int v)
	{
		int u,i,r=-1,f=0;
		u=v;
		visited[u]=1;
		System.out.print(u+" ");
		while(true)
		{
			for(i=1;i<=n;i++)
			{
				if(G[u][i]==1 && visited[i]==0)
				{
					visited[i]=1;
					System.out.print(i+" ");
					r++;
					queue[r]=i;
				}
			}
			if(f>r)
				break;
			u=queue[f];
			f++;
		}
	}
	public static void main(String args[])
	{
		int i,j;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of vertices: ");
		int n=in.nextInt();
		bfs x=new bfs();
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print("Enter G["+i+"]["+j+"] : ");
				x.G[i][j]=in.nextInt();
				if(x.G[i][j]!=1 && x.G[i][j]!=0)
				{
					System.out.println("Invalid Input");
					j--;
				}
			}
		}
		System.out.print("\nAdjacency Matrix: ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
				System.out.print(x.G[i][j]+" ");
			System.out.println();
		}
		System.out.print("Enter the vertex from you want to start: ");
		int v=in.nextInt();
		x.BFT(n,v);
	}
}