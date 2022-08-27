package me.xemu.warden;

import me.xemu.warden.structure.Cuboid;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Claim {

	private int id;
	private UUID owner;
	private List<UUID> trustedPlayers;
	private Cuboid cuboid;

	public Claim(UUID owner, List<UUID> trustedPlayers, Cuboid cuboid) {
		this.id = WardenPlugin.getCurrentClaimId() + 1;

		this.owner = owner;
		this.trustedPlayers = trustedPlayers;
		this.cuboid = cuboid;

		cuboid.serialize();
	}

	public void setClaim(Location l1, Location l2) {
		this.cuboid = new Cuboid(l1, l2);
	}





}
