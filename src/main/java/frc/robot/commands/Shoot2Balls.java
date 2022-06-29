package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.StorageSubsystem;

public class Shoot2Balls extends SequentialCommandGroup{
    private final StorageSubsystem storageSubsystem = new StorageSubsystem();
    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

    public Shoot2Balls() {
        addCommands(new SequentialCommandGroup(
            new ShooterCommand(),
            new WaitCommand(2),
            new Index3ToShooterCommand(storageSubsystem),
            new MoveToShooter(),
            new ShooterCommand()
        ));
    }
}
