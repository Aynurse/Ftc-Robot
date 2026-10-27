package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo

public class IntakeSubsystem {
    private DcMotor intakeMotor;
    private DcMotor armRotationMotor;
    private Servo intakeServo;

    public IntakeSubsystem(HardwareMap hw) {
        intakeMotor = hw.get(DcMotor.class, "intakeMotor");
        intakeServo = hw.get(Servo.class, "intakeServo");
        armRotationMotor = hw.get(DcMotor.class, "armRotationMotor");
    }

    public void turnIntakeServo() {
        intakeServo.setPosition(1);
    }

    public void stopIntakeServo(){
        intakeServo.setPosition(0.5);
    }

}
