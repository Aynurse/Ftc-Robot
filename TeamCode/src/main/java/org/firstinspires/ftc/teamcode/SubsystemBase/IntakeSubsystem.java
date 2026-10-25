package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {
    private DcMotor intakeMotor;

    public IntakeSubsystem(HardwareMap hw) {
        intakeMotor = hw.get(DcMotor.class, "intake");
    }
}
