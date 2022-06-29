package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase{
    ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    boolean finished = false;
    double power;
    
    public ShooterCommand() {
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        shooterSubsystem.shoot(0.85);
    }


    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public void end(boolean interrupted) {
       shooterSubsystem.stop();
        finished = true;
    }
}
