import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    public void test1(){
        ConcreteMember c1=new ConcreteMember();
        ConcreteMember c2=new ConcreteMember();
        ConcreteMember c3=new ConcreteMember();
        ConcreteMember c4=new ConcreteMember();
        GroupAdmin groupAdmin=new GroupAdmin();
        groupAdmin.register(c1);
        groupAdmin.register(c2);
        groupAdmin.register(c3);
        groupAdmin.register(c4);
        /**
         * check register function
         */
        assertEquals(2,groupAdmin.myMembers.indexOf(c3));
        /**
         * check insert function
         */
        groupAdmin.insert(0,"current_state");
        assertEquals(groupAdmin.state,c1.state);
        assertEquals(c2, groupAdmin.myMembers.get(1));
        /**
         * check unregister function
         */
        groupAdmin.unregister(c2);
        assertEquals(-1,groupAdmin.myMembers.indexOf(c2));
        /**
         * check append function
         */
        groupAdmin.append("_state");
        assertEquals("current_state_state",groupAdmin.state_toString());
        assertEquals(null,c2.state);
        /**
         * check delete function
         */
        groupAdmin.delete(12,18);
        assertEquals("current_state",groupAdmin.state_toString());

    }
}
