package net.glasslauncher.example.events.init;

import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.mod.Init;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;
import org.apache.logging.log4j.Logger;

public class ServerInitListener {

    @Entrypoint.ModID
    private static final ModID MOD_ID = Null.get();

    @Entrypoint.Logger
    private static final Logger LOGGER = Null.get();

    @EventListener
    private static void serverInit(Init event) {
        LOGGER.error(MOD_ID.toString());
    }
}
