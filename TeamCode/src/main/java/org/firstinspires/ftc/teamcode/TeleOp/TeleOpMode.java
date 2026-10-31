import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.SubsystemBase.DrivetrainSubsystem;
import org.firstinspires.ftc.teamcode.Commands.DrivetrainCommand;
import org.firstinspires.ftc.teamcode.SubsystemBase.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.SubsystemBase.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Commands.ArmCommand;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class TeleOpMode extends OpMode {


    private DrivetrainSubsystem drivetrainSubsystem;
    private DrivetrainCommand drivetrainCommand;
    private ArmSubsystem armSubsystem;
    private ArmCommand armCommand;
    private IntakeSubsystem intakeSubsystem;
    private int targetTicks = 200;
    private Gamepad previousGamepad1 = new Gamepad();
    private Gamepad currentGamepad1 = new Gamepad();
    
    
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
    
    public void start() {
    drivetrainCommand.schedule();
    
    }

    @Override
    public void loop() {
        
        previousGamepad1.copy(currentGamepad1);
        currentGamepad1.copy(gamepad1);

        
        if (currentGamepad1.a && !previousGamepad1.a) {
            new ArmCommand(armSubsystem, targetTicks).schedule();
        }

        CommandScheduler.getInstance().run();
      }

    @Override
public void stop() {
    
    CommandScheduler.getInstance().reset();
    }

}
