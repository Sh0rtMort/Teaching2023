// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;

public class ExampleCommand extends CommandBase {
  private ExampleSubsystem driveSystem;

  public ExampleCommand(ExampleSubsystem driveSystem) {
    addRequirements(driveSystem);
    this.driveSystem = driveSystem;
  }

  @Override
  public void execute() {
    String controls = RobotContainer.controlChooser.getSelected();
    if (controls == null) controls = "airplane-tank";
    if (controls.equals("Tank")) {
      driveSystem.tank(
        -RobotContainer.gamepad.getLeftY() * 0.6, 
        -RobotContainer.gamepad.getRightY() * 0.6
        );
    if (controls.equals("Arcade")) {
      driveSystem.arcade(
        -RobotContainer.gamepad.getLeftY() * 0.6, 
        RobotContainer.gamepad.getRightX() * 0.6
        );
    if (controls.equals("Rocket League Drive")) {
      driveSystem.arcade(
      (-RobotContainer.gamepad.getRawAxis(3) + RobotContainer.gamepad.getRawAxis(1)) * 0.6, 
      RobotContainer.gamepad.getRightX() * 0.6
      );
    if (controls.equals("Mecanum Drive")) {
      driveSystem.mecanum(
      -RobotContainer.gamepad.getLeftY() * 0.6, 
      RobotContainer.gamepad.getLeftX() * 0.8, 
      RobotContainer.gamepad.getRightX() * 0.4
      );
    if (controls.equals("Omni Drive")) {
      driveSystem.omniSpike(RobotContainer.gamepad.getXButtonPressed());
      driveSystem.omniDrive(
        -RobotContainer.gamepad.getLeftY(), 
        RobotContainer.gamepad.getLeftX(), 
        RobotContainer.gamepad.getRightY()
        );
    if (controls.equals("Curvature Drive")) {
      driveSystem.curvatureDrive(
        -RobotContainer.gamepad.getLeftY(), 
        RobotContainer.gamepad.getRightX(), 
        RobotContainer.gamepad.getXButton()
        );
    }
    }

    
    }



    }
    }
    }


  }

  @Override
  public void end(boolean interrupted) {
    driveSystem.stop();
  }
}
