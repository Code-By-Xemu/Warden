package me.xemu.warden.structure;

import me.xemu.warden.WardenPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerMessage {

	private String string;
	private boolean colors;

	public PlayerMessage(String string, boolean colors) {
		this.string = string;
		this.colors = colors;
	}

	public String getMessage() {
		if (colors) {
			return ChatColor.translateAlternateColorCodes('&', string);
		}
		return string;
	}

	public void broadcast() {
		WardenPlugin.getInstance().getServer().getOnlinePlayers().stream().forEach(player -> {
			player.sendMessage(getMessage());
		});
	}

	public void broadcast(String permission) {
		WardenPlugin.getInstance().getServer().getOnlinePlayers().stream().forEach(player -> {
			if (player.hasPermission(permission)) {
				player.sendMessage(getMessage());
			}
		});
	}

	public void console() {
		WardenPlugin.getInstance().getServer().getConsoleSender().sendMessage(getMessage());
	}

	public void send(Player player) {
		player.sendMessage(getMessage());
	}

	public void send(UUID uuid) {
		WardenPlugin.getInstance().getServer().getPlayer(uuid).sendMessage(getMessage());
	}
}
