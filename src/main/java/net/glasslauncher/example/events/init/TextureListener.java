package net.glasslauncher.example.events.init;

import net.modificationstation.stationapi.api.client.event.texture.TextureRegister;
import net.modificationstation.stationapi.api.client.texture.TextureFactory;
import net.modificationstation.stationapi.api.client.texture.TextureRegistry;
import net.modificationstation.stationapi.api.common.event.EventListener;

public class TextureListener {

    @EventListener
    public void registerTextures(TextureRegister event) {
        ItemListener.coolItem.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/examplemod/textures/coolItem.png"));
    }
}
