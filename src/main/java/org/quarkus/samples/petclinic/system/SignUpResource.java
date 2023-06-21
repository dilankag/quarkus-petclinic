package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.TemplateInstance;
import org.quarkus.samples.petclinic.utils.CommonUtils;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Path("/sign-up")
public class SignUpResource {
    
    @Inject
    TemplatesLocale templates;

    @Inject
    Validator validator;

    @Inject
    AppMessages messages;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return templates.signUpForm(null, null);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @Transactional
    /**
     * Create new user profile.
     *
     * @return
     */
    public TemplateInstance create(@BeanParam User user) {
        final Map<String, String> errors = new HashMap<>();
        if (!User.findByEmail(user.email.trim()).isEmpty()) {
            errors.put("email", messages.error_user_already_exist() + " with email " + user.email);
            return templates.signUpForm(null, errors);
        }
        user.password = CommonUtils.encodeWithBase64(user.password);
        user.OTP = CommonUtils.generateOTP();
        final Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return templates.signUpForm(null, errors);
        } else {
            user.persist();
            return templates.userDetails(user, null);
        }
    }

    @POST
    @Path("/verify")
    @Produces(MediaType.TEXT_HTML)
    @Transactional
    /**
     * verify user through OPT.
     *
     * @return
     */
    public TemplateInstance verify(@BeanParam User user, @FormParam("OTP_V") String OTP_V) {
        final Error ERROR_OPT_NOT_MATCHED = new Error(messages.error_otp_not_matched());
        if (user.OTP.equals(OTP_V)) {
            user.verified = true;
            return templates.welcome(user);
        } else {
            return templates.userDetails(user, ERROR_OPT_NOT_MATCHED);
        }
    }
}
