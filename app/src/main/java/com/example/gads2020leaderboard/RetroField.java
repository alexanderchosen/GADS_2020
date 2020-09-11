package com.example.gads2020leaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetroField {
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private Integer lastName;
        @SerializedName("emailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("gitHubLink")
        @Expose
        private String gitHubLink;

        public RetroField(String firstName, Integer lastName, String emailAddress, String gitHubLink) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.gitHubLink = gitHubLink;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(Integer lastName) {
            this.lastName = lastName;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public void setGitHubLink(String gitHubLink) {
            this.gitHubLink = gitHubLink;
        }

        public String getFirstName() {
            return firstName;
        }

        public Integer getLastName() {
            return lastName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public String getGitHubLink() {
            return gitHubLink;
        }

        @Override
        public String toString() {
            return "RetroField{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName=" + lastName +
                    ", emailAddress='" + emailAddress + '\'' +
                    ", gitHubLink='" + gitHubLink + '\'' +
                    '}';
        }
    }
