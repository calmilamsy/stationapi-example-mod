package net.glasslauncher.example.events.init;

import net.modificationstation.stationapi.api.client.event.model.ModelRegister;
import net.modificationstation.stationapi.api.client.model.CustomModel;
import net.modificationstation.stationapi.api.client.model.CustomModelRenderer;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.factory.GeneralFactory;

public class ModelListener {
    public static CustomModel CUSTOM_MODEL;

    @EventListener
    public void registerModels(ModelRegister event) {
        CUSTOM_MODEL = GeneralFactory.INSTANCE.newInst(CustomModelRenderer.class, "/assets/examplemod/stationapi/models/model.json", "examplemod").getEntityModelBase();
    }
}
