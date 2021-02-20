package net.glasslauncher.example.events.ingame;

import net.modificationstation.stationapi.api.common.entity.player.PlayerHandler;

public class ExamplePlayerHandler implements PlayerHandler {

    @Override
    public boolean respawn() {
        System.out.println("Oh noes");
        return false;
    }


}
