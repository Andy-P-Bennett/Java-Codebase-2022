/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class BarrelMotors extends CommandBase {
  double m_lSpeed, m_rSpeed;
  /**
   * Creates a new TankDrive.
   */
  public BarrelMotors(double lSpeed, double rSpeed) {
    m_lSpeed = lSpeed;
    m_rSpeed = rSpeed;
    addRequirements(Robot.rollCage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.rollCage.barrelReset();
    Robot.rollCage.setLeftCageMotor(m_lSpeed);
    Robot.rollCage.setRightCageMotor(m_rSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
