package edu.matc.restdemo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 * The type Festivals application.
 *
 * @author jbjohnson2
 * @author JBostroem
 * @author OscarJohnson6
 */
@ApplicationPath("/services")
public class FestivalsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();

        h.add(Regions.class);
        h.add(Types.class);
        h.add(Festivals.class);

        return h;
    }
}
