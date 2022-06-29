package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StorageSubsystem extends SubsystemBase{
    private Talon index1 = new Talon(7);
    private Talon index2 = new Talon(8);
    private Talon index3 = new Talon(9);

    public StorageSubsystem() {
    }

    public void spinIndex1(double speed) {
        index1.set(speed);
    }

    public void spinIndex2(double speed) {
        index2.set(speed);
    }

    public void spinIndex3(double speed) {
        index3.set(speed);
    }

    public void cycleToIndex3(double speed) {
        spinIndex1(speed);
        spinIndex2(speed);
        spinIndex2(0);
    }

}
