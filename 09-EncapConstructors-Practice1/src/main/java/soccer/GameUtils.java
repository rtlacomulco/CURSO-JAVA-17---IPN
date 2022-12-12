/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccer;

/**
 *
 * @author rodrigo
 */
class GameUtils {    

    static void addGameGoals(Game currGame) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        for(int ind = 0; ind < currGame.getGoals().length; ind++){
            Goal goal = new Goal();
            int player = (int)(Math.random() * 3);
            int time = (int)(Math.random() * 90);
            int team = (int)(Math.random() * 2);
                        
            if(team == 1){
                goal.setThePlayer(currGame.getHomeTeam().getPlayerArray()[player]);
                goal.setTheTeam(currGame.getHomeTeam());
            }else{
                goal.setThePlayer(currGame.getAwayTeam().getPlayerArray()[player]);
                goal.setTheTeam(currGame.getAwayTeam());
            }
            
            goal.setTheTime(time);
            
             currGame.getGoals()[ind] = goal;
        }
    }
    
}
