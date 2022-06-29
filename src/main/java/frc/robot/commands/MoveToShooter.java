package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.StorageSubsystem;

public class MoveToShooter extends SequentialCommandGroup{
    private final StorageSubsystem storageSubsystem = new StorageSubsystem();

    public MoveToShooter() {
        storageSubsystem.cycleToIndex3(0.85);
        new WaitCommand(2);
        storageSubsystem.cycleToIndex3(0);
    }
}
