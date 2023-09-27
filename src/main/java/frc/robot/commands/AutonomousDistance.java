// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import java.util.ArrayList;

public class AutonomousDistance extends SequentialCommandGroup {
  private ArrayList<Runnable> commandQueue;
  private Drivetrain m_drivetrain;

  private double straightSpeed = 0.5;
  private double turnDegrees = 65;
  private double turnSpeed = 0.5;
  private double driveDistance = 10;
  private double triangleTurnDegrees = 90;
  private double hexagonTurnDegrees = 40;
  private double hexagonInfinityDrivingDistance = 5;
  private double InfinityTurnDegrees = 60;

  public AutonomousDistance(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    commandQueue = new ArrayList<Runnable>();
    commandQueue.add(this::squarePattern);
    commandQueue.add(this::trianglePattern);
    commandQueue.add(this::hexagonPattern);
    commandQueue.add(this::octagonPattern);
    System.out.println(commandQueue.toString());
  }

  public void runCommandQueue() {
    for (Runnable command : commandQueue) {
      command.run();
    }
  }

  public void squarePattern() {
    for (int i = 0; i < 4; i++) {
      new DriveDistance(-straightSpeed, driveDistance, m_drivetrain);
      new TurnDegrees(turnSpeed, turnDegrees, m_drivetrain);
    }
  }

  public void trianglePattern() {
    for (int i = 0; i < 3; i++) {
      new DriveDistance(-straightSpeed, driveDistance, m_drivetrain);
      new TurnDegrees(turnSpeed, triangleTurnDegrees, m_drivetrain);
    }
  }

  public void hexagonPattern() {
    for (int i = 0; i < 6; i++) {
      new DriveDistance(-straightSpeed, driveDistance, m_drivetrain);
      new TurnDegrees(turnSpeed, hexagonTurnDegrees, m_drivetrain);
    }
  }

  public void octagonPattern() {
    for (int i = 0; i < 8; i++) {
      new DriveDistance(-straightSpeed, driveDistance, m_drivetrain);
      new TurnDegrees(turnSpeed, turnDegrees, m_drivetrain);
    }
  }


        // Square
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, turnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, turnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, turnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, turnDegrees, drivetrain),

        // Triangle
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, triangleTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, triangleTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, driveDistance, drivetrain),
        // new TurnDegrees(turnSpeed, triangleTurnDegrees, drivetrain),

        // Hexagon
        // new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        // new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        // new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        // new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        // new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        // new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain),
        // new DriveDistance(-straightSpeed, hexagonInfinityDrivingDistance, drivetrain),
        // new TurnDegrees(turnSpeed, hexagonTurnDegrees, drivetrain));
}