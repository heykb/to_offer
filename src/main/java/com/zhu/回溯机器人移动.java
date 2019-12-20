package com.zhu;

import java.util.Arrays;

public class 回溯机器人移动 {
    public int getDightSum(int number){

        int sum=0;
        while(number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
    public boolean check(int m,int n,int k,boolean[][] visited ){

        return (m<visited.length && m>=0 && n<visited[0].length && n>=0
                && !visited[m][n] && getDightSum(m)+getDightSum(n)<=k);
    }
    public int move(int m,int n,int k,boolean[][] visited){
        int steps = 0;
        if(check(m,n,k,visited)){
            visited[m][n]=true;
            steps = 1+move(m,n-1,k,visited)
                    +move(m,n+1,k,visited)
                    +move(m+1,n,k,visited)
                    +move(m-1,n,k,visited);
            return steps;
        }
        return steps;

    }
    public int movingCount(int k, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        for(boolean[] b:visited) Arrays.fill(b,false);

        return move(0,0,k,visited);

    }
}
