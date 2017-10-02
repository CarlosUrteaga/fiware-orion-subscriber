package mx.infotec.dads.orion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import mx.infotec.dads.orion.model.Notification;
import mx.infotec.dads.orion.repository.NotificationRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MonitorApplication implements CommandLineRunner {

    @Autowired
    private NotificationRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        repository.deleteAll();
        for (Notification notification : repository.findAll()) {
            System.out.println(notification);
        }
    }
}
