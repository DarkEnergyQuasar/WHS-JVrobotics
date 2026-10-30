package org.firstinspires.ftc.teamcode.TeleOps;

//import com.qualcomm.robotcore.eventloop.opmode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MotorTest extends LinearOpMode {
    //Teleop bob = new Teleop();
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    // motor4 doesn't exist yet, it's for the intake system.
    // servo1 and color1 also don't exist right now.
    private DcMotor motor4;
    private Servo servo1;
    private ColorSensor color1;

    @Override
    public void runOpMode() throws InterruptedException{
        motor0=hardwareMap.get(DcMotor.class,"front left");
        motor1=hardwareMap.get(DcMotor.class,"back left");
        motor2=hardwareMap.get(DcMotor.class,"front right");
        motor3=hardwareMap.get(DcMotor.class,"back right");
        //motor4=hardwareMap.get(DcMotor.class,"intake");

        //servo1=hardwareMap.get(Servo.class,"thing");
        //color1=hardwareMap.get(ColorSensor.class,"???");

        boolean intakeIsOn = false;
        boolean powerMode = false;
        double tgtPower0 = 0;
        double tgtPower1 = 0;
        double tgtPower2 = 0;
        double tgtPower3 = 0;
        double tgtPower4 = 0;
        double tgtPower5 = 0;

        telemetry.addData("Status","Initialized");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Status","Running");
            telemetry.update();

            // setPower() can be from -1 to 1
            //motor0.setPower(0.25);

            // setPosition() for a servo can be from 0 to 1 for most servos,
            // with 0 being 0 degrees and 1 being 180 degrees.

            ////// controller stuff
            // left stick controls forewards/backwards movement, and strafing
            // right stick controls turning
            // for y values, -1 = top position, and 1 = bottom position
            // for x values, -1 = left position, and 1 = right position
            // A button toggles intake
            // X button toggles turbo power (boost forewards movement, but remove straffing)
            // B button extends or retracts ball dispenser

            if(powerMode){
                tgtPower0 = -0.8 * (-this.gamepad1.left_stick_y) - 0.4 * this.gamepad1.right_stick_x;
                tgtPower1 = -0.8 * (-this.gamepad1.left_stick_y) - 0.4 * this.gamepad1.right_stick_x;
                tgtPower2 = -0.8 * (this.gamepad1.left_stick_y) - 0.4 * this.gamepad1.right_stick_x;
                tgtPower3 = -0.8 * (this.gamepad1.left_stick_y) - 0.4 * this.gamepad1.right_stick_x;
            }else{
                tgtPower0 = -0.4 * (-this.gamepad1.left_stick_y + this.gamepad1.left_stick_x) - 0.4 * this.gamepad1.right_stick_x;
                tgtPower1 = -0.4 * (-this.gamepad1.left_stick_y - this.gamepad1.left_stick_x) - 0.4 * this.gamepad1.right_stick_x;
                tgtPower2 = -0.4 * (this.gamepad1.left_stick_y + this.gamepad1.left_stick_x) - 0.4 * this.gamepad1.right_stick_x;
                tgtPower3 = -0.4 * (this.gamepad1.left_stick_y - this.gamepad1.left_stick_x) - 0.4 * this.gamepad1.right_stick_x;
            }

            motor0.setPower(tgtPower0);
            motor1.setPower(tgtPower1);
            motor2.setPower(tgtPower2);
            // motor3 (the back right motor) works, but gets stuck sometimes due to a loose bolt. If the motors get stuck,
            // check all of the bolts on the motors
            motor3.setPower(tgtPower3);

            // toggles the intake motor on and off when the A button is pressed
            if(this.gamepad1.aWasReleased()){
                if(intakeIsOn){
                    intakeIsOn=false;
                    //motor4.setPower(0);
                }else{
                    intakeIsOn=true;
                    //motor4.setPower(0.5);
                }
            }

            // toggles "power mode" when X button is pressed
            if(this.gamepad1.xWasReleased()){
                if(powerMode){
                    powerMode=false;
                }else{
                    powerMode=true;
                }
            }

            // extends or retracts ball dispenser when B button is pressed

            telemetry.addData("M0 Target Power",tgtPower0);
            telemetry.addData("Motor0 Power",motor0.getPower());

            telemetry.addData("M1 Target Power",tgtPower1);
            telemetry.addData("Motor1 Power",motor1.getPower());

            telemetry.addData("M2 Target Power",tgtPower2);
            telemetry.addData("Motor2 Power",motor2.getPower());

            telemetry.addData("M3 Target Power",tgtPower3);
            telemetry.addData("Motor3 Power",motor3.getPower());

            telemetry.addData("intake is on",intakeIsOn);
            //telemetry.addData("Intake Power",motor4.getPower());

            telemetry.addData("turbo power mode",powerMode);

            //telemetry.addData("ball dispenser extension",???)

            // setVelocity() sets the RPM (I think)
            // setVelocity() is only available for DcMotorEx
            //motor0.setVelocity(200);

            // setPosition() (for servos) can be from 0 to 1
            //servo1.setPosition(1);
            //servo1.getPosition();

            // returns the amount of blue color detected
            // this also works for other colors
            //double num1 = color1.blue();
        }
    }
}
