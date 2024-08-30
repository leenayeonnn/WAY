package like.lion.way;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @Value("${serverName}") // application.yml의 값들을 매핑시킴
    private String serverName;
    @Value("${server.env}")
    private String env;
    private Integer visitedCount = 0;

    @GetMapping("/hc")
    public ResponseEntity<Map<String, String>> getServerInfo() {
        visitedCount++;

        Map<String, String> serverInfo = new HashMap<>();
        serverInfo.put("ServerName:", serverName);
        serverInfo.put("visitedCount:", visitedCount.toString());
        serverInfo.put("env:", env);

        return ResponseEntity.ok(serverInfo);
    }

    @GetMapping("/env")
    public String getEnv() {
        return env;
    }
}