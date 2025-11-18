package vt.icl.config;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Configuration {
    public long Delay;
    public long NotificationDelay;
    public long NotificationStart;
    public int NotificationTimes;
    public long CountdownStart;
    public boolean doNotificationCountdown;
    public boolean doShowNotification;
    public boolean doNotificationSound;
    public boolean doLastNotificationSound;
    public String NotificationSound;
    public String LastNotificationSound;
    public String NotificationLang;
    public String NotificationColor;
    public boolean RequireOp;
    public boolean RequireOpCancel;
    public boolean preserveNoDespawnItems;
    public boolean preserveNoPickupItems;
    public boolean UsePermissionsApi;
    
    // Item filtering options
    public boolean preserveEnchantedItems;
    public boolean preserveModItems;
    public boolean preserveRareItems;
    public List<String> exemptItems;
    public boolean targetItemsOnly;
    public List<String> targetItems;
    public List<String> excludedDimensions;

    public Configuration() {
        this.Delay = 80;
        this.NotificationDelay = 15;
        this.NotificationStart = 60;
        this.NotificationTimes = 4;
        this.CountdownStart = 5;
        this.doNotificationCountdown = true;
        this.doShowNotification = true;
        this.doNotificationSound = true;
        this.doLastNotificationSound = false;
        this.NotificationSound = "block.note_block.harp";
        this.LastNotificationSound = "block.note_block.harp";
        this.NotificationLang = "en_us";
        this.NotificationColor = "RED";
        this.RequireOp = true;
        this.RequireOpCancel = false;
        this.preserveNoDespawnItems = true;
        this.preserveNoPickupItems = true;
        this.UsePermissionsApi = false;
        
        // Item filtering defaults
        this.preserveEnchantedItems = false;
        this.preserveModItems = false;
        this.preserveRareItems = false;
        this.exemptItems = new ArrayList<>();
        this.targetItemsOnly = false;
        this.targetItems = new ArrayList<>();
        this.excludedDimensions = new ArrayList<>();
    }

    public void save() {
        ConfigManager.setConfig(this);
    }

    public HashMap<String, Type> get() {
        HashMap<String, Type> map = new HashMap<>();
        map.put("Delay", long.class);
        map.put("NotificationDelay", long.class);
        map.put("NotificationStart", long.class);
        map.put("NotificationTimes", int.class);
        map.put("CountdownStart", long.class);
        map.put("doNotificationCountdown", boolean.class);
        map.put("doShowNotification", boolean.class);
        map.put("doNotificationSound", boolean.class);
        map.put("doLastNotificationSound", boolean.class);
        map.put("NotificationSound", String.class);
        map.put("LastNotificationSound", String.class);
        map.put("NotificationLang", String.class);
        map.put("NotificationColor", String.class);
        map.put("RequireOp", boolean.class);
        map.put("RequireOpCancel", boolean.class);
        map.put("preserveNoDespawnItems", boolean.class);
        map.put("preserveNoPickupItems", boolean.class);
        map.put("UsePermissionsApi", boolean.class);
        map.put("preserveEnchantedItems", boolean.class);
        map.put("preserveModItems", boolean.class);
        map.put("preserveRareItems", boolean.class);
        map.put("targetItemsOnly", boolean.class);
        return map;
    }

    public void set(Configuration configuration) {
        this.Delay = configuration.Delay;
        this.NotificationDelay = configuration.NotificationDelay;
        this.NotificationStart = configuration.NotificationStart;
        this.NotificationTimes = configuration.NotificationTimes;
        this.CountdownStart = configuration.CountdownStart;
        this.doNotificationCountdown = configuration.doNotificationCountdown;
        this.doShowNotification = configuration.doShowNotification;
        this.doNotificationSound = configuration.doNotificationSound;
        this.doLastNotificationSound = configuration.doLastNotificationSound;
        this.NotificationSound = configuration.NotificationSound;
        this.LastNotificationSound = configuration.LastNotificationSound;
        this.NotificationLang = configuration.NotificationLang;
        this.NotificationColor = configuration.NotificationColor;
        this.RequireOp = configuration.RequireOp;
        this.RequireOpCancel = configuration.RequireOpCancel;
        this.preserveNoDespawnItems = configuration.preserveNoDespawnItems;
        this.preserveNoPickupItems = configuration.preserveNoPickupItems;
        this.UsePermissionsApi = configuration.UsePermissionsApi;
        this.preserveEnchantedItems = configuration.preserveEnchantedItems;
        this.preserveModItems = configuration.preserveModItems;
        this.preserveRareItems = configuration.preserveRareItems;
        this.exemptItems = configuration.exemptItems != null ? new ArrayList<>(configuration.exemptItems) : new ArrayList<>();
        this.targetItemsOnly = configuration.targetItemsOnly;
        this.targetItems = configuration.targetItems != null ? new ArrayList<>(configuration.targetItems) : new ArrayList<>();
        this.excludedDimensions = configuration.excludedDimensions != null ? new ArrayList<>(configuration.excludedDimensions) : new ArrayList<>();
    }

    public void set(String key, String value) {
        switch (key) {
            case "Delay":
                this.Delay = Long.parseLong(value);
                break;
            case "NotificationDelay":
                this.NotificationDelay = Long.parseLong(value);
                break;
            case "NotificationStart":
                this.NotificationStart = Long.parseLong(value);
                break;
            case "NotificationTimes":
                this.NotificationTimes = Integer.parseInt(value);
                break;
            case "CountdownStart":
                this.CountdownStart = Long.parseLong(value);
                break;
            case "doNotificationCountdown":
                this.doNotificationCountdown = Boolean.parseBoolean(value);
                break;
            case "doShowNotification":
                this.doShowNotification = Boolean.parseBoolean(value);
                break;
            case "doNotificationSound":
                this.doNotificationSound = Boolean.parseBoolean(value);
                break;
            case "doLastNotificationSound":
                this.doLastNotificationSound = Boolean.parseBoolean(value);
                break;
            case "NotificationSound":
                this.NotificationSound = value;
                break;
            case "LastNotificationSound":
                this.LastNotificationSound = value;
                break;
            case "NotificationLang":
                this.NotificationLang = value;
                break;
            case "NotificationColor":
                this.NotificationColor = value;
                break;
            case "RequireOp":
                this.RequireOp = Boolean.parseBoolean(value);
                break;
            case "RequireOpCancel":
                this.RequireOpCancel = Boolean.parseBoolean(value);
                break;
            case "preserveNoDespawnItems":
                this.preserveNoDespawnItems = Boolean.parseBoolean(value);
                break;
            case "preserveNoPickupItems":
                this.preserveNoPickupItems = Boolean.parseBoolean(value);
                break;
            case "UsePermissionsApi":
                this.UsePermissionsApi = Boolean.parseBoolean(value);
                break;
            case "preserveEnchantedItems":
                this.preserveEnchantedItems = Boolean.parseBoolean(value);
                break;
            case "preserveModItems":
                this.preserveModItems = Boolean.parseBoolean(value);
                break;
            case "preserveRareItems":
                this.preserveRareItems = Boolean.parseBoolean(value);
                break;
            case "targetItemsOnly":
                this.targetItemsOnly = Boolean.parseBoolean(value);
                break;
        }
        save();
    }

    public String getValue(String key) {
        return switch (key) {
            case "Delay" -> String.valueOf(this.Delay);
            case "NotificationDelay" -> String.valueOf(this.NotificationDelay);
            case "NotificationStart" -> String.valueOf(this.NotificationStart);
            case "NotificationTimes" -> String.valueOf(this.NotificationTimes);
            case "CountdownStart" -> String.valueOf(this.CountdownStart);
            case "doNotificationCountdown" -> String.valueOf(this.doNotificationCountdown);
            case "doShowNotification" -> String.valueOf(this.doShowNotification);
            case "doNotificationSound" -> String.valueOf(this.doNotificationSound);
            case "doLastNotificationSound" -> String.valueOf(this.doLastNotificationSound);
            case "NotificationSound" -> this.NotificationSound;
            case "LastNotificationSound" -> this.LastNotificationSound;
            case "NotificationLang" -> this.NotificationLang;
            case "NotificationColor" -> this.NotificationColor;
            case "RequireOp" -> String.valueOf(this.RequireOp);
            case "RequireOpCancel" -> String.valueOf(this.RequireOpCancel);
            case "preserveNoDespawnItems" -> String.valueOf(this.preserveNoDespawnItems);
            case "preserveNoPickupItems" -> String.valueOf(this.preserveNoPickupItems);
            case "UsePermissionsApi" -> String.valueOf(this.UsePermissionsApi);
            case "preserveEnchantedItems" -> String.valueOf(this.preserveEnchantedItems);
            case "preserveModItems" -> String.valueOf(this.preserveModItems);
            case "preserveRareItems" -> String.valueOf(this.preserveRareItems);
            case "targetItemsOnly" -> String.valueOf(this.targetItemsOnly);
            case "exemptItems" -> this.exemptItems != null ? String.join(", ", this.exemptItems) : "[]";
            case "targetItems" -> this.targetItems != null ? String.join(", ", this.targetItems) : "[]";
            case "excludedDimensions" -> this.excludedDimensions != null ? String.join(", ", this.excludedDimensions) : "[]";
            default -> null;
        };
    }
}
