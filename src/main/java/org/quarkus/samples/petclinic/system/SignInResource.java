package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.TemplateInstance;
import org.quarkus.samples.petclinic.owner.Owner;
import org.quarkus.samples.petclinic.utils.CommonUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;

@Path("/sign-in")
public class SignInResource {

    @Inject
    TemplatesLocale templates;

    @Inject
    AppMessages messages;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return templates.signInForm(null, null);
    }

    @POST
    @Path("/authenticate")
    @Produces(MediaType.TEXT_HTML)
    /**
     * Authenticate user credentials without exposing.
     *
     * @return
     */
    public TemplateInstance authenticate(@FormParam("email") String email, @FormParam("password") String password) {
        final Error ERROR_USER_NOT_FOUND = new Error(messages.error_user_not_found());
        final Error ERROR_USER_CREDENTIALS_NOT_SUPPLIED = new Error(messages.error_user_credentials_not_supplied());
        final Error ERROR_USER_CREDENTIALS_NOT_MATCHED = new Error(messages.error_user_credentials_not_matched());
        final Error ERROR_USER_AUTHENTICATION_HAS_FAILED = new Error(messages.error_user_authentication_has_failed());
        try {
            email = email.trim();
            if (email.isEmpty() || password.isEmpty()) {
                return templates.signInForm(email, ERROR_USER_CREDENTIALS_NOT_SUPPLIED);
            }
            password = CommonUtils.encodeWithBase64(password);
            Collection<User> hits = User.findByEmail(email);
            if (hits.isEmpty()) {
                return templates.signInForm(email, ERROR_USER_NOT_FOUND);
            }
            User user = hits.stream().findFirst().get();
            if (user.password.equals(password)) {
                if(user.verified) {
                    return templates.welcome(user);
                } else {
                    user.OTP = CommonUtils.generateOTP();
                    return templates.userDetails(user, null);
                }
            } else {
                return templates.signInForm(email, ERROR_USER_CREDENTIALS_NOT_MATCHED);
            }
        } catch (Exception e) {
            return templates.signInForm(email, ERROR_USER_AUTHENTICATION_HAS_FAILED);
        }
    }

    @GET
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    /**
     * Renders the signUpForm.html
     *
     * @return
     */
    public TemplateInstance create(@BeanParam Owner owner) {
        return templates.signUpForm(null, new HashMap<>());
    }
}
