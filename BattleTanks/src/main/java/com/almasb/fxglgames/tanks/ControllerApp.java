/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package com.almasb.fxglgames.tanks;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.input.virtual.VirtualButton;
import com.almasb.fxgl.input.virtual.VirtualController;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.*;


public class ControllerApp {

    private static ControllerManager controllers;
    private static VirtualController controller;


    public static void init() {
        controllers = new ControllerManager();
        controllers.initSDLGamepad();

        controller = getInput().createXboxVirtualController();
    }

    public static void onUpdate(double tpf) {
        ControllerState currState = controllers.getState(0);

        if (!currState.isConnected) {
            return;
        }

        if (currState.dpadUp) {
            controller.pressVirtual(VirtualButton.UP);
        } else {
            controller.releaseVirtual(VirtualButton.UP);
        }

        if (currState.dpadDown) {
            controller.pressVirtual(VirtualButton.DOWN);
        } else {
            controller.releaseVirtual(VirtualButton.DOWN);
        }

        if (currState.dpadLeft) {
            controller.pressVirtual(VirtualButton.LEFT);
        } else {
            controller.releaseVirtual(VirtualButton.LEFT);
        }

        if (currState.dpadRight) {
            controller.pressVirtual(VirtualButton.RIGHT);
        } else {
            controller.releaseVirtual(VirtualButton.RIGHT);
        }
    }
}
