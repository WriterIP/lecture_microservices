
package ua.ip.tstmicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController("/")
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private int state = new Random().nextInt();

    @RequestMapping("uuid")
    public String getUUID() {
        return "UUID: " + state;
    }

    @RequestMapping("/list")
    public List<String> serviceInstancesB() {
        return this.discoveryClient.getServices();
    }

    @RequestMapping("/listApp/{serviceName}")
    public List<ServiceInstance> serviceInstancesB(@PathVariable String serviceName) {
        return this.discoveryClient.getInstances(serviceName);
    }

    //localhost:8758/health
    //new instanceid for several replicas
    @RequestMapping("/remoteabout")
    public ServiceInstance remoteabout() {
        return this.discoveryClient.getLocalServiceInstance();
    }
}