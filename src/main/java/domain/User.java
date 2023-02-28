package domain;

import java.util.Objects;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;


    public String getUserRole() {
        return role;
    }

    public void setUserRole(String role) {
        this.role = role;
    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return firstName;
    }

    public void setUserFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserLastName() {
        return lastName;
    }

    public void setUserLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String password) {
        this.password = password;
    }

    public User(Integer id, String email, String firstName, String lastName, String password, String role) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;;
        this.role = role;
    }

    public User (String email, String firstName, String lastName,String password, String role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (email == null) {
            if (user.email != null)
                return false;
        } else if (!email.equals(user.email))
            return false;
        if (firstName == null) {
            if (user.firstName != null)
                return false;
        } else if (!firstName.equals(user.firstName))
            return false;
        if (id == null) {
            if (user.id != null)
                return false;
        } else if (!id.equals(user.id))
            return false;
        if (lastName == null) {
            if (user.lastName != null)
                return false;
        } else if (!lastName.equals(user.lastName))
            return false;
        if (role == null) {
            if (user.role != null)
                return false;
        } else if (!role.equals(user.role))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
