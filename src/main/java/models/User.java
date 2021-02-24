package models;

import com.google.gson.annotations.SerializedName;

public class User {

    private final int id;
    private final String name;
    @SerializedName("username")
    private final String userName;
    private final String email;
    private final Address address;
    private final String phone;
    private final String website;
    private final Company company;

    public User(int id, String name, String userName, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    private static class Company {
        private final String name;
        private final String catchPhrase;
        private final String bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }
    }

    private static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private GEO geo;

        private static class GEO {
            private final String lat;
            private final String lng;

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }

            public GEO(String lat, String lng) {
                this.lat = lat;
                this.lng = lng;
            }
        }
    }

    public enum UserEnum{
        DELPHINE("Delphine"),
        ANTONETTE("Antonette");

        private final String userName;

        UserEnum(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }
}

