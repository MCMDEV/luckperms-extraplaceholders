package de.mcmdev.luckpermsextraplaceholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.PrefixNode;
import net.luckperms.api.node.types.SuffixNode;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExpansionLuckpermsextra extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "luckpermsx";
    }

    @Override
    public @NotNull String getAuthor() {
        return "MCMDEV";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public @Nullable String getRequiredPlugin() {
        return "LuckPerms";
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        LuckPerms luckPerms = LuckPermsProvider.get();

        if (params.equalsIgnoreCase("prefix_weight")) {
            User user = luckPerms.getUserManager().getUser(player.getUniqueId());
            if(user == null) return null;
            PrefixNode prefixNode = user.getCachedData().getMetaData().queryPrefix().node();
            if(prefixNode == null) return null;
            return String.valueOf(prefixNode.getPriority());
        }

        if (params.equalsIgnoreCase("suffix_weight")) {
            User user = luckPerms.getUserManager().getUser(player.getUniqueId());
            if(user == null) return null;
            SuffixNode suffixNode = user.getCachedData().getMetaData().querySuffix().node();
            if(suffixNode == null) return null;
            return String.valueOf(suffixNode.getPriority());
        }

        return null;
    }
}
