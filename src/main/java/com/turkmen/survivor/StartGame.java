package com.turkmen.survivor;

import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.config.Setup;
import com.turkmen.survivor.persistence.impl.PlayerContainerImpl;
import com.turkmen.survivor.ui.PlayerUI;

import java.util.Scanner;

public class StartGame {


    public static void main(String[] args) {

        String command;
        Scanner sc = new Scanner(System.in);
        Setup setup =GenericBuilder.of(Setup::new).build();

        while (true) {
            System.out.println("****** WELCOME TO WORLD OF SURVIVERS ******");
            System.out.println("type \"regiester\" in order to create a player with a given name......");
            setup.createGame("turkmen");
        }

    }


}
