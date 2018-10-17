package xyz.set3.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.set3.RPGCmdManager.CmdExecutor;
import me.set3.RPGCmdManager.FailType;

public class CommandEx implements CmdExecutor {

	FailType fail = null;

	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender.hasPermission("testplugin.poke")) {
			if (args.length == 1) {
				String name = "";
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (player.getName().equals(args[0])) {
						name = player.getName();
						break;
					}
				}
				if (!(name.equals(""))) {
					fail = FailType.SUCCESS;
					return true;
				} else {
					fail = FailType.INVALIDARGS;
				}
			} else if (args.length < 1) {
				fail = FailType.NOTENOUGHARGS;
			} else if (args.length > 1) {
				fail = FailType.TOOMANYARGS;
			}
		} else {
			fail = FailType.NOPERMISSION;
		}
		return false;
	}

	public FailType getFailure() {
		return fail;
	}

}
