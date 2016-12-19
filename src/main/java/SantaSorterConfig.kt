import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

/**
 * Created by jrothwell on 18/12/2016.
 */

class SantaSorterConfig : Configuration() {
    @JsonProperty("instanceName")
    public var instanceName: String = ""
}