package net.glasslauncher.example.events.init;

import net.glasslauncher.example.events.ingame.ExamplePlayerHandler;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.entity.player.PlayerEvent;

public class PlayerHandlerListener {

    @EventListener
    public void registerPlayerHandlers(PlayerEvent.HandlerRegister event) {
        event.playerHandlers.add(new ExamplePlayerHandler());
    }
}
