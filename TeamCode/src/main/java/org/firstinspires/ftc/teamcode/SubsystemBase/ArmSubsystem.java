package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class ArmSubsystem {
  private DcMotor armRotationMotor;

public ArmSubsystem(HardwareMap hw) {
  
  armRotationMotor = hw.get(DcMotor.class, "armRotationMotor");
  armRotationMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

}

  public int getArmPosition() {
    return armRotationMotor.getCurrentPosition();
  }

  public void setArmTarget(int targetPosition) {
    armRotationMotor.setTargetPosition(targetPosition);

  }

}
