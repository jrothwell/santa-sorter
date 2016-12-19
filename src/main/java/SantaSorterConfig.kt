import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import java.util.*

/**
 * Created by jrothwell on 18/12/2016.
 */

class SantaSorterConfig : Configuration() {
    @JsonProperty("instanceName")
    public var instanceName: String = ""

    @JsonProperty("languages")
    public var languages: List<String> = ArrayList<String>()
}