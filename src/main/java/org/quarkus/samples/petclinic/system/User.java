package org.quarkus.samples.petclinic.system;

import org.quarkus.samples.petclinic.model.Person;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User extends Person {

    @Column(name = "email", unique = true)
    @NotEmpty
    @FormParam("email")
    public String email;

    @Column(name = "password")
    @NotEmpty
    @FormParam("password")
    public String password;

    @Column(name = "OTP")
    @NotEmpty
    @FormParam("OTP")
    public String OTP;

    @Column(name = "verified")
    @NotNull
    @FormParam("verified")
    public boolean verified;

    public static Collection<User> findByEmail(String name) {
        return User.list("email", name);
    }

    public User attach() {
        return getEntityManager().merge(this);
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
