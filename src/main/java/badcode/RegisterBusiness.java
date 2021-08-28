package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;

        //validation process
        validationInput(speaker);
        validationEmail(speaker);
        //Register process
        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    private void validationEmail(Speaker speaker) {
        String[] domains = {"gmail.com", "live.com"};
        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        boolean isCheckEmailDomainFormat = Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1;
        if (isCheckEmailDomainFormat) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }

    private void validationInput(Speaker speaker) {
        if (isNullOrEmpty(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }
        if (isNullOrEmpty(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (isNullOrEmpty(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }
    }

    private boolean isNullOrEmpty(String firstName) {
        return firstName == null || "".equals(firstName.trim());
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

}
