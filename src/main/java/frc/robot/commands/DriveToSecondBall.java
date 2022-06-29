package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ExampleSubsystem;

public class DriveToSecondBall extends SequentialCommandGroup{
    private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

    public DriveToSecondBall() {
        exampleSubsystem.differentialDrive(0.35, 0.35);
        new WaitCommand(2);
        exampleSubsystem.differentialDrive(0, 0);
    }
}
