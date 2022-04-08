import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import phone.Contact;
import phone.PhoneBook;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestPhoneBook {

    PhoneBook phoneBook;

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
        phoneBook = new PhoneBook();
        phoneBook.createGroup("Друзья");
        Contact contact1 = new Contact("Лермонтов", "+79110001111");
        phoneBook.addContactToGroup(contact1, "Друзья");
        Contact contact2 = new Contact("Скорая", "+03");
        phoneBook.addContactToGroup(contact2, "Друзья");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }

    @ParameterizedTest
    @MethodSource("testSource")
    public void testGetContactByNumber(String n, String expected) {
        // given: arrange
        //String n = "+79110001111", expected = "Лермонтов";

        // when: act
        Contact contact = phoneBook.getContactByNumber(n);

        // then: assert
//        Assertions.assertEquals(expected, contact.getName());
//        Assertions.assertNotNull(contact);
        assertThat(contact.getName(), allOf(equalTo(expected), notNullValue()));
        assertThat(contact.getNumber(), containsString("+"));
    }

    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("+79110001111", "Лермонтов"),
                Arguments.of("+03", "Скорая")
        );
    }

    @Test
    public void testAddContactToGroup() {
        // given: arrange

        // when: act
        Contact contact = new Contact("Пушкин", "+79212221111");
        boolean result = phoneBook.addContactToGroup(contact, "Друзья");

        // then: assert
        //Assertions.assertTrue(result);
        assertThat(result, not(false));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Работа", "НеРабота"})
    public void testCreateGroup(String g) {
        // given: arrange
       // String g = "Работа";

        // when: act
        phoneBook.createGroup(g);
        Contact contact = new Contact("Иван", "+7555");
        boolean result = phoneBook.addContactToGroup(contact, g);

        // then: assert
        //Assertions.assertTrue(result);
        assertThat(result, equalTo(true));
    }
}
