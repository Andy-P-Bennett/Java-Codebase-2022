/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.BarrelDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class Rollcage extends SubsystemBase {
  private Victor cageLeft = new Victor(Constants.CAGE_LEFT_ID);
  private Victor cageRight = new Victor(Constants.CAGE_RIGHT_ID);
  Encoder barrelEncoder = new Encoder(6, 7);
  /**
   * Creates a new Rollcage.
   */
  public Rollcage() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new BarrelDrive());
  }


public double barrelDistance(){
  return barrelEncoder.getDistance();
}
public void barrelReset(){
  barrelEncoder.reset();
  barrelEncoder.setDistancePerPulse(1/ 104*(5/6)*Math.PI);
}

public void setLeftCageMotor(double Clspeed){
  cageLeft.set(Clspeed);
  //cageLeft.setSafetyEnabled(true);
}

public void setRightCageMotor(double Crspeed){
  cageRight.set(Crspeed);
  //cageRight.setSafetyEnabled(true);
}
}

