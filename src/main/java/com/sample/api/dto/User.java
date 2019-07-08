package com.sample.api.dto;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private @Id
    @Column
    Long id;

    @NotNull
    @Getter
    private @Column
    String firstName;

    @NotNull
    @Getter
    private @Column
    String lastName;

    @Email
    @NotNull
    @Getter
    @NotBlank(message = "User email should not be blank")
    private @Column
    String email;

    @NotNull
    @Getter
    private @Column
    String password;

    @NotNull
    @Getter
    private @Column
    boolean awesome;

    @ManyToMany(fetch = FetchType.LAZY)
    @Getter
    @JoinTable(
            name = "user_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> userGroups = new HashSet<>();

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", awesome=" + awesome +
                ", userGroups=" + userGroups +
                '}';
    }

    public static class Builder {
        private User newUser;

        public Builder() {
            this.newUser = new User();
        }

        public Builder setFirstName(String firstName) {
            newUser.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            newUser.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder setId(Long id) {
            newUser.id = id;
            return this;
        }

        public Builder setAwesome(boolean awesome) {
            newUser.awesome = awesome;
            return this;
        }

        public Builder setUserGroups(Set<Group> userGroups) {
            newUser.userGroups = userGroups;
            return this;
        }

        public User build() {
            return newUser;
        }

    }
}
