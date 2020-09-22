package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port, memorylimit, instanceindex, instanceaddr;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memorylimit,
                         @Value("${cf.instance.index:NOT SET}") String  instanceindex,
                         @Value("${cf.instance.addr:NOT SET}") String instanceaddr) {
        this.port = port;
        this.memorylimit = memorylimit;
        this.instanceindex = instanceindex;
        this.instanceaddr = instanceaddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<String, String>();
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memorylimit);
        env.put("CF_INSTANCE_INDEX", instanceindex);
        env.put("CF_INSTANCE_ADDR", instanceaddr);

        return env;

    }


}
