//write a java program to find the no of matches that could be conducted between 
//all the available teams
//when ever a team wins the match it get 3 points if tie the no points are alloted.
//and also display winner and runner up teams with their points.
import java.util.*;
public class Main{
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    //n represents the no of teams,
    //points array represents the points of each team
    int n=sc.nextInt();
    int points[]=new int[n];
    //count variable for finding total possible matches
    int cnt=0;
    //calculating the total no of matches that could be generated
    int i,j;
    for(i=1;i<=n;i++)
    {
        for(j=i+1;j<=n;j++)
        {
            cnt++;
        }
    }
    System.out.println("total matches conducted"+cnt);
    //taking  the score of the teams and then assign the points to 
    //the that wons the match.
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            int t1=i+1;
            int t2=j+1;
            System.out.println("Enter the score of the teams"+t1+" and "+t2);
            int score1=sc.nextInt();
            int score2=sc.nextInt();
            if(score1>score2)
            {
                points[i]=points[i]+3;

            }
            else if(score2>score1)
            {
                points[j]=points[j]+3;
            }
        }
    }
    int max1=0;
    int max2=0;
    max1=points[0];
    max2=points[0];
    int temp;
    int team1=1;
    //find the winning team and their score
    for(i=0;i<n;i++)
    {
        if(max1<points[i])
        {
            max1=points[i];
            team1=i+1;
        }
    }
    //find the runner up team and their score.
    int team2=1;
    for(i=0;i<n;i++)
    {
        if(max2>=max1 && max2<points[i])
        {
            team2=i+1;
            max2=points[i];
        }

    }
    System.out.println("Team "+team1 +"has won the matches with a score "+max1+" points");
    //find the other teams if even they have scored the maximum1.
    for(i=0;i<n;i++)
    {
        if(i!=team1-1)
        {
            int t3=i+1;
            if(max1==points[i])
            {
                System.out.println("Team "+t3 +"has won the matches with a score "+max1+" points");
            }
        }
    }
    if(max1!=max2)
    {
    System.out.println("Team "+team2 +"has got the runnerup with a score"+max2+" points");
    }
    if(max1>max2)
    {
    //find the other teams if even they have scored the maximum2.
    for(i=team1;i<n;i++)
    {
        if(i!=team2-1)
        {
            int t3=i+1;
            if(max2==points[i])
            {
                System.out.println("Team "+t3 +"has got the runner up with a score "+max2+" points");
            }
        }
    }
    }
}
}
