package com.example;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(StarWars.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.SUSPICIOUS_SUBSTANCE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.LIGHTSABER));
    }
    public static final Consumable NUT_CUBE_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            // The duration is in ticks, 20 ticks = 1 second
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION, 300 * 20, 255), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.STRENGTH, 300 * 20, 1), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 300 * 20, 1), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 300 * 20, 3), 1.0f))




            .build();
    public static final FoodProperties NUT_CUBE_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .build();
    public static final Item NUT_CUBE = register(
            "nut_cube",
            Item::new,
            new Item.Properties().food(NUT_CUBE_COMPONENT, NUT_CUBE_CONSUMABLE_COMPONENT)
    );
    public static final TagKey<Item> REPAIRS_CLONE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(StarWars.MOD_ID, "repairs_clone_armor"));
    public static final ToolMaterial STAR_WARS_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            1000000000,
            5.0F,
            1.5F,
            1,
            null    );
    public static final ToolMaterial DIOXIS_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            1,
            5.0F,
            1000000000f,
            1,
            null
    );

    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Properties());
    public static final Item LIGHTSABER = register(
            "lightsaber",
            Item::new,
            new Item.Properties().sword(STAR_WARS_TOOL_MATERIAL, 56f, 1f)
    );
    public static final Item DIOXIS = register(
            "dioxis",
            Item::new,
            new Item.Properties().sword(DIOXIS_MATERIAL, 1000000000f, 1f)
    );
    public static final Item SHOCK_BATON = register(
            "shock_baton",
            ShockBaton::new,
            new Item.Properties().sword(STAR_WARS_TOOL_MATERIAL, 3f, 1f)
    );


    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(StarWars.MOD_ID, "creative_tab")
    );

    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.LIGHTSABER))
            .title(Component.translatable("creativeTab.star-wars"))
            .displayItems((params, output) -> {
                output.accept(ModItems.SUSPICIOUS_SUBSTANCE);
                output.accept(ModItems.DIOXIS);
                output.accept(ModItems.LIGHTSABER);
                output.accept(ModItems.NUT_CUBE);
                output.accept(ModItems.SHOCK_BATON);




            })
            .build();

}