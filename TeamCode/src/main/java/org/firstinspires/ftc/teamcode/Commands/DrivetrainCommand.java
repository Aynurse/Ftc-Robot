package org.firstinspires.ftc.teamcode.Commands;
import org.firstinspires.ftc.teamcode.SubsystemBase.DrivetrainSubsystem;
import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class DrivetrainCommand extends CommandBase {

    private final DoubleSupplier doubleSupplierx;
    private final DoubleSupplier doubleSuppliery;
    private final DoubleSupplier doubleSupplierrx;

    DrivetrainSubsystem drivetrainSubsystem;

    public  DrivetrainCommand(DrivetrainSubsystem drivetrainSubsystem, DoubleSupplier doubleSupplierx, DoubleSupplier doubleSuppliery, DoubleSupplier doubleSupplierrx) {
        this.doubleSupplierx = doubleSupplierx;
        this.doubleSuppliery = doubleSuppliery;
        this.doubleSupplierrx = doubleSupplierrx;
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);

    }

    public void initialize() {

    }

    public  void execute(){
            double x = doubleSupplierx.getAsDouble();
            double y = doubleSuppliery.getAsDouble();
            double rx = doubleSupplierrx.getAsDouble();
            drivetrainSubsystem.drive(x, y, rx);



    }
    public boolean isFinished() {
        return false;
    }

}
