package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.StorageSubsystem;

public class Index3ToShooterCommand extends SequentialCommandGroup{
    private StorageSubsystem storageSubsystem = RobotContainer.storageSubsystem;

    public Index3ToShooterCommand(StorageSubsystem storageSubsystem) {
        storageSubsystem.spinIndex3(0.65);
        new WaitCommand(1);
        storageSubsystem.spinIndex3(0);
    }
}
