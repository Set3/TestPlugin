package xyz.set3.testplugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TabComplete implements TabCompleter {

	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> tabComplete = new ArrayList<String>();
		if (sender.hasPermission("testplugin.poke")) {
			if (args.length <= 1) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					tabComplete.add(player.getName());
				}
			}
		} else {
			tabComplete = Arrays.asList("No permission");
		}
		return tabComplete;
	}
}
