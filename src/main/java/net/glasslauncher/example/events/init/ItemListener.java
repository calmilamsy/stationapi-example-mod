package net.glasslauncher.example.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    public static Item coolItem;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        coolItem = new TemplateItem(Identifier.of(NAMESPACE, "coolitem")).setTranslationKey(NAMESPACE, "coolitem");
    }
}
