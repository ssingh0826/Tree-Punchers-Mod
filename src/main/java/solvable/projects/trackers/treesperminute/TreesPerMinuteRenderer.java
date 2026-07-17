package solvable.projects.trackers.treesperminute;

import net.minecraft.client.Minecraft;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.gui.Font;
import net.minecraft.resources.Identifier;

import solvable.projects.TreePuncherMod;
import solvable.projects.hud.HudEditor;

public class TreesPerMinuteRenderer {
    private static final Identifier ID = Identifier.tryParse("treepunchermod:trees_per_minute_tracker");

    private static final int TEXT_COLOR = 0xFF38823C; // #38823c
    private static final int BACKGROUND = 0x80000000; // 50% transparent black

    public static void register(TreesPerMinute tracker) {
        HudElementRegistry.addLast(ID, (guiGraphics, renderTickCounter) -> {

            Minecraft client = Minecraft.getInstance();

            if (client.player == null) return;

            if (!tracker.isActive()) return;

            if (!HudEditor.isEditing()) {
                Font renderer = Minecraft.getInstance().font;

                String text = "Trees per Minute: " + tracker.getTreeGiftsPerMinute();

                int x = TreePuncherMod.CONFIG.tpmTrackerHudX();
                int y = TreePuncherMod.CONFIG.tpmTrackerHudY();
                int padding = 3;

                int width = renderer.width(text);
                int height = renderer.lineHeight;

                guiGraphics.fill(x - padding, y - padding, x + width + padding, y + height + padding, BACKGROUND);

                guiGraphics.text(renderer, text, x, y, TEXT_COLOR, false);
            }
            else {
                Font renderer = Minecraft.getInstance().font;

                String text = "Trees per Minute: 9001";

                int x = TreePuncherMod.CONFIG.tpmTrackerHudX();
                int y = TreePuncherMod.CONFIG.tpmTrackerHudY();
                int padding = 3;

                int width = renderer.width(text);
                int height = renderer.lineHeight;

                guiGraphics.fill(x - padding, y - padding, x + width + padding, y + height + padding, BACKGROUND);

                guiGraphics.text(renderer, text, x, y, TEXT_COLOR, false);
            }
        });
    }

}
