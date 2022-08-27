package me.xemu.warden;

import org.bukkit.plugin.java.JavaPlugin;

public final class WardenPlugin extends JavaPlugin {

	private static WardenPlugin instance;

	private static int CURRENT_CLAIM_ID;
	public static int getCurrentClaimId() {
		return CURRENT_CLAIM_ID;
	}

	public static WardenPlugin getInstance() {
		if (instance == null) {
			throw new NullPointerException("Plugin-Instance has not been defined.");
		}
		return instance;
	}

	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {
	}

}
