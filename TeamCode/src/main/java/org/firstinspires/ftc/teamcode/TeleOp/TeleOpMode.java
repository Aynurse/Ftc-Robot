package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.SubsystemBase.DrivetrainSubsystem;
import org.firstinspires.ftc.teamcode.Commands.DrivetrainCommand;

@TeleOp
public class TeleOpMode extends OpMode {


    private DrivetrainSubsystem drivetrainSubsystem;
    private DrivetrainCommand drivetrainCommand;

    @Override

    public void init() {
        drivetrainSubsystem = new DrivetrainSubsystem(hardwareMap);
        drivetrainCommand = new DrivetrainCommand(
                drivetrainSubsystem,
                () -> -gamepad1.left_stick_x,
                () -> -gamepad1.left_stick_y,
                () -> -gamepad1.right_stick_x);
        drivetrainCommand.schedule();

    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
    }

}
