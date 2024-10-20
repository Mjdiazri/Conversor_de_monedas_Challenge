import java.net.URI;
import java.util.ArrayList;

public record Divisa(String base_code,
                     String time_last_update_utc,
                     ArrayList conversion_rates ) {
}
