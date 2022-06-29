package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private Talon intake = new Talon(6);
    private Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

    public IntakeSubsystem() {
       
    }
    public void setDown(boolean down) {
        intakeSolenoid.set(down);
    }

    public void startSpinning(boolean spinning) {
        double power = spinning ? 0.4 : 0;
        intake.set(power);
    }

    public void dropAndSpin() {
        startSpinning(true);
        setDown(true);
        System.out.println("Intake Activated");
    }

    public void upAndStop() {
        setDown(false);
        startSpinning(false);
        System.out.println("Intake DeActivated");
    }
    
    
}
