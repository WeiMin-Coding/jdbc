package dao_.test;

import dao_.dao.ActorDAO;
import dao_.domain.Actor;
import org.junit.Test;

import java.util.List;

public class TestDAO {
    @Test
    public void testACtorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id > ?", Actor.class, 3);
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        Actor actor = actorDAO.querySingle("select * from actor where id > ?", Actor.class, 3);
        System.out.println("====查询单行结果====");
        System.out.println(actor);

        Object o = actorDAO.queryScalar("select name from actor where id > ?", 3);
        System.out.println("====查询单行单列值===");
        System.out.println(o);
    }
}
