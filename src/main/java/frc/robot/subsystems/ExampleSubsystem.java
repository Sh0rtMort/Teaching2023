// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ExampleCommand;


public class ExampleSubsystem extends SubsystemBase {
  private Talon frontRight = new Talon(0);
  private Talon backRight = new Talon(1);
  private Talon frontLeft = new Talon(2);
  private Talon backLeft = new Talon(3);
  private Talon spikeWheel = new Talon(4);

  private Solenoid omniWheel = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  private MotorControllerGroup rightGroup = new MotorControllerGroup(frontRight, backRight);
  private MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeft, backLeft);
  
  private DifferentialDrive differentialDrive = new DifferentialDrive(rightGroup, leftGroup);

  public ExampleSubsystem() {
    setDefaultCommand(new ExampleCommand(this));
  }

  @Override
  public void periodic() {

  }

  public void mecanum(double forward, double sideways, double rotation) {
    forward *= -1;
    frontRight.set((forward + sideways) + rotation);
    backRight.set((forward - sideways)  + rotation);
    frontLeft.set(-(forward - sideways) + rotation);
    backLeft.set(-(forward + sideways)  + rotation);
  }

  public void arcade(double forward, double rotation) {
    differentialDrive.arcadeDrive(forward, rotation);
  }

  public void tank(double leftPower, double rightPower) {
    leftGroup.set(-leftPower);
    rightGroup.set(rightPower);
  } 

  public void omniSpike(boolean spikeSet) {
    omniWheel.set(spikeSet);
  }

  public void omniDrive(double forward, double spikeWheelSpeed, double rotation) {
   spikeWheel.set(spikeWheelSpeed);
   differentialDrive.arcadeDrive(forward, rotation);
  }

  public void curvatureDrive(double forward, double rotation, boolean inPlace) {
    differentialDrive.curvatureDrive(forward, rotation, inPlace);
  }
  public void stop() {
    mecanum(0, 0, 0);
    arcade(0, 0);
    tank(0, 0);
  }
}
