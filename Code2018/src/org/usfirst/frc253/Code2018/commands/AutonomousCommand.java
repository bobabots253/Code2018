 // RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc253.Code2018.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc253.Code2018.Robot;
import org.usfirst.frc253.Code2018.Robot.Ally;
import org.usfirst.frc253.Code2018.Robot.Enemy;
import org.usfirst.frc253.Code2018.Robot.Goal;
import org.usfirst.frc253.Code2018.Robot.Position;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	//So in this command, there is both the decision making for the robot and there is also
	//what the robot will do depending on the situation it is in
    public AutonomousCommand(Position position, Goal goal, String gameData){
    	char switchSide = gameData.charAt(0); //L for Left, R for Right (relative to our alliance station)
    	char scaleSide = gameData.charAt(1);
    	
    	if(position == Position.CENTER){
    		switch(goal){
    			case SWITCH:
    				if(switchSide == 'L'){
    					//TODO: leftSwitch from center
    				} else if(switchSide == 'R') {
    					//TODO: rightSwitch from center
    				}
    				break;
    			case EXCHANGE:
    				//TODO: exchange from center
    				break;
    			default:
    				if(switchSide == 'L'){
    					//TODO: rightBaseline from center
    				} else if(switchSide == 'R') {
    					//TODO: leftBaseline from center
    				}
    				break;
    		}
    	} else if(position == Position.LEFT || position == Position.RIGHT){
    		switch(goal){
    			case SCALE:
    				if(scaleSide == position.getPos()){
    					if(position == Position.LEFT){
    						//TODO: leftScale from left
    					} else if(position == Position.RIGHT){
    						//TODO: rightScale from right
    					}
    				}
    			case SWITCH:
    				
    				break;
    		}
    	}
    }
	
	@Deprecated
	public AutonomousCommand(Position position, char switchSide, char scaleSide, Enemy canDo, Ally isDoing) {
    	requires(Robot.driveTrain);//Makes it so that we can use the things inside robot 
    	//and elevator
    	requires(Robot.elevator);
    	
    	if(position == Position.LEFT || position == Position.RIGHT){
    		if(switchSide == position.getPos() && scaleSide != position.getPos()){//Switch is ours and scale is not ours
    			if(canDo == Enemy.SCALE){ 
    			}else{ //these are defend and after the else are going to the switch and scoring
    				addSequential(new SwitchScore());
    			}
    		}else if(switchSide != position.getPos() && scaleSide == position.getPos()){//Switch is not ours scale is ours
    			if(canDo == Enemy.DEFEND){
    				addSequential(new exchangeCommand());
    			}else{ //we either go exchange or go to scale
    				addSequential(new ScaleScore());

    			} 
    		}else if(switchSide == position.getPos() && scaleSide == position.getPos()){//both switch and scale is ours
    			if(canDo == Enemy.DEFEND){
    				addSequential(new SwitchScore());
    			}else{//we either score in switch or scale
    				addSequential(new ScaleScore());
    			} 
    		}else if(switchSide != position.getPos() && scaleSide != position.getPos()){//Neither scale or switch  
    			if(canDo == Enemy.SCALE){
    			}else{//defend if enemy is going scale otherwise we exchange
    				addSequential(new exchangeCommand());
    			}
    		}
    	}else if (position == Position.CENTER){
    		if(switchSide == 'L'){
        		if(isDoing == Ally.SCALEORDEFEND){
    				addSequential(new SwitchScore());
        		}else{//this is for if we are in center and we either switch score or exchange
    				addSequential(new exchangeCommand());
        		}
        	}else if(switchSide == 'R'){
        		if(isDoing == Ally.SCALEORDEFEND){
    				addSequential(new SwitchScore()); 
        		}else{//we either switch score or exchange
    				addSequential(new exchangeCommand());
        		}
        	}
    	}
    }
}
