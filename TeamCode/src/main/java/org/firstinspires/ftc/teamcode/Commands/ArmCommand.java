package org.firstinspires.ftc.teamcode.Commands;
import org.firstinspires.ftc.teamcode.SubsystemBase.ArmSubsystem;
import com.arcrobotics.ftclib.command.CommandBase;

public class ArmCommand extends CommandBase {

  private ArmSubsystem armSubsystem;
  private int encoderTicks;

  public ArmCommand(ArmSubsystem armSubsystem, int encoderTicks) {
    this.armSubsystem = armSubsystem;
    this.encoderTicks = encoderTicks;

    addRequirements(armSubsystem);
    
  }

  public void initialize() {
    armSubsystem.setArmTarget(encoderTicks);
    
  }

  public void execute() {
    
    armSubsystem.calculatePower();
    armSubsystem.gotoPosition();
  }

  public boolean isFinished() {

    return armSubsystem.isArmAtTarget();
  }

  public void end(boolean Interrupted) {
    armSubsystem.stopArm();
  }
  
}
