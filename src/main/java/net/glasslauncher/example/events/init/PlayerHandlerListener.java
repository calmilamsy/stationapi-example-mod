package net.glasslauncher.example.events.init;

import net.glasslauncher.example.events.ingame.ExamplePlayerHandler;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.entity.player.PlayerHandlerRegister;

public class PlayerHandlerListener {

    @EventListener
    public void registerPlayerHandlers(PlayerHandlerRegister event) {
        event.playerHandlers.add(new ExamplePlayerHandler());
    }
}
