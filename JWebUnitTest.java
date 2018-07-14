package contactList;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTablePresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextInTable;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTableEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleNotEquals;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class JWebUnitTest {
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("http://user-input-test-site.herokuapp.com");
    }

    @Test
    public void testWebPage() {
        beginAt("index.html"); 
        assertTitleEquals("Contact List");
        assertTextPresent("Group Project Contact List");
        assertTablePresent("table");
        assertTextInTable("table", "Omaha");
        assertTableEquals("table", new String[][] {{"Name", "Title", "Phone#", "Address"},
            {"Hua Gao", "Project Manager", "000-000-0000", "Omaha"}, 
            {"Tim McCaslin", "Scribe", "000-000-0000", "Lincoln"}, 
            {"Yang Xiao", "Architect", "000-000-0000", "Lincoln"}, 
            {"Yifan Shi", "Quality Assurance", "000-000-0000", "Omaha"}, 
            {"Yiqun Qian", "Tech Support", "000-000-0000", "Lincoln"}});
    }
}
