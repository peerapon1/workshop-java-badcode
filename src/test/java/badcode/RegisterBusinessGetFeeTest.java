package badcode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterBusinessGetFeeTest {
    // Test to pass
    @Test
    @DisplayName("ลงทะเบียนด้วยด้วยประสบการณ์ 1 ปี")
    public void testRegisterSuccessWithExperienceOneYear() {
        Speaker speaker = new Speaker();
        int actual = speaker.getFee(1);;
        assertEquals(500, actual);
    }

    @Test
    @DisplayName("ลงทะเบียนด้วยด้วยประสบการณ์ 3 ปี")
    public void testRegisterSuccessWithExperienceThreeYear() {
        Speaker speaker = new Speaker();
        int actual = speaker.getFee(3);;
        assertEquals(250, actual);
    }

    @Test
    @DisplayName("ลงทะเบียนด้วยด้วยประสบการณ์ 5 ปี")
    public void testRegisterSuccessWithExperienceFiveYear() {
        Speaker speaker = new Speaker();
        int actual = speaker.getFee(5);;
        assertEquals(100, actual);
    }

    @Test
    @DisplayName("ลงทะเบียนด้วยด้วยประสบการณ์ 9 ปี")
    public void testRegisterSuccessWithExperienceNineYear() {
        Speaker speaker = new Speaker();
        int actual = speaker.getFee(9);;
        assertEquals(50, actual);
    }
}
