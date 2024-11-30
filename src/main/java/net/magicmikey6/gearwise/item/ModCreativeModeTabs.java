package net.magicmikey6.gearwise.item;

import net.magicmikey6.gearwise.GearWise;
import net.magicmikey6.gearwise.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GearWise.MOD_ID);

    public static final Supplier<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TABS.register("items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BASIC_MECHANISM.get()))
                    .title(Component.translatable("creativetab.gearwise.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.BASIC_MECHANISM);

                    }).build());

    public static final Supplier<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BASIC_MACHINE_CASING))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GearWise.MOD_ID, "items_tab"))
                    .title(Component.translatable("creativetab.gearwise.blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.BASIC_MACHINE_CASING);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
