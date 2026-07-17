package solvable.projects.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.ExcludeFromScreen;
import io.wispforest.owo.config.annotation.Modmenu;

@Modmenu(modId = "treepunchermod")
@Config(name = "config", wrapperName = "TPMConfig")
public class ConfigModel {

    public boolean tpmTracker = false;
    public int tpmTimeoutSeconds = 20;
    @ExcludeFromScreen
    public int tpmTrackerHudX = 5;
    @ExcludeFromScreen
    public int tpmTrackerHudY = 5;
}
