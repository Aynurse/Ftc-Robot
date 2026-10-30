package org.firstinspires.ftc.teamcode.Commands;
import org.firstinspires.ftc.teamcode.SubsystemBase.ArmSubsystem;
import com.arcrobotics.ftclib.command.CommandBase;

public class ArmSubsystem {

  private ArmSubsystem armSubsystem;

  public ArmSubsystem(ArmSubsystem armSubsystem) {
    this.ArmSubsystem = armSubsystem;

    addRequirements(armSubsystem);
    
  }

  public void initialize() {
    
  }

  public void execute() {
    
  }

  public void isFinished() {

  }
  
}
