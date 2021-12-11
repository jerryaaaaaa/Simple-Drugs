package me.Coderforlife.Drugs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import me.Coderforlife.Drugs.Events.PlayerJoin;

public class KillerCommands implements CommandExecutor {

	private Main plugin;

	public KillerCommands(Main plugin, Drugs D) {
		this.setPlugin(plugin);
		this.D = D;
	}

	PlayerJoin pj = new PlayerJoin();
	Drugs D;

	public Main getPlugin() {
		return this.plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	public static String dash = ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "- ";
	public static String header = ChatColor.translateAlternateColorCodes('&',
			"&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&f&l[&4&o&lSIMPLE DRUGS&f&l]"
			+ "&8&l&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=&0&l=&8&l=");

	public boolean onCommand(CommandSender sender, Command command, String Commandlabel, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("drugs.main")) {
				if (args.length == 0) {
					p.sendMessage(header);
					p.sendMessage( 
							ChatColor.translateAlternateColorCodes('&', 
									"&7&o&nComandi:"));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', 
									"&7- &f/drugs help &8| &fAiuto."));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', 
									"&7- &f/drugs list &8| &fLista."));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', 
									"&7- &f/drugs soberup &e[player] &8| &fRendi sobrio qualcuno."));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', 
									"&7- &f/drugs bagofdrugs &e[player] &8| &fDai lo zainetto a qualcuno."));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&',
									"&7- &f/drugs give &a<droga> &e[player] &8| &fVendi droga a qualcuno."));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&',
									"&7- &f/drugs version &8| &fVedi versione."));
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', 
									"&7- &f/drugs reload &8| &fReload dei config."));
					/*
					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', 
									"&7- &f/drugs sell &8| &fSells the Drug in your hand."));
									*/
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {
						if (p.hasPermission("drugs.help")) {
							p.sendMessage(header);
							p.sendMessage(Main.prefix + "Crafta la droga e premi il tasto destro per assumerla.");
							p.sendMessage(Main.prefix + "Trovi i craft digitando");
							p.sendMessage("/droghe");
						} else {
							p.sendMessage(
									Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(
									Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.RED + "drugs.help");
						}
					} else if (args[0].equalsIgnoreCase("soberup")) {
						if (p.hasPermission("drugs.soberup")) {
							if (!p.getActivePotionEffects().isEmpty()) {
								for (PotionEffect effect : p.getActivePotionEffects()) {
									p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&a&lE' FINITA LA BOTTA"),
											ChatColor.translateAlternateColorCodes('&', "&l&Un vero uomo non molly mai..."), 10, 4 * 20,
											10);
									p.playSound(p.getLocation(), Sound.BLOCK_BELL_RESONATE, 1, 2);
									p.removePotionEffect(effect.getType());
								}
							} else {
								p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1, (float) 0.2);
								// Text | SubText | FadeIn | Stay | FadeOut
								p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&c&lSEI GIA' SOBRIO"),
										ChatColor.translateAlternateColorCodes('&', "&f&oProcurati della droga"), 10,
										4 * 20, 10);
							}
						} else {
							p.sendMessage(
									Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.RED
									+ "drugs.soberup");
						}
					} else if (args[0].equalsIgnoreCase("list")) {
						if (p.hasPermission("drugs.list")) {
							p.sendMessage(header);
							for (Drug drug : D.getAllDrugs()) {
								p.sendMessage(dash + drug.getDisplayName());
							}

						} else {
							p.sendMessage(
									Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(
									Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.RED + "drugs.list");
						}

					} else if (args[0].equalsIgnoreCase("bagofdrugs")) {
						if (p.hasPermission("drugs.command.bagofdrugs")) {
							if (!p.getInventory().contains(pj.bag)) {
								p.sendMessage(Main.prefix + ChatColor.GRAY + "Zainetto della droga ricevuto");
								p.getInventory().addItem(pj.bag);
							} else {
								p.sendMessage(Main.prefix + ChatColor.RED + "Hai già uno zainetto della droga");
							}
						} else {
							p.sendMessage(
									Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.RED
									+ "drugs.command.bagofdrugs");
						}
					} else if (args[0].equalsIgnoreCase("reload")) {
						if (p.hasPermission("drugs.reload")) {
							p.sendMessage(header);
							p.sendMessage(Main.prefix + "Aggiornamento...");
							try {
								plugin.drugsConfig.load(plugin.drugsConfigFile);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (InvalidConfigurationException e) {
								e.printStackTrace();
							}
							p.sendMessage(Main.prefix + "Aggiornamento eseguito...");
						} else {
							p.sendMessage(
									Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(
									Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.RED + "drugs.reload");
						}
					}else if(args[0].equalsIgnoreCase("sell")) {
						p.sendMessage(Main.prefix + 
								ChatColor.translateAlternateColorCodes('&', 
										"&eNon ancora implementato."));
					}else if(args[0].equalsIgnoreCase("version")) {
						if(p.hasPermission("drugs.version")) {
							p.sendMessage(header);
							p.sendMessage(Main.prefix + 
									ChatColor.translateAlternateColorCodes('&', 
											"&4&oVersionen:&f " + plugin.getDescription().getVersion()));
						}
					}
				} else if (args.length == 2) {
					if (args[0].equalsIgnoreCase("bagofdrugs")) {
						if (p.hasPermission("drugs.command.bagofdrugs.others")) {
							for (final Player players : Bukkit.getOnlinePlayers()) {
								if (args[1].equalsIgnoreCase(players.getName())) {
									if (players.isOnline()) {
										if (players.getInventory().contains(this.pj.bag)) {
											p.sendMessage(String.valueOf(Main.prefix) + ChatColor.GRAY
													+ players.getDisplayName() + " Ha già uno zainetto");
										} else {
											p.sendMessage(String.valueOf(Main.prefix) + ChatColor.GRAY + "Hai inviato "
													+ players.getDisplayName() + " a " + BagOfDrugs.bagName);
											players.getInventory().addItem(new ItemStack[] { this.pj.bag });
											players.sendMessage(String.valueOf(Main.prefix) + ChatColor.GRAY
													+ p.getDisplayName() + " Ti ha mandato " + BagOfDrugs.bagName);
										}
									} else {
										p.sendMessage(String.valueOf(Main.prefix) + ChatColor.GRAY
												+ "Player citato offline.");
									}
								} else {
									p.sendMessage(String.valueOf(Main.prefix) + ChatColor.GRAY
											+ "Player citato inesistente.");
								}
							}
						} else {
							p.sendMessage(String.valueOf(Main.prefix) + ChatColor.RED
									+ "Non puoi usare questo comando.");
							p.sendMessage(String.valueOf(Main.prefix) + ChatColor.DARK_RED + "Permesso: "
									+ ChatColor.GRAY + "drugs.command.bagofdrugs.others");
						}
					} else if (args[0].equalsIgnoreCase("soberup")) {
						if (p.hasPermission("drugs.soberup.others")) {
							for (final Player players : Bukkit.getOnlinePlayers()) {
								if (args[1].equalsIgnoreCase(players.getName())) {
									if (players.isOnline()) {
										if (!players.getActivePotionEffects().isEmpty()) {
											for (final PotionEffect effect2 : p.getActivePotionEffects()) {
												players.removePotionEffect(effect2.getType());
											}
											p.sendMessage(String.valueOf(Main.prefix) + ChatColor.GRAY
													+ "Hai reso sobrio " + players.getDisplayName());
											players.sendTitle(
													ChatColor.translateAlternateColorCodes('&', "&a&lE' FINITA LA BOTTA"),
													ChatColor.translateAlternateColorCodes('&', "&l&e&l&Un vero uomo non molly mai..."), 10,
													4 * 20, 10);
											players.playSound(p.getLocation(), Sound.BLOCK_BELL_RESONATE, 1, 2);
										} else {
											p.sendMessage(Main.prefix + ChatColor.GRAY + p.getDisplayName()
													+ " è sobrio, procuragli della droga.");
										}
									} else {
										p.sendMessage(Main.prefix + ChatColor.GRAY + "Player citato offline");
									}
								} else {
									p.sendMessage(Main.prefix + ChatColor.GRAY + "Player citato inesistente.");
								}
							}
						} else {
							p.sendMessage(
									Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.DARK_GRAY
									+ "drugs.soberup.others");
						}
					} else if (args[0].equalsIgnoreCase("give")) {
						if (p.hasPermission("drugs.give")) {
							for (Drug drugs : D.getAllDrugs()) {
								if (args[1].equalsIgnoreCase(drugs.getName())) {
									p.getInventory().addItem(drugs.getDrugItem());
									p.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', 
											"&7Ecco a te: "  + drugs.getDisplayName()));
								} else {

								}
							}
						} else {

						}
					}
				} else if (args.length == 3) {
					if (args[0].equalsIgnoreCase("give")) {
						if (p.hasPermission("durgs.give.others")) {
							for (Drug drugs : D.getAllDrugs()) {
								if (args[1].equalsIgnoreCase(drugs.getName())) {
									for (Player players : Bukkit.getOnlinePlayers()) {
										if (args[2].equalsIgnoreCase(players.getName())) {
											p.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', 
													"Hai inviato "  + players.getName() + " " + drugs.getDisplayName()));
											players.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', 
													p.getDisplayName() + " Ti ha inviato del " + drugs.getDisplayName()));
											players.getInventory().addItem(drugs.getDrugItem());
										}else {
											p.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', 
													args[2] + " &cnon è un player"));
										}
									}
												}
							}
						     }else {
							p.sendMessage(Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
							p.sendMessage(Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.DARK_GRAY
									+ "drugs.give.others");
						}
					}	 
				} else if (args.length > 3) {
					p.sendMessage(Main.prefix + "Non usare " + args[4]);
				}
			} else {
				p.sendMessage(Main.prefix + ChatColor.RED + "Non puoi usare questo comando.");
				p.sendMessage(Main.prefix + ChatColor.DARK_RED + "Permesso: " + ChatColor.RED + "drugs.main");
			}
		} else if (args.length == 0) {
			sender.sendMessage("Solo /drugs reload funziona sulla console");
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				Bukkit.getServer().getConsoleSender()
						.sendMessage(String.valueOf(Main.prefix) + ChatColor.GREEN + "Sto ricaricando il config...");
				try {
					this.plugin.drugsConfig.load(this.plugin.drugsConfigFile);
				} catch (FileNotFoundException e4) {
					e4.printStackTrace();
				} catch (IOException e5) {
					e5.printStackTrace();
				} catch (InvalidConfigurationException e6) {
					e6.printStackTrace();
				}
				Bukkit.getServer().getConsoleSender()
						.sendMessage(String.valueOf(Main.prefix) + ChatColor.GREEN + "Config ricaricato.");
			} else if (args[0].length() >= 2) {
				final Random sev = new Random();
				final int ef = sev.nextInt(4);
				if (ef == 1) {
					Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(Main.prefix) + ChatColor.GREEN
							+ "//");
				}
				if (ef == 2) {
					Bukkit.getServer().getConsoleSender()
							.sendMessage(String.valueOf(Main.prefix) + ChatColor.GREEN + "Fermati perfavore");
				}
				if (ef == 3) {
					final Logger log = Bukkit.getLogger();
					log.severe("Server offline");
					log.severe("Unloading all plugins...");
					log.severe("Invio i tuoi dati al governo...");
					log.severe("Deleting all files and cookies...");
					log.severe("Hacking all players data");
					log.severe("*cough* *cough* non dovevo farlo");
					log.severe("Installing CCLEANER...");
					Bukkit.getServer().getConsoleSender()
							.sendMessage(String.valueOf(Main.prefix) + ChatColor.GREEN + "jK LOL");
				}
				if (ef == 4) {
					Bukkit.getServer().getConsoleSender().sendMessage(
							String.valueOf(Main.prefix) + ChatColor.GREEN + "Sei veramente noioso, drogati.");
				}
			}
		}
		return true;
	}

}
