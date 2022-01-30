/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class BarrelDrive extends CommandBase {
  /**
   * Creates a new BarrelDrive.
   */
  public BarrelDrive() {
    addRequirements(Robot.rollCage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double BleftStickY = Robot.m_RC.GetBarrelRawAxis(Constants.LEFT_STICKY);
    double BrightStickY = Robot.m_RC.GetBarrelRawAxis(Constants.RIGHT_STICKY);

    Robot.rollCage.setLeftCageMotor(-BleftStickY*0.8);
    Robot.rollCage.setRightCageMotor(BrightStickY*0.7);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.rollCage.setLeftCageMotor(0);
    Robot.rollCage.setRightCageMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
