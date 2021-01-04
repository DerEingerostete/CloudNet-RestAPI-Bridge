package api.tests;

import api.endsurve.restapi.RestAPIBridge;
import api.endsurve.restapi.entity.Wrapper;
import api.endsurve.restapi.entity.module.*;
import api.endsurve.restapi.entity.proxy.*;
import api.endsurve.restapi.entity.server.ServerGroup;

import java.util.Arrays;
import java.util.List;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class APITest {

    public static void main(String[] args) {
        String user = "USER";
        String token = "TOKEN";
        String url = "https://yourdomain.com:1420";
        RestAPIBridge.login(user, token, url);

        try {
            System.out.println("WebPort: " + RestAPIBridge.getWebPort());
            System.out.println("RegisteredPlayers: " + RestAPIBridge.getRegisteredPlayerCount());
            System.out.println("OnlineCount: " + RestAPIBridge.getOnlineCount());

            System.out.println("\n\nServerGroups:");

            List<ServerGroup> serverGroups = RestAPIBridge.getServerGroups();
            serverGroups.forEach(group -> {
                System.out.println("==============================");
                System.out.println("Name: " + group.getName());
                System.out.println("Memory: " + group.getMemory());
                System.out.println("JoinPower: " + group.getJoinPower());
                System.out.println("Mode: " + group.getMode());
                System.out.println("Settings: " + group.getSettings());
                System.out.println("NewServer: " + group.getPercentForNewServerAutomatically());
                System.out.println("AutoSaving: " + group.isAutoSavingForWorlds());
                System.out.println("Maintenance: " + group.isMaintenanceActive());
                System.out.println("OfflineNotify: " + group.isNotifyPlayerUpdatesForOffline());
                System.out.println("NotifyProxy: " + group.isNotifyProxyUpdates());
                System.out.println("NotifyServer: " + group.isNotifyServerUpdates());
                System.out.println("==============================\n\n");
            });

            System.out.println("\n\nProxyGroups:");

            List<ProxyGroup> proxyGroups = RestAPIBridge.getProxyGroups();
            proxyGroups.forEach(group -> {
                System.out.println("==============================");
                System.out.println("Name: " + group.getName());
                System.out.println("Mode: " + group.getMode());
                System.out.println("Version: " + group.getProxyVersion());
                System.out.println("Wrappers: " + Arrays.toString(group.getWrappers()));
                System.out.println("Settings: " + group.getSettings());
                System.out.println("Memory: " + group.getMemory());
                System.out.println("Startup: " + group.getStartup());
                System.out.println("StartupPort: " + group.getStartPort());
                System.out.println();

                System.out.println("==TEMPLATE==");
                ProxyTemplate template = group.getTemplate();
                System.out.println("Name: " + template.getName());
                System.out.println("Backend: " + template.getBackend());
                System.out.println("URL: " + template.getUrl());
                System.out.println("InstallablePlugins: " + Arrays.toString(template.getInstallablePlugins()));
                System.out.println("ProcessPreParameters: " + Arrays.toString(template.getProcessPreParameters()));
                System.out.println("===========\n");

                System.out.println("==CONFIG==");
                ProxyConfig config = group.getConfig();
                System.out.println("Protocol: " + config.getMaintenanceProtocol());
                System.out.println("MaxPlayers: " + config.getMaxPlayers());
                System.out.println("Whitelist: " + Arrays.toString(config.getWhitelist()));
                System.out.println("PlayerInfo: " + Arrays.toString(config.getPlayerInfo()));

                System.out.println("==FALLBACK==");
                DynamicFallback fallback = config.getFallback();
                System.out.println("Default: " + fallback.getDefaultFallback());
                System.out.println("========\n");
                System.out.println("===FALLBACKS===");
                for (FallbackGroup fallbackGroup : fallback.getFallbacks()) {
                    System.out.println("Group: " + fallbackGroup.getGroup());
                    System.out.println("Permission: " + fallbackGroup.getPermission());
                }
                System.out.println("========\n");

                System.out.println("==AUTOSLOT==");
                AutoSlot autoSlot = config.getAutoSlot();
                System.out.println("SlotSize: " + autoSlot.getDynamicSlotSize());
                System.out.println("Enabled: " + autoSlot.isEnabled());
                System.out.println("========\n");

                System.out.println("==MAINTENANCE-LAYOUT==");
                MotdLayout maintenanceLayout = config.getMaintenanceMotdLayout();
                System.out.println("FirstLine: " + maintenanceLayout.getFirstLine());
                System.out.println("LastLine: " + maintenanceLayout.getSecondLine());
                System.out.println("Lines: " + Arrays.toString(maintenanceLayout.getLines()));
                System.out.println("========\n");

                System.out.println("==LAYOUTS==");
                for (MotdLayout layout : config.getMotdsLayouts()) {
                    System.out.println("==LAYOUT==");
                    System.out.println("FirstLine: " + layout.getFirstLine());
                    System.out.println("LastLine: " + layout.getSecondLine());
                    System.out.println("Lines: " + Arrays.toString(layout.getLines()));
                    System.out.println("========");
                }
                System.out.println("========\n");

                System.out.println("==TABLIST==");
                Tablist tablist = config.getTablist();
                System.out.println("Header: " + tablist.getHeader());
                System.out.println("Footer: " + tablist.getFooter());
                System.out.println("========\n");

                System.out.println("Maintenance: " + config.isMaintenance());
                System.out.println("Enabled: " + config.isEnabled());
                System.out.println("CustomPayloadFixer: " + config.enabledCustomPayloadFixer());

                System.out.println("==============================");
            });

            System.out.println("\n\nWrappers:");

            List<Wrapper> wrappers = RestAPIBridge.getWrappers();
            wrappers.forEach(wrapper -> {
                System.out.println("==============================");
                System.out.println("ServerId: " + wrapper.getServerId());
                System.out.println("HostName: " + wrapper.getHostName());
                System.out.println("Version: " + wrapper.getVersion());
                System.out.println("Memory: " + wrapper.getMemory());
                System.out.println("AvailableProcessors: " + wrapper.getAvailableProcessors());
                System.out.println("ProcessQueueSize: " + wrapper.getProcessQueueSize());
                System.out.println("StartPort: " + wrapper.getStartPort());
                System.out.println("Ready: " + wrapper.isReady());
                System.out.println("==============================");
            });

            System.out.println("\n\nModules:");

            Module module =  RestAPIBridge.getModule();
            System.out.println("==============================");
            System.out.println("Name: " + module.getName());

            System.out.println("==PERMISSION-POOL==");
            PermissionPool pool = module.getPermissionPool();
            System.out.println("File: " + pool.getFile());
            System.out.println("Available: " + pool.isAvailable());
            System.out.println("NotifyService: " + pool.isNotifyService());

            System.out.println("==DEFAULT-PERMISSION-GROUP==");
            PermissionGroup group = pool.getDefaultGroup();
            if (group != null) {
                System.out.println("Name: " + group.getName());
                System.out.println("Color: " + group.getColor());
                System.out.println("Prefix: " + group.getPrefix());
                System.out.println("Suffix: " + group.getSuffix());
                System.out.println("Display: " + group.getDisplay());
                System.out.println("TagID: " + group.getTagId());
                System.out.println("JoinPower: " + group.getJoinPower());
                System.out.println("DefaultGroup: " + group.isDefaultGroup());
            } else System.out.println("DefaultGroup is null!");

            System.out.println("==PERMISSIONS==");
            for (Permission permission : group.getPermissions()) {
                System.out.println("Permission: " + permission.getPermission());
                System.out.println("Allowed: " + permission.isAllowed());
            }
            System.out.println("========\n");

            System.out.println("==SERVER-GROUP-PERMISSIONS==");
            group.getServerGroupPermissions().forEach((name, permissions) -> {
                System.out.println("Server: " + name);
                System.out.println("Permissions: " + Arrays.toString(permissions));
            });
            System.out.println("========\n");

            System.out.println("==OPTIONS==");
            for (Option option : group.getOptions()) {
                System.out.println("Option: " + option.getOption());
                System.out.println("Enabled: " + option.isEnabled());
            }
            System.out.println("========\n");

            System.out.println("ImplementGroups: " + Arrays.toString(group.getImplementGroups()));
            System.out.println("========\n");

            System.out.println("==SERVER-GROUPS==");
            pool.getGroups().forEach((name, permGroup) -> {
                System.out.println("===============");
                System.out.println("GivenName: " + name);
                System.out.println("Name: " + permGroup.getName());
                System.out.println("Color: " + permGroup.getColor());
                System.out.println("Prefix: " + permGroup.getPrefix());
                System.out.println("Suffix: " + permGroup.getSuffix());
                System.out.println("Display: " + permGroup.getDisplay());
                System.out.println("TagID: " + permGroup.getTagId());
                System.out.println("JoinPower: " + permGroup.getJoinPower());
                System.out.println("DefaultGroup: " + permGroup.isDefaultGroup());

                System.out.println("==PERMISSIONS==");
                for (Permission permission : permGroup.getPermissions()) {
                    System.out.println("Permission: " + permission.getPermission());
                    System.out.println("Allowed: " + permission.isAllowed());
                }
                System.out.println("========\n");

                System.out.println("==SERVER-GROUP-PERMISSIONS==");
                permGroup.getServerGroupPermissions().forEach((key, permissions) -> {
                    System.out.println("Server: " + key);
                    System.out.println("Permissions: " + Arrays.toString(permissions));
                });
                System.out.println("========\n");

                System.out.println("==OPTIONS==");
                for (Option option : permGroup.getOptions()) {
                    System.out.println("Option: " + option.getOption());
                    System.out.println("Enabled: " + option.isEnabled());
                }
                System.out.println("========\n");

                System.out.println("ImplementGroups: " + Arrays.toString(permGroup.getImplementGroups()));
                System.out.println("========\n");
                System.out.println("===============");
            });
            System.out.println("========\n");
            System.out.println("==============================");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        /*
          Logout is not required!
          It just resets the login data
         */
        RestAPIBridge.logout();
    }

}
