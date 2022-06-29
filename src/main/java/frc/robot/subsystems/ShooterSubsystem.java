package frc.robot.subsystems;

import java.time.Period;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private Talon shooter = new Talon(5);

    public void shoot(double power) {
        shooter.set(power);
    }




public void stop() {
    shooter.set(0);
}
}
