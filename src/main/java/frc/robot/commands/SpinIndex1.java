package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.StorageSubsystem;

public class SpinIndex1 extends CommandBase{
    private StorageSubsystem storageSubsystem = new StorageSubsystem();

    public SpinIndex1() {
        addRequirements(storageSubsystem);
    }

    @Override
    public void execute() {
     storageSubsystem.spinIndex1(0.65);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        storageSubsystem.spinIndex1(0);
    }
}
