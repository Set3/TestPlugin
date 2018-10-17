package xyz.set3.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.set3.RPGCmdManager.CmdManager;

public class TestPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		CmdManager.registerCommand(this, "poke", new CommandEx(), new TabComplete(), null, "Poke a player!", "testplugin.poke", "/<command> <username>");
	}

}
