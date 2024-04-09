package edu.matc.restdemo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/services")
/**
 * This class' purpose is to use the different classes for our web service by adding them all to the hashset
 */
public class HelloApplication extends Application {

    /**
     * This method's purpose is to add all the classes to be interacted with to the hashset
     * @return the hashset of all classes to be interacted with
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();

        h.add(HelloWorld.class);
        h.add(Regions.class);
        h.add(Types.class);
        h.add(Festivals.class);

        return h;
    }
}
