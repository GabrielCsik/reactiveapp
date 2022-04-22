package com.example.diplomovkareactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "testParams")
public class TestParams {
        @Id
        private String id;
        private double numberOfUsers;
        private double numberOfMiners;
        private double hashDifficulty;
        private double duration;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public double getNumberOfUsers() {
                return numberOfUsers;
        }

        public void setNumberOfUsers(double numberOfUsers) {
                this.numberOfUsers = numberOfUsers;
        }

        public double getNumberOfMiners() {
                return numberOfMiners;
        }

        public void setNumberOfMiners(double numberOfMiners) {
                this.numberOfMiners = numberOfMiners;
        }

        public double getHashDifficulty() {
                return hashDifficulty;
        }

        public void setHashDifficulty(double hashDifficulty) {
                this.hashDifficulty = hashDifficulty;
        }

        public double getDuration() {
                return duration;
        }

        public void setDuration(double duration) {
                this.duration = duration;
        }
}
