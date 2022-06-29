// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ReverseDriveAuto;
import frc.robot.commands.Shoot2Balls;
import frc.robot.commands.ShootReverse;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.SpinIndex1;
import frc.robot.commands.TwoBallAuto;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.StorageSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static final StorageSubsystem storageSubsystem = new StorageSubsystem();
  // The robot's subsystems and commands are defined here...
  public final static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
  public final static XboxController gamepad = new XboxController(0);
  public static SendableChooser<String> controlChooser = new SendableChooser<>();
  public static SendableChooser<Command> autoChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    intakeSubsystem.setDefaultCommand(new IntakeCommand());
    shooterSubsystem.setDefaultCommand(new ShooterCommand());
    configureButtonBindings();

    controlChooser.addOption("Tank", "Tank");
    controlChooser.addOption("Arcade", "Arcade");
    controlChooser.addOption("Rocket League Drive", "Rocket League Drive");
    controlChooser.addOption("Mecanum Drive", "Mecanum Drive");
    controlChooser.addOption("Curvature Drive", "Curvature Drive");
    controlChooser.addOption("Omni Drive", "Omni Drive");
    SmartDashboard.putData("Controls", controlChooser);


    autoChooser.addOption("None", null);
    autoChooser.addOption("Reverse Drive Auto", new ReverseDriveAuto());
    autoChooser.addOption("Shoot Reverse Auto", new ShootReverse());
    autoChooser.addOption("2 Ball Auto", new TwoBallAuto());

  }

  
  private void configureButtonBindings() {
    new JoystickButton(gamepad, Constants.ButtonBindings.Shoot).toggleWhenActive(new Shoot2Balls());
    new JoystickButton(gamepad, Constants.ButtonBindings.intake).toggleWhenActive(new IntakeCommand());
    new JoystickButton(gamepad, Constants.ButtonBindings.Index).toggleWhenActive(new SpinIndex1());
  }



  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoChooser.getSelected();
  }
}
