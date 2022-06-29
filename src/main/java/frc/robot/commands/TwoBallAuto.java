package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.StorageSubsystem;

public class TwoBallAuto extends SequentialCommandGroup{
    private ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    private IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private StorageSubsystem storageSubsystem = new StorageSubsystem();
    
    public TwoBallAuto() {
    addCommands(new ParallelDeadlineGroup(
        new SequentialCommandGroup(
            new Shoot2Balls(),
            new WaitCommand(2),
            new Spin180(),
            new DriveToSecondBall()
        ), 
            new IntakeCommand()
        ));
    addCommands(
            new DriveToSecondBall()
        );
    addCommands(
            new Shoot2Balls()
        );
    }
}
