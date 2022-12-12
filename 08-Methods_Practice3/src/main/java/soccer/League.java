/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package soccer;

/**
 *
 * @author rodrigo
 */
public class League {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        League theLeague = new League();
        
        Team[] theTeams = theLeague.createTeams();
        
        Game[] theGames = theLeague.createGames(theTeams);
        
        Game currGame = theGames[0];
        
        currGame.playGame();

        System.out.println(currGame.getDescription());
        
    }
    
    public Team[] createTeams() {
        Player player1 = new Player();
        player1.playerName = "George Eliot";
        
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";
        
        Player[] thePlayers = {player1,player2,player3};        
        Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers;
        
        //player1.playerName = "Robert Service";

        Team team2 = new Team();
        team2.teamName = "The Reds";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Robert Service";        
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Robbie Burns";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Rafael Sabatini";           
        
        Team[] theTeams = {team1, team2};        
        return theTeams;
    }
    
    public Game[] createGames(Team[] theTeams) {
        Game theGame = new Game();
        theGame.homeTeam = theTeams[0];
        theGame.awayTeam = theTeams[1];
        Game[] theGames = {theGame};
        return theGames;
    }
    
}
