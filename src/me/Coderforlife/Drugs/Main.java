package me.Coderforlife.Drugs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Items(this), this);
	    this.getCommand("drugs").setExecutor(new KillerCommands(this));
		//Weed
		ItemStack weed1 = new ItemStack(Material.WHEAT);
		ItemMeta weedMeta = weed1.getItemMeta();
		weedMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		weedMeta.addItemFlags(new ItemFlag[] {ItemFlag.HIDE_ENCHANTS});
		weedMeta.setDisplayName(ChatColor.DARK_GREEN + ""
				+ ChatColor.BOLD + "WEED");
		ArrayList<String> weedLore = new ArrayList<String>();
		weedLore.add(ChatColor.GRAY + "" + 
				ChatColor.ITALIC + "Right-Click to get " + 
				ChatColor.RESET + "" +
		        ChatColor.DARK_RED + "" +
				ChatColor.BOLD + "LIT!!");
		weedLore.add(ChatColor.GREEN + "" + 
				ChatColor.BOLD + "Effects:");
		weedLore.add(ChatColor.GRAY + "- " +
				ChatColor.GOLD + "SLOWNESS");
		weedLore.add(ChatColor.GRAY + "- " + 
				ChatColor.GOLD + "LUCK");
		weedLore.add(ChatColor.DARK_RED +
			  "" +ChatColor.BOLD + "Duration: " 
				+ ChatColor.GOLD + "45 Seconds");
		weedLore.add(ChatColor.GRAY + "" + 
				ChatColor.UNDERLINE + "More Effects coming soon.");
		weedMeta.setLore(weedLore);
		weed1.setItemMeta(weedMeta);
		ShapedRecipe weed = new ShapedRecipe(
				new NamespacedKey (this, "drug_wheat-weed"
				), new ItemStack(weed1));
		
		weed.shape("WDW"," D ","WWW");
		weed.setIngredient('W', Material.WHEAT);
		weed.setIngredient('D', Material.DIAMOND);
		Bukkit.addRecipe(weed);
		//END OF WEED
		
		//COKE
		ItemStack coke = new ItemStack(Material.SUGAR);
		ItemMeta cokeMeta = coke.getItemMeta();
		cokeMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		cokeMeta.addItemFlags(new ItemFlag[] {ItemFlag.HIDE_ENCHANTS});
		cokeMeta.setDisplayName(ChatColor.AQUA +
		"" + ChatColor.BOLD + "COKE");
		
		ArrayList<String> cokeLore = new ArrayList<String>();
		cokeLore.add(ChatColor.GRAY + "" + 
		ChatColor.ITALIC + "Right-Click to get " + ChatColor.DARK_RED + "" 
				+ ChatColor.BOLD + "LIT!!");
		cokeLore.add(ChatColor.GREEN + "" + 
				ChatColor.BOLD + "Effects:");
		cokeLore.add(ChatColor.GRAY + "- " +
				ChatColor.GOLD + "SPEED");
		cokeLore.add(ChatColor.GRAY + "- " +
				ChatColor.GOLD + "GLOWING");
		cokeLore.add(ChatColor.GRAY + "- "
				 + ChatColor.GOLD + "FAST DIGGING");
		cokeLore.add(ChatColor.DARK_RED + ""
				 + ChatColor.BOLD + "Duration: " +
				ChatColor.GOLD + "45 Seconds");
		cokeLore.add(ChatColor.GRAY + "" + 
				ChatColor.UNDERLINE + "More Effects coming soon.");
		cokeMeta.setLore(cokeLore);
		coke.setItemMeta(cokeMeta);
		ShapedRecipe coke1 = new ShapedRecipe(new NamespacedKey (this, "drugs_coke_sugar"), new ItemStack(coke));
		coke1.shape("SSS","SBS","SSS");
		coke1.setIngredient('S', Material.SUGAR);
		coke1.setIngredient('B', Material.WATER_BUCKET);
		Bukkit.addRecipe(coke1);
		//END OF COKE
		
		//HEROIN
		ItemStack heroin = new ItemStack(Material.WITHER_ROSE);
		ItemMeta heroinMeta = heroin.getItemMeta();
		heroinMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		heroinMeta.addItemFlags(new ItemFlag[] {ItemFlag.HIDE_ENCHANTS});
		heroinMeta.setDisplayName(ChatColor.BLACK + "" +
		ChatColor.MAGIC + "HEROINHEROIN");
		ArrayList<String> heroinLore = new ArrayList<String>();
		heroinLore.add(ChatColor.GRAY + "" + 
		ChatColor.ITALIC + "Right-Click to get " +
				ChatColor.DARK_RED + "" + 
		ChatColor.BOLD + "LIT!!");
		heroinLore.add(ChatColor.GREEN + "" + 
		ChatColor.BOLD + "Effects:");
		heroinLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "WEAKNESS");
		heroinLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "SLOW");
		heroinLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "UNLUCK");
		heroinLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "POISON");
		heroinLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "BAD OMEN");
		heroinLore.add(ChatColor.GRAY + "" + 
				ChatColor.UNDERLINE + "More Effects coming soon.");
		
		heroinMeta.setLore(heroinLore);
		heroin.setItemMeta(heroinMeta);
		ShapedRecipe heroin1 = new ShapedRecipe(new NamespacedKey(this, "drugs_heroin-wither/rose"), new ItemStack(heroin));
		heroin1.shape("DRR"," DW"," D ");
		heroin1.setIngredient('D', Material.DIRT);
		heroin1.setIngredient('R', Material.RED_MUSHROOM);
		heroin1.setIngredient('W', Material.WOODEN_SWORD);
		Bukkit.addRecipe(heroin1);
		//END OF HEROIN
		
		//PERCOCET
		ItemStack percocet = new ItemStack(Material.PUMPKIN_SEEDS);
		ItemMeta percocetMeta = heroin.getItemMeta();
		percocetMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		percocetMeta.addItemFlags(new ItemFlag[] {ItemFlag.HIDE_ENCHANTS});
		percocetMeta.setDisplayName(ChatColor.WHITE + "" +
		ChatColor.BOLD + "PERCOCET");
		ArrayList<String> percocetLore = new ArrayList<String>();
		percocetLore.add(ChatColor.GRAY + "" + 
		ChatColor.ITALIC + "Right-Click to get " +
				ChatColor.DARK_RED + "" + 
		ChatColor.BOLD + "LIT!!");
		percocetLore.add(ChatColor.GREEN + "" + 
		ChatColor.BOLD + "Effects:");
		percocetLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "CONFUSION");
		percocetLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "SLOW");
		percocetLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "LUCK");
		percocetLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "GLOWING");
		percocetLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "NIGHT VISION");
		percocetLore.add(ChatColor.GRAY + "- " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "THIS HITS DIFFERENT");
		percocetLore.add(ChatColor.GRAY + "" + 
				ChatColor.UNDERLINE + "More Effects coming soon.");
		
		percocetMeta.setLore(percocetLore);
		percocet.setItemMeta(percocetMeta);
		ShapedRecipe percocet1 = new ShapedRecipe(new NamespacedKey(this, "drugs_percocet-melon/seeds"), new ItemStack(percocet));
		percocet1.shape("AAA","MDM","AAA");
		percocet1.setIngredient('M', Material.MILK_BUCKET);
		percocet1.setIngredient('A', Material.ARROW);
		percocet1.setIngredient('D', Material.WHITE_DYE);
		Bukkit.addRecipe(percocet1);
		//END OF PERCOCET
		
		//ACID				
		 ItemStack acid = new ItemStack(Material.PAPER);
		 ItemMeta acidMeta = acid.getItemMeta();
		 acidMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			acidMeta.addItemFlags(new ItemFlag[] {ItemFlag.HIDE_ENCHANTS});
			acidMeta.setDisplayName(ChatColor.AQUA + "" +
			ChatColor.BOLD + "ACID");
			ArrayList<String> acidLore = new ArrayList<String>();
			acidLore.add(ChatColor.GRAY + "" + 
			ChatColor.ITALIC + "Right-Click to get " +
						ChatColor.DARK_RED + "" + 
			ChatColor.BOLD + "LIT!!");
			acidLore.add(ChatColor.GREEN + "" + 
			ChatColor.BOLD + "Effects:");
			acidLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "CONFUSION");
			acidLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "GLOWING");
			acidLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "HEALTH BOOST");
			acidLore.add(ChatColor.GRAY + "- " + ChatColor.GOLD + "SLOW FALLING");
			acidLore.add(ChatColor.GRAY + "- " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "THIS HITS DIFFERENT");
			acidLore.add(ChatColor.GRAY + "" + 
					   ChatColor.UNDERLINE + "More Effects coming soon.");
				
			acidMeta.setLore(acidLore);
			acid.setItemMeta(acidMeta);
			ShapedRecipe acid1 = new ShapedRecipe(new NamespacedKey(this, "drugs_acid-paper"), new ItemStack(acid));
			acid1.shape("SPS","PWP","SPS");
			acid1.setIngredient('P', Material.PAPER);
			acid1.setIngredient('W', Material.WATER_BUCKET);
			acid1.setIngredient('S', Material.SPIDER_EYE);
			Bukkit.addRecipe(acid1);
			//END OF ACID
		
	}
	
	
	@Override
	public void onDisable() {
		
	}
}
