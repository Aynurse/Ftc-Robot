import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.SubsystemBase.DrivetrainSubsystem;
import org.firstinspires.ftc.teamcode.Commands.DrivetrainCommand;
import org.firstinspires.ftc.teamcode.SubsystemBase.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.SubsystemBase.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Commands.ArmCommand;

@TeleOp
public class TeleOpMode extends OpMode {


    private DrivetrainSubsystem drivetrainSubsystem;
    private DrivetrainCommand drivetrainCommand;
    private ArmSubsystem armSubsystem;
    private ArmCommand armCommand;
    private IntakeSubsystem intakeSubsystem;
    private int targetTicks = 200;
    
    @Override

    public void init() {
        drivetrainSubsystem = new DrivetrainSubsystem(hardwareMap);
        drivetrainCommand = new DrivetrainCommand(
                drivetrainSubsystem,
                () -> -gamepad1.left_stick_x,
                () -> -gamepad1.left_stick_y,
                () -> -gamepad1.right_stick_x);
        drivetrainCommand.schedule();

        intakeSubsystem = new IntakeSubsystem(hardwareMap);
        armSubsystem = new ArmSubsystem(hardwareMap);
        armCommand = new ArmCommand(armSubsystem, targetTicks);
        
        

    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();

        
        }
    }

}
