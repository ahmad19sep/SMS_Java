import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class PersonTest {

    @Test
    public void testGetPersonForSingletonObject() {
        Assertions.assertEquals(Person.getPerson(), Person.getPerson());
    }

    @Test
    public void testGetSetName() {
        Person ref = Person.getPerson();
        String constName = "ALI";
        ref.setName(constName);
        Assertions.assertEquals(constName, ref.getName());
    }

    @Test
    public void testPrivateConstructor() throws NoSuchMethodException {
        Constructor<Person> constructor = Person.class.getDeclaredConstructor();
        Assertions.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

}
