package api.endsurve.restapi.entity.module;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Permission {
    private String permission;
    private boolean allowed;

    public Permission(String permission, boolean allowed) {
        this.permission = permission;
        this.allowed = allowed;
    }

    public String getPermission() {
        return permission;
    }

    public boolean isAllowed() {
        return allowed;
    }

}
