package model;

public class User {
    private final String userName, first_name, last_name, password, email;

    private User(UserBuilder builder) {
        this.userName = builder.userName;
        this.first_name = builder.first_name;
        this.last_name = builder.last_name;
        this.password = builder.password;
        this.email = builder.email;
    }

    public String getUserName() {
        return userName;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public static class UserBuilder
    {
        private String userName;
        private String first_name;
        private String last_name;
        private String password;
        private String email;

        public UserBuilder () {
        }
        public UserBuilder userName(String userName){
            this.userName=userName;
            return this;
        }
        public UserBuilder firstName(String first_name){
            this.first_name=first_name;
            return this;
        }
        public UserBuilder last_name(String last_name) {
            this.last_name = last_name;
            return this;
        }
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            User user =  new User(this);
//            validateUserObject(user);
            return user;
        }
//        private void validateUserObject(User user) {
//            //Do some basic validations to check
//            //if user object does not break any assumption of system
//        }
    }
}

