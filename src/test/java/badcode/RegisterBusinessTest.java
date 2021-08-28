package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class xxx implements SpeakerRepository {

    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return 1000;
    }
}
public class RegisterBusinessTest {
    //Test to pass
    @Test
    @DisplayName("สามารถบันทึกข้อมูลได้")
    public  void testRegisterSuccess() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Peerapon");
        speaker.setLastName("Pengsamoon");
        speaker.setEmail("peerapon@gmail.com");
        int speakerId = registerBusiness.register(new xxx(), speaker);
        assertEquals(1000, speakerId);
    }

    //Test to fail
    @Test
    @DisplayName("ไม่ทำการกำหนดชื่อ จะเกิด exception First name is required.")
    public  void testRegisterWithoutSpeakerFirstName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            registerBusiness.register(null,new Speaker());
            fail();
        } catch (ArgumentNullException e) {
        }
    }

    @Test
    @DisplayName("ไม่ทำการกำหนดนามสกุล จะเกิด exception Last name is required.")
    public  void testRegisterWithoutSpeakerLastname() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Peerapon");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (ArgumentNullException e) {
        }
    }

    @Test
    @DisplayName("ไม่ทำการกำหนด email จะเกิด exception Email is required.")
    public  void testRegisterWithoutSpeakerEmail() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Peerapon");
        speaker.setLastName("Pengsamoon");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (ArgumentNullException e) {
        }
    }

    @Test
    @DisplayName("กำหนด email ผิด จะเกิด Speaker doesn't meet our standard rules.")
    public  void testRegisterWithSpeakerInvalidEmailDomain() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Peerapon");
        speaker.setLastName("Pengsamoon");
        speaker.setEmail("peerapon@xxx.com");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (SpeakerDoesntMeetRequirementsException e) {
        }
    }

    @Test
    @DisplayName("กำหนด email ผิด จะเกิด DomainEmailInvalidException")
    public  void testRegisterWithSpeakerInvalidEmailDomainFormat() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Peerapon");
        speaker.setLastName("Pengsamoon");
        speaker.setEmail("peerapon");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (DomainEmailInvalidException e) {
        }
    }

    @Test
    @DisplayName("บันทึกไม่ได้ จะเกิด Can't save a speaker.")
    public  void testRegisterWithCantSaveSpeaker() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("peerapon");
        speaker.setLastName("pengsamoon");
        speaker.setEmail("peerapon@gmail.com");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (SaveSpeakerException e) {
        }
    }
}
