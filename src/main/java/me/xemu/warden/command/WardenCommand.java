package me.xemu.warden.command;

import me.xemu.warden.WardenPlugin;
import me.xemu.warden.structure.PlayerMessage;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class WardenCommand extends BukkitCommand {

	public WardenCommand(String name, String description, String[] aliases) {
		super(name);

		this.setDescription(description);
		this.setAliases(Arrays.asList(aliases));

		try {
			Field field = WardenPlugin.getInstance().getServer().getClass().getDeclaredField("commandMap");
			field.setAccessible(true);
			CommandMap map = (CommandMap) field.get(WardenPlugin.getInstance().getServer());
			map.register(name, this);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			new PlayerMessage("&cFailed running command '" + name + "'. ERROR: " + e.getMessage(), true)
					.console();
		}
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		run(sender, args);
		return false;
	}

	public abstract void run(CommandSender sender, String[] args);

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args)  {
		return onTabComplete(sender, args);
	}

	public abstract List<String> onTabComplete(CommandSender sender, String[] args);

}
