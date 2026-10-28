package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class ArmSubsystem {
  private DcMotor armRotationMotor;
  private double power;
  //kP sonrası hesaplanan güç 
  private final double armkP = 0.2;
  private final double armkI = 0;
  private final double armkD = 0;
  //pid

  private int encoderTicks;
  //bu hedeflenen ticks

public ArmSubsystem(HardwareMap hw) {
  
  armRotationMotor = hw.get(DcMotor.class, "armRotationMotor");
  armRotationMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

}

  public int getArmPosition() {
    return armRotationMotor.getCurrentPosition();

    //armın şuanki pozisyonunu alıyo
  }

  public void setArmTarget(int targetPosition) {
    armRotationMotor.setTargetPosition(targetPosition);
    encoderTicks = targetPosition;
//armın yerini belirliyor
  }

  public void calculatePower(){
    
    int currentTicks = getArmPosition();
    //şuanki ticksini bi değişkene atıyo 
    
    double calculatedPower = (encoderTicks- currentTicks) * armkP;
    //hedeflenen - şuanki ticks * kP
    power = Math.max(-1.0, Math.min(1.0, calculatedPower));
    //clamping

  }
  

  public void gotoPosition() {
    
    armRotationMotor.setPower(power);

  }

  public boolean isArmAtTarget() {
    
    int currentPosition = getArmPosition();
    
    if (Math.abs(currentPosition - encoderTicks) < 5) {
      return true;
    }
      return false;
      
  }

  public void stopArm() {
    armRotationMotor.setPower(0);
  }

}
