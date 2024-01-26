package org.example.kot.fed;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fed extends JavaPlugin {

    public static Economy economy;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ChatColor.RED + "폴라리스 금융전상망이 작동합니다!");

        this.getCommand("금융").setExecutor(new Main());

        //this.getCommand("금융").setExecutor(new Main());

        // Vault 플러그인 연동 로직
        if (!setupEconomy()){
            Bukkit.shutdown();
        }

    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
