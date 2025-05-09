package seedu.finclient.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.finclient.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's job in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidJob(String)}
 */
public class Job {
    public static final String MESSAGE_CONSTRAINTS =
            "Job title can be any string, and it should not be blank";
    public static final String VALIDATION_REGEX = "[^\\s].*";
    public final String value;

    /**
     * Constructs an {@code Job}.
     *
     * @param jobTitle A valid job title.
     */
    public Job(String jobTitle) {
        requireNonNull(jobTitle);
        checkArgument(isValidJob(jobTitle), MESSAGE_CONSTRAINTS);
        value = jobTitle;
    }

    public Job() {
        value = "";
    }

    /**
     * Returns true if a given string is a valid job title.
     */
    public static boolean isValidJob(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Job)) {
            return false;
        }

        Job otherJob = (Job) other;
        return value.equals(otherJob.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
