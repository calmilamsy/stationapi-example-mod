package net.glasslauncher.example.events.init;

import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.item.ItemRegister;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;

public class ItemListener {

    public static ItemBase coolItem;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerItems(ItemRegister event) {
        coolItem = new net.modificationstation.stationapi.template.common.item.ItemBase(Identifier.of(MOD_ID, "coolitem")).setTranslationKey(MOD_ID, "coolitem");
    }
}
