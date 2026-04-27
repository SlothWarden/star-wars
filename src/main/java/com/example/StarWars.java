package com.example;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.ModItems.CUSTOM_CREATIVE_TAB;
import static com.example.ModItems.CUSTOM_CREATIVE_TAB_KEY;


public class StarWars implements ModInitializer {
	public static final String MOD_ID = "star-wars";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.initialize();
		LOGGER.info("Hello Fabric world!");

		// Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
				.register((creativeTab) -> creativeTab.accept(ModItems.SUSPICIOUS_SUBSTANCE));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
				.register((creativeTab) -> creativeTab.accept(ModItems.DIOXIS));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
				.register((creativeTab) -> creativeTab.accept(ModItems.LIGHTSABER));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
				.register((creativeTab) -> creativeTab.accept(ModItems.SHOCK_BATON));

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
				.register((creativeTab) -> creativeTab.accept(ModItems.NUT_CUBE));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INVENTORY)
				.register((creativeTab) -> creativeTab.accept(ModItems.SUSPICIOUS_SUBSTANCE));



		// Add the suspicious substance to the registry of fuels, with a burn time of 30 seconds.
// Remember, Minecraft deals with logical based-time using ticks.
// 20 ticks = 1 second.
		FuelValueEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.SUSPICIOUS_SUBSTANCE, 60 * 20);
		});
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);

	}

}