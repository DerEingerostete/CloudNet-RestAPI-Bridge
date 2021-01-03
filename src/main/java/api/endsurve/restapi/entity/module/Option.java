package api.endsurve.restapi.entity.module;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Option {
    private final String option;
    private final boolean enabled;

    public Option(String option, boolean enabled) {
        this.option = option;
        this.enabled = enabled;
    }

    public String getOption() {
        return option;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
