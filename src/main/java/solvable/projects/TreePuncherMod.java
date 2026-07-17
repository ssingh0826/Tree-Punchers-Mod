package solvable.projects;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import solvable.projects.config.TPMConfig;
import solvable.projects.trackers.treesperminute.TreesPerMinute;
import solvable.projects.trackers.treesperminute.TreesPerMinuteRenderer;

public class TreePuncherMod implements ModInitializer {

	public static final String MOD_ID = "treepunchermod";
	public static final TPMConfig CONFIG = TPMConfig.createAndLoad();
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TreesPerMinute TREES_PER_MINUTE = new TreesPerMinute();

	@Override
	public void onInitialize() {

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			TREES_PER_MINUTE.tick();
		});
		TreesPerMinuteRenderer.register(TREES_PER_MINUTE);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
