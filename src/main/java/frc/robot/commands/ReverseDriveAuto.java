package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;

public class ReverseDriveAuto extends SequentialCommandGroup{
    private final ExampleSubsystem exampleSubsystem = RobotContainer.exampleSubsystem;
    public ReverseDriveAuto() {
        addCommands(
            new WaitCommand(2)
        );
    exampleSubsystem.differentialDrive(-0.5, -0.5);
    new WaitCommand(3);
    exampleSubsystem.differentialDrive(0, 0);
    }
}
