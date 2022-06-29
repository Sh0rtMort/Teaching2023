package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootReverse extends SequentialCommandGroup{
    private final ShooterSubsystem shooterSubsystem = RobotContainer.shooterSubsystem;
    private final ExampleSubsystem exampleSubsystem = RobotContainer.exampleSubsystem;

    public ShootReverse() {
        addCommands(
            new Shoot2Balls()
        );
        exampleSubsystem.differentialDrive(-0.45, -0.45);
    }
}
