/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;
import java.util.StringTokenizer;
import utility.PlayerDatabase;


/**
 *
 * @author Administrator
 */
public class League {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 3);
        Game[] theGames = theLeague.createGames(theTeams);

        for (Game currGame: theGames){
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        
        theLeague.showBestTeam(theTeams);

    }

    public Team[] createTeams(String teamNames, int teamSize) {

        /* Practice 11-1. Remove the code below that creates The Greens and The Reds */
        
        /* Practice 11-1. Remove the above code that creates The Greens and The Reds */
        
        PlayerDatabase playerDB = new PlayerDatabase();
        
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames,",");        
        
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        
        for(int i = 0; i < theTeams.length; i++){
            theTeams[i] = new Team(teamNameTokens.nextToken(),playerDB.getTeam(teamSize));
        }

        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        ArrayList<Game> theGames = new ArrayList();
        
        for (Team homeTeam: theTeams) {
            for (Team awayTeam: theTeams) {
                if (homeTeam!=awayTeam) {
                    theGames.add(new Game(homeTeam,awayTeam));
                }
            }
        }
        
        return (Game[]) theGames.toArray( new Game[1] );
    }
    
    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : "
                     + currTeam.getGoalsTotal());
            currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal()?currTeam:currBestTeam;
            if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()){
                currBestTeam = currTeam;
            } else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()){
                if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()){
                currBestTeam = currTeam;
                }
            }
        }
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
    }

}
