package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ExampleSubsystem;

public class Spin180 extends SequentialCommandGroup{
    private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

    public Spin180() {
        exampleSubsystem.differentialDrive(-0.45, 0.45);
        new WaitCommand(1);
        exampleSubsystem.differentialDrive(0, 0);
    }
}
