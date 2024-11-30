package net.magicmikey6.gearwise.item;

import net.magicmikey6.gearwise.GearWise;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GearWise.MOD_ID);

    public static final DeferredItem<Item> BASIC_MECHANISM = ITEMS.register("basic_mechanism",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
