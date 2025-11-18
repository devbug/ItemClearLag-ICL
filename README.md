[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1001584?style=for-the-badge&logo=curseforge&logoColor=%230d0d0d&labelColor=%23f16436&color=%230d0d0d)](https://www.curseforge.com/minecraft/mc-mods/itemclearlag) [![Modrinth Downloads](https://img.shields.io/modrinth/dt/NJcJEXNc?style=for-the-badge&logo=modrinth&color=%231bd96a)](https://modrinth.com/mod/itemclearlag)

# ItemClearLag (ICL)

ItemClearLag (ICL) is a Minecraft mod designed to improve server performance by periodically removing items from the ground. This mod is especially useful for servers with high player counts where dropped items can accumulate and cause lag.

## Installation

1. Ensure you have Fabric installed.
2. Download the latest version of ICL from the [releases page](https://github.com/VeiTrr/ItemClearLag-ICL/releases).
3. Place the downloaded .jar file into your `mods` folder.
4. Start your server or game.

## Commands

Write `/icl` in chat to see all available commands.

The main command provided by ICL is `/icl`, which has several subcommands:

- `/icl forceclean`: Immediately clears all items on the ground.
- `/icl reload`: Reloads the ICL.
- `/icl config set <key> [value]`: Changes a configuration value. To see current configuration value, use `/icl config set <key>`.
- `/icl cancel [seconds]`: Cancels the next clear. If a number of seconds is provided, the next clear will be scheduled after that many seconds.

## Configuration

Configuration values can be changed using the `/icl config set` command. Here are some of the configurable values:

- `Delay`: The delay (in seconds) between automatic item clears.
- `NotificationDelay`: The delay (in seconds) before a clear when a notification will be sent.
- `NotificationStart`: The time (in seconds) when notifications start being sent before a clear.
- `NotificationTimes`: The number of notifications to send before a clear.
- `CountdownStart`: The time (in seconds) when the countdown starts before a clear.
- `doNotificationCountdown`: Whether to show a countdown before a clear.
- `doNotificationSound`: Whether to play a sound when a notification is sent.
- `doLastNotificationSound`: Whether to play a sound when a last notification is sent.
- `NotificationSound`: The sound to play when a notification is sent.
- `LastNotificationSound`: The sound to play when a last notification is sent.
- `NotificationLang`: The language for notifications.
- `NotificationColor`: The color for notifications.
- `RequireOp`: Whether to require the player to be an operator to use the ICL commands.
  - ***Note:*** The configuration value is ***not used*** if the fabric-permissions mod is installed, use any permissions manager.
- `RequireOpCancel`: Whether to require the player to be an operator to cancel clear.
  - ***Note:*** The configuration value is ***not used*** if the fabric-permissions mod is installed, use any permissions manager.
- `preserveNoDespawnItems`: Whether to preserve items that are set to never despawn.
- `preserveNoPickupItems`: Whether to preserve items that are set to not be picked up.

### Advanced Item Filtering

- `preserveEnchantedItems`: Whether to preserve items with enchantments.
- `preserveModItems`: Whether to preserve non-block items from mods (non-vanilla items). Mod blocks will still be cleared, but mod tools, weapons, and other non-block items are preserved.
- `preserveRareItems`: Whether to preserve items with RARE or EPIC rarity (e.g., netherite **gear**, dragon egg, enchanted golden apples).
  - **Note**: Resource items like diamonds, netherite ingots, emeralds, and ancient debris have COMMON rarity and are NOT protected by this setting. Add them to `exemptItems` instead.
- `targetItemsOnly`: Enable blacklist mode. If true, only items in `targetItems` will be cleared.
- `exemptItems`: List of item IDs that should never be cleared (whitelist). Edit in config file. Example: `["minecraft:diamond", "minecraft:netherite_ingot"]`
- `targetItems`: List of item IDs to clear when `targetItemsOnly` is true (blacklist). Edit in config file.
- `excludedDimensions`: List of dimension IDs to exclude from item clearing. Edit in config file. Example: `["minecraft:the_nether", "minecraft:the_end"]`

**Note**: List-type configurations (`exemptItems`, `targetItems`, `excludedDimensions`) must be edited directly in the config file (`config/Icl/ICL.json`), not via commands.

## Permissions

ICL has a fabric-permissions integration, which allows you to set permissions for each command. Here are the permissions:

- `icl.forceclean`: Allows the player to use the `/icl forceclean` command.
- `icl.reload`: Allows the player to use the `/icl reload` command.
- `icl.config`: Allows the player to use the `/icl config` command.
- `icl.cancel`: Allows the player to use the `/icl cancel` command.

## License

ICL is licensed under the MIT License. See the `LICENSE` file for more details.
