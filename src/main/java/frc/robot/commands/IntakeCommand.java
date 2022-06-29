package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase{
    private IntakeSubsystem intakeSubsystem;
    public IntakeCommand() {
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
     intakeSubsystem.dropAndSpin();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.upAndStop();
    }

}
